package com.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "theater")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên rạp không được để trống")
    private String theaterName;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @Min(value = 1, message = "Số phòng chiếu phải > 0")
    private Integer numberScreenRoom;

    private Boolean status;
}
