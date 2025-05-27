package com.data.service;

import com.data.dto.BusDTO;
import com.data.model.Bus;
import com.data.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public void save(BusDTO bus) {
        busRepository.save(bus);
    }

    @Override
    public void update(BusDTO bus) {
        busRepository.update(bus);
    }

    @Override
    public void delete(int id) {
        busRepository.delete(id);
    }

    @Override
    public Bus findById(int id) {
        return busRepository.findById(id);
    }

    @Override
    public List<Bus> findAll() {
        return busRepository.findAll();
    }
}
