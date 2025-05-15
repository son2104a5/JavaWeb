package demo.ss08.service;

import demo.ss08.model.Seeds;

import java.util.List;

public interface SeedService {
    Seeds findById(Long seedId);
//    List<Seeds> findAll();
}
