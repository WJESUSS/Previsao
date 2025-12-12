package com.example.demo.model;

// model/ClimaCache.java


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clima_cache")
public class ClimaCache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cidade;

    private String descricao;
    private Double temperatura;
    private Double sensacaoTermica;
    private Integer umidade;
    private LocalDateTime atualizadoEm;

    // Construtores
    public ClimaCache() {}

    public ClimaCache(String cidade, String descricao, Double temperatura,
                      Double sensacaoTermica, Integer umidade) {
        this.cidade = cidade.toLowerCase().trim();
        this.descricao = descricao;
        this.temperatura = temperatura;
        this.sensacaoTermica = sensacaoTermica;
        this.umidade = umidade;
        this.atualizadoEm = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getTemperatura() { return temperatura; }
    public void setTemperatura(Double temperatura) { this.temperatura = temperatura; }

    public Double getSensacaoTermica() { return sensacaoTermica; }
    public void setSensacaoTermica(Double sensacaoTermica) { this.sensacaoTermica = sensacaoTermica; }

    public Integer getUmidade() { return umidade; }
    public void setUmidade(Integer umidade) { this.umidade = umidade; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}
