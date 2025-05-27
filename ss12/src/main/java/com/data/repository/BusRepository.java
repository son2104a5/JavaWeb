package com.data.repository;

import com.data.dto.BusDTO;
import com.data.model.Bus;
import java.util.List;

public interface BusRepository {
    void save(BusDTO bus);
    void update(BusDTO bus);
    void delete(int id);
    Bus findById(int id);
    List<Bus> findAll();
}
