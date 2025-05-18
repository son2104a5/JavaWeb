package demo.ss09.controller;


import javax.servlet.http.HttpSession;
import demo.ss09.utils.ConnectionDB;
import demo.ss09.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // login.html
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM Customer WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setUsername(rs.getString("username"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("address"));
                customer.setGender(rs.getString("gender"));
                customer.setEmail(rs.getString("email"));

                session.setAttribute("loggedInCustomer", customer);
                return "redirect:/home";
            } else {
                model.addAttribute("error", "Thông tin đăng nhập không đúng!");
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi hệ thống!");
            return "login";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}

