package com.example.demo.repositorio;

import com.example.demo.model.ClimaCache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimaRepository extends JpaRepository<ClimaCache, Long> {
}
