package demo.ss08.controller;

import demo.ss08.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public ModelAndView showUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Nguyen Van A", 22, "2002-05-01", "a@gmail.com", "0901234567"));
        users.add(new User("Tran Thi B", 25, "1999-10-15", "b@gmail.com", "0907654321"));
        users.add(new User("Le Van C", 30, "1994-07-20", "c@gmail.com", "0912345678"));

        ModelAndView mav = new ModelAndView("userList");
        mav.addObject("users", users);
        return mav;
    }
}
