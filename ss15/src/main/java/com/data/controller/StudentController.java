package com.data.controller;

import com.data.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String showStudentList(Model model) {
        List<Student> studentList = Arrays.asList(
                new Student("S001", "Nguyễn Văn A", 20, "12A1", "a@gmail.com", "Hà Nội", "0912345678"),
                new Student("S002", "Trần Thị B", 21, "12A2", "b@gmail.com", "HCM", "0987654321"),
                new Student("S003", "Lê Văn C", 22, "12A3", "c@gmail.com", "Đà Nẵng", "0909090909")
        );
        model.addAttribute("students", studentList);
        return "b2/student-list";
    }
}
