package demo.ss10.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFile {
    private MultipartFile file;
    private String description;
}
