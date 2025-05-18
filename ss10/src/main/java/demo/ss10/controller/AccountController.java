package demo.ss10.controller;

import demo.ss10.model.Account;
import demo.ss10.repository.AccountDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;

@Controller
public class AccountController {

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new Account());
        return "B3/registerForm";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("account") Account account, Model model) {
        try {
            // Kết nối tạm, nên dùng DataSource nếu nâng cao
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_db", "root", "password");

            AccountDao dao = new AccountDao(conn);
            dao.save(account);

            model.addAttribute("message", "Đăng ký thành công!");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Đăng ký thất bại!");
        }
        return "B3/registerResult";
    }
}
