package com.data.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
    private Long id;
    private Long idProduct;
    private Long idUser;
    private int rating;
    private String comment;
}
