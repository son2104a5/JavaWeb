package demo.ss10.controller;

import demo.ss10.model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ProfileController {

    private final String UPLOAD_DIR = "E:/JavaWeb/ss10/src/main/webapp/WEB-INF/imageUpload/";

    @GetMapping("/profile-upload-form")
    public String showForm(Model model) {
        model.addAttribute("userProfile", new UserProfile());
        return "B4/uploadForm";
    }

    @PostMapping("/profile-upload-avatar")
    public String uploadAvatar(@ModelAttribute("userProfile") UserProfile profile, Model model) {
        MultipartFile file = profile.getAvatar();
        String fileName = file.getOriginalFilename();

        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            file.transferTo(new File(UPLOAD_DIR + fileName));

            model.addAttribute("message", "Tải ảnh thành công!");
            model.addAttribute("username", profile.getUsername());
            model.addAttribute("imageUrl", "/images/" + fileName);

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi khi tải ảnh lên.");
        }

        return "B4/uploadResult";
    }
}
