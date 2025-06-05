package com.data.service;

import com.data.model.Theater;

import java.util.List;

public interface TheaterService {
    List<Theater> getAllTheaters();
    Theater getTheaterById(Long id);
    void save(Theater theater);
    void deleteOrDisable(Long id);
}
