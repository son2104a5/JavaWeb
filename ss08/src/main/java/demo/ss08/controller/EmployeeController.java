package demo.ss08.controller;

import demo.ss08.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("employees", employeeList);
        return "listEmployee";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        employeeList.add(employee);
        model.addAttribute("message", "Thêm nhân viên thành công!");
        model.addAttribute("employees", employeeList);
        return "listEmployee";
    }
}
