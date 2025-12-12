package com.example.demo.repositorio;

// repository/ClimaCacheRepository.java

import com.example.demo.model.ClimaCache;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClimaCacheRepository extends JpaRepository<ClimaCache, Long> {
    Optional<ClimaCache> findByCidade(String cidade);
}
