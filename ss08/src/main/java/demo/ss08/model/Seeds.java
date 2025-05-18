package demo.ss08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seeds {
    private int id;
    private String seedsName;
    private double price;
    private String imageUrl;
}