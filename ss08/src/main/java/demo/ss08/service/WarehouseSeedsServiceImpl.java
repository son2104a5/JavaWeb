package demo.ss08.service;

import demo.ss08.model.Seeds;
import demo.ss08.model.UserGame;
import demo.ss08.model.Warehouse;
import demo.ss08.repository.WarehouseSeedsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseSeedsServiceImpl implements WarehouseSeedsService {
    @Autowired
    private WarehouseSeedsRepository warehouseSeedsRepository;

    @Override
    public Warehouse save(Warehouse warehouse) {
        return warehouseSeedsRepository.save(warehouse);
    }

    @Override
    public Warehouse findById(int seedId) {
        return warehouseSeedsRepository.findById(seedId);
    }

    @Override
    public List<Warehouse> findAll() {
        return warehouseSeedsRepository.findAll();
    }

    @Override
    public Optional<Warehouse> findBySeedAndUser(Seeds seed, UserGame user) {
        return warehouseSeedsRepository.findBySeedsAndUser(seed, user);
    }

    @Override
    public List<Warehouse> findAllByUser(UserGame user) {
        return warehouseSeedsRepository.findAllByUser(user);
    }
}
