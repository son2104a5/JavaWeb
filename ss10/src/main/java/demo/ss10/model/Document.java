package demo.ss10.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Document {
    private String title;
    private String description;
    private MultipartFile file;
}
