package com.data.repository;

import com.data.model.Theater;

import java.util.List;

public interface TheaterRepository {
    List<Theater> getTheaters();
    Theater getTheaterById(Long id);
    void saveOrUpdate(Theater theater);
    void delete(Theater theater);
//    boolean hasSchedule(Long theaterId);
}
