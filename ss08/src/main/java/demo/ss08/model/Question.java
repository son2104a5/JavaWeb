package demo.ss08.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private int id;
    private String imageUrl;
    private String answer;
}

