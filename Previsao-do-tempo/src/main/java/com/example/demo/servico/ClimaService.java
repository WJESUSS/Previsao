package com.example.demo.servico;

// service/ClimaService.java

import com.example.demo.model.ClimaCache;
import com.example.demo.repositorio.ClimaCacheRepository;
import com.example.demo.repositorio.ClimaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClimaService {

    private final ClimaRepository climaRepository;
    private final ClimaCacheRepository repository;
    private final ExternoClimaService externoService;

    public ClimaService(ClimaRepository climaRepository, ClimaCacheRepository repository, ExternoClimaService externoService) {
        this.climaRepository = climaRepository;
        this.repository = repository;
        this.externoService = externoService;
    }

    public ClimaCache obterClima(String cidade) {
        String cidadeLower = cidade.toLowerCase().trim();

        var cacheOpt = repository.findByCidade(cidadeLower);

        if (cacheOpt.isPresent()) {
            ClimaCache cache = cacheOpt.get();
            if (cache.getAtualizadoEm().isAfter(LocalDateTime.now().minusMinutes(10))) {
                return cache;
            }

        }

        // Busca externa
        try {
            ClimaCache novoClima = externoService.buscarClimaAtual(cidadeLower).block();

            if (novoClima != null) {
                repository.save(novoClima);
                return novoClima;
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar clima externo: " + e.getMessage());
        }

        return cacheOpt.orElseThrow(() ->
                new RuntimeException("Não foi possível obter o clima para " + cidade));
    }
    public List<ClimaCache> listarCidades() {
        return climaRepository.findAll(); // ou sua lista em memória
    }

}
