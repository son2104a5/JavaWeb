package demo.ss08.service;

import demo.ss08.model.Seeds;
import demo.ss08.repository.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedServiceImpl implements SeedService {
    @Autowired
    private SeedRepository seedRepository;

    @Override
    public Seeds findById(Long id) {
        return (Seeds) seedRepository.findById(id).orElse(null);
    }
//
//    @Override
//    public List<Seeds> findAll() {
//        return seedRepository.findAll();
//    }
}
