package com.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class BusDTO {
    private int id;

    @NotBlank(message = "Biển số xe không được để trống")
    private String licensePlate;

    @NotBlank(message = "Loại xe không được để trống")
    private String busType;

    @Min(value = 1, message = "Số hàng phải lớn hơn 0")
    private int rowSeat;

    @Min(value = 1, message = "Số cột phải lớn hơn 0")
    private int colSeat;

    private String image;
}

