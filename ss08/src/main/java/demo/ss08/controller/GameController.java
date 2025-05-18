package demo.ss08.controller;

import demo.ss08.model.Seeds;
import demo.ss08.model.UserGame;
import demo.ss08.model.Warehouse;
import demo.ss08.service.FarmService;
import demo.ss08.service.SeedService;
import demo.ss08.service.UserService;
import demo.ss08.service.WarehouseSeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

@Controller
@SessionAttributes("loggedInUser")
public class GameController {

    @Autowired private UserService userService;
    @Autowired private SeedService seedService;
    @Autowired
    private WarehouseSeedsService warehouseSeedsService;
    @Autowired
    private FarmService farmService;


    private List<Seeds> seedList = Arrays.asList(
            new Seeds(1, "Cà rốt", 500, "img/carrot.png"),
            new Seeds(2, "Khoai tây", 400, "img/potato.png"),
            new Seeds(3, "Lúa", 600, "img/rice.png")
    );

    private List<UserGame> users = new ArrayList<>();

    @GetMapping("/home")
    public String home(Model model, @ModelAttribute("loggedInUser") Optional<UserGame> user) {
        if (!user.isPresent()) return "redirect:/registerGame";
        return "home";
    }

    @GetMapping("/registerGame")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserGame());
        return "register";
    }

    @PostMapping("/registerGame")
    public String handleRegister(@ModelAttribute UserGame user, Model model) {
        users.add(user);
        model.addAttribute("loggedInUser", user);
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserGame());
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute UserGame user, Model model) {
        for (UserGame u : users) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                model.addAttribute("loggedInUser", u);
                return "redirect:/";
            }
        }
        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
        return "login";
    }

    @GetMapping("/shop")
    public String shop(Model model, @ModelAttribute("loggedInUser") Optional<UserGame> user) {
        if (!user.isPresent()) return "redirect:/register";
        model.addAttribute("seeds", seedList);
        return "shop";
    }

    @ModelAttribute("loggedInUser")
    public Optional<UserGame> getLoggedInUser() {
        return Optional.empty();
    }

    @PostMapping("/buy-seed")
    public String buySeed(@RequestParam("seedId") Long seedId,
                          @RequestParam("quantity") int quantity,
                          Principal principal,
                          Model model) {

        UserGame user = userService.findByUsername(principal.getName());
        Seeds seed = seedService.findById(seedId);

        if (user == null || seed == null) {
            model.addAttribute("error", "User hoặc hạt giống không tồn tại");
            return "error";
        }

        double totalPrice = seed.getPrice() * quantity;
        if (user.getBalance() < totalPrice) {
            model.addAttribute("error", "Số dư không đủ");
            return "error";
        }

        user.setBalance(user.getBalance() - totalPrice);
        userService.updateUser(user);

        Optional<Warehouse> optionalWarehouseSeeds = warehouseSeedsService.findBySeedAndUser(seed, user);
        Warehouse warehouseSeeds;
        if (optionalWarehouseSeeds.isPresent()) {
            warehouseSeeds = optionalWarehouseSeeds.get();
            warehouseSeeds.setQuantity(warehouseSeeds.getQuantity() + quantity);
        } else {
            warehouseSeeds = new Warehouse(quantity, seed, user);
        }
        warehouseSeedsService.save(warehouseSeeds);

        return "redirect:/game/warehouse";
    }

    @GetMapping("/warehouse")
    public String viewWarehouse(Principal principal, Model model) {
        UserGame user = userService.findByUsername(principal.getName());
        if (user == null) return "redirect:/login";

        List<Warehouse> warehouseSeedsList = warehouseSeedsService.findAllByUser(user);
        model.addAttribute("warehouseSeedsList", warehouseSeedsList);

        return "warehouse";
    }

    @GetMapping("/farm")
    public ModelAndView showFarm() {
        ModelAndView mav = new ModelAndView("farm");
        mav.addObject("landPlots", farmService.getLandPlots());
        mav.addObject("warehouseSeeds", warehouseSeedsService.findAll());
        return mav;
    }

    @PostMapping("/plant")
    public String plantSeed(@RequestParam int plotId, @RequestParam int seedId) {
        farmService.plantSeed(plotId, seedId);
        return "redirect:/game/farm";
    }
}
