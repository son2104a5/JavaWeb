package demo.ss08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Warehouse {
    private Long id;
    private int quantity;
    private Seeds seeds;
    private UserGame user;

    public Warehouse(int quantity, Seeds seeds, UserGame user) {
        this.quantity = quantity;
        this.seeds = seeds;
        this.user = user;
    }
}
