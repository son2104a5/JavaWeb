package demo.ss08.service;

import demo.ss08.model.Seeds;
import demo.ss08.model.UserGame;
import demo.ss08.model.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseSeedsService {
    Optional<Warehouse> findBySeedAndUser(Seeds seed, UserGame user);
    List<Warehouse> findAllByUser(UserGame user);
    Warehouse save(Warehouse warehouseSeeds);
    Warehouse findById(int seedId);
    Object findAll();
}
