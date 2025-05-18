package demo.ss08.repository;


import demo.ss08.model.Seeds;
import demo.ss08.model.UserGame;
import demo.ss08.model.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseSeedsRepository {
    Optional<Warehouse> findBySeedsAndUser(Seeds seed, UserGame user);
    List<Warehouse> findAllByUser(UserGame user);
    Warehouse save(Warehouse warehouse);
    Warehouse findById(int seedId);
    List<Warehouse> findAll();
}
