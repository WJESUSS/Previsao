package com.example.demo.controller;

// controller/ClimaController.java

import com.example.demo.dtos.ClimaRequestDTO;
import com.example.demo.dtos.ClimaResponseDTO;
import com.example.demo.model.ClimaCache;
import com.example.demo.servico.ClimaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clima")
@CrossOrigin(origins = "*")
public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @PostMapping
    public ResponseEntity<ClimaResponseDTO> obterClima(@Valid @RequestBody ClimaRequestDTO request) {
        try {
            ClimaCache clima = climaService.obterClima(request.cidade());

            ClimaResponseDTO response = new ClimaResponseDTO(
                    clima.getCidade(),
                    clima.getDescricao(),
                    clima.getTemperatura(),
                    clima.getSensacaoTermica(),
                    clima.getUmidade(),
                    "Dados atualizados com sucesso!"
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            ClimaResponseDTO erro = new ClimaResponseDTO(
                    request.cidade(), "Não encontrado", 0.0, 0.0, 0,
                    "Erro: " + e.getMessage()
            );
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @GetMapping("/{cidade}")
    public ResponseEntity<ClimaResponseDTO> obterPorPath(@PathVariable String cidade) {
        return obterClima(new ClimaRequestDTO(cidade));
    }
    @GetMapping
    public ResponseEntity<?> listarCidades() {
        return ResponseEntity.ok(climaService.listarCidades());
    }


}
