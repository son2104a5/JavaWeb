package demo.ss10.controller;

import demo.ss10.model.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentController {

    private final String UPLOAD_DIR = "E:/JavaWeb/ss10/src/main/webapp/WEB-INF/documentUpload/";

    @GetMapping("/document-form")
    public String showForm(Model model) {
        model.addAttribute("document", new Document());
        return "B5/documentForm";
    }

    @PostMapping("/upload-document")
    public String uploadDocument(@ModelAttribute("document") Document doc, Model model) {
        MultipartFile file = doc.getFile();
        String fileName = file.getOriginalFilename();

        try {
            File folder = new File(UPLOAD_DIR);
            if (!folder.exists()) folder.mkdirs();

            File savedFile = new File(UPLOAD_DIR + fileName);
            file.transferTo(savedFile);

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ss10_db", "root", "snd21804@");
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO documents(title, description, file_path) VALUES (?, ?, ?)");

            ps.setString(1, doc.getTitle());
            ps.setString(2, doc.getDescription());
            ps.setString(3, savedFile.getAbsolutePath());

            ps.executeUpdate();

            model.addAttribute("message", "Tải lên thành công!");
            model.addAttribute("docTitle", doc.getTitle());

        } catch (IOException | SQLException e) {
            e.fillInStackTrace();
            model.addAttribute("message", "Tải lên thất bại.");
        }

        return "B5/documentResult";
    }
}
