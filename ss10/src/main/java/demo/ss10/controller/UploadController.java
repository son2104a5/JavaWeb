package demo.ss10.controller;

import demo.ss10.model.UploadFile;
import demo.ss10.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("/upload-form")
    public String showForm(Model model) {
        model.addAttribute("uploadFile", new UploadFile());
        return "B6/uploadForm";
    }

    @PostMapping("/upload-file")
    public String uploadFile(@ModelAttribute("uploadFile") UploadFile uploadFile, Model model) {
        MultipartFile file = uploadFile.getFile();
        String url = "";

        try {
            url = cloudinaryService.uploadFile(file);

            // Lưu thông tin vào CSDL
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_db", "root", "password");
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO uploads(description, file_url) VALUES (?, ?)");

            ps.setString(1, uploadFile.getDescription());
            ps.setString(2, url);

            ps.executeUpdate();

            model.addAttribute("message", "Tải file lên thành công!");
            model.addAttribute("fileUrl", url);
            model.addAttribute("desc", uploadFile.getDescription());

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi khi tải file lên.");
        }

        return "B6/uploadResult";
    }
}
