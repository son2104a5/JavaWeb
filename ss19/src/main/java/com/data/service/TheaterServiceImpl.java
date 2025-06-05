package com.data.service;

import com.data.model.Theater;
import com.data.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    private TheaterRepository theaterRepo;

    @Override
    public List<Theater> getAllTheaters() {
        return theaterRepo.getTheaters();
    }

    @Override
    public Theater getTheaterById(Long id) {
        return theaterRepo.getTheaterById(id);
    }

    @Override
    public void save(Theater theater) {
        theaterRepo.saveOrUpdate(theater);
    }

    @Override
    public void deleteOrDisable(Long id) {
        Theater t = theaterRepo.getTheaterById(id);
//        if (t != null) {
//            if (theaterRepo.hasSchedule(id)) {
//                t.setStatus(false); // ngừng hoạt động
//                theaterRepo.saveOrUpdate(t);
//            } else {
                theaterRepo.delete(t);
//            }
//        }
    }
}
