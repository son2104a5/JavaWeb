package com.data.controller;

import com.data.dto.StudentDTO;
import com.data.model.Student;
import com.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "b1/listStudent";
    }

    @GetMapping("add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "b1/addForm";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentDTO student,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "b1/addForm";
        }
        studentService.addStudent(student);
        return "redirect:/students";
    }


    @GetMapping("edit/{id}")
    public String editStudentForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "b1/updateForm";
    }

    @PostMapping("/edit")
    public String editStudent(@Valid @ModelAttribute("student") StudentDTO student, Model model, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("students", studentService.getAllStudents());
            return "b1/updateForm";
        }
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") int id, Model model) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
