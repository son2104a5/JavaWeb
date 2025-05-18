package demo.ss10.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Data
public class Project {
    private Long id;
    private String name;
    private String description;
    private List<MultipartFile> documents;
}

