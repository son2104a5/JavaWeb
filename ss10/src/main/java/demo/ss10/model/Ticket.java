package demo.ss10.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private String movieTitle;
    private Date showTime;
    private List<Seat> seats;
    private double totalAmount;
}
