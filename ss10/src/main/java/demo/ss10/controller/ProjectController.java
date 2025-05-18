package demo.ss10.controller;

import demo.ss10.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("project", new Project());
        return "B7/projectForm";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute("project") Project project, Model model) {
        // Ghi file
        if (project.getDocuments() != null && !project.getDocuments().isEmpty()) {
            for (MultipartFile file : project.getDocuments()) {
                if (!file.isEmpty()) {
                    try {
                        String uploadDir = "E:/uploads/";
                        String uniqueName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                        file.transferTo(new File(uploadDir + uniqueName));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        model.addAttribute("message", "Dự án đã được tạo thành công!");
        model.addAttribute("project", project);
        return "B7/projectSuccess";
    }

    @PostMapping("/update")
    public String updateProject() {
        return "redirect:/projects/list";
    }

    @PostMapping("/delete")
    public String deleteProject() {
        return "redirect:/projects/list";
    }
}
