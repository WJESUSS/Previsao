package com.example.demo.dtos;

// dto/ClimaResponseDTO.jav

public record ClimaResponseDTO(
        String cidade,
        String descricao,
        Double temperaturaCelsius,
        Double sensacaoTermica,
        Integer umidade,
        String mensagem
) { }