package com.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên phim không được để trống")
    private String title;

    @NotBlank(message = "Đạo diễn không được để trống")
    private String director;

    @Min(value = 1900, message = "Năm phát hành phải >= 1900")
    @Max(value = 2100, message = "Năm phát hành không hợp lệ")
    private Integer releaseYear;

    private String genre;

    @Min(value = 1, message = "Thời lượng phải lớn hơn 0")
    private Integer duration;

    private String language;

    @Pattern(regexp = "^(http|https)://.*$", message = "URL poster không hợp lệ")
    private String poster;

    private Boolean status;
}
