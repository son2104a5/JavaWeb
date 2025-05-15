package demo.ss08.repository;

import java.util.Optional;

public interface SeedRepository {
    public Optional<Object> findById(Long id);
}
