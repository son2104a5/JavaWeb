package com.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private int id;
    private String nameSeat;
    private BigDecimal price;
    private String status;
    private int busId;
}
