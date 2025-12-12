🌤️ API de Clima – Spring Boot

API para consultar e armazenar dados de clima com cache interno, usando Java 21, Spring Boot, H2 Database e arquitetura limpa.

🚀 Tecnologias Usadas

Java 21

Spring Boot 3

Spring Web

Spring Data JPA

H2 Database (modo dev)

Validation (Jakarta)

Maven

src/main/java/com/example/demo
 ├── controller
 │    └── ClimaController.java
 ├── dtos
 │    ├── ClimaRequestDTO.java
 │    └── ClimaResponseDTO.java
 ├── model
 │    └── ClimaCache.java
 ├── servico
 │    └── ClimaService.java
 └── repository
      └── ClimaRepository.java
spring.datasource.url=jdbc:h2:mem:clima-db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console


INSERT INTO clima_cache (cidade, descricao, temperatura, sensacao_termica, umidade, atualizado_em)
VALUES ('são paulo', 'céu limpo', 28.5, 30.1, 60, CURRENT_TIMESTAMP());

INSERT INTO clima_cache (cidade, descricao, temperatura, sensacao_termica, umidade, atualizado_em)
VALUES ('rio de janeiro', 'ensolarado', 32.0, 35.0, 55, CURRENT_TIMESTAMP());

INSERT INTO clima_cache (cidade, descricao, temperatura, sensacao_termica, umidade, atualizado_em)
VALUES ('curitiba', 'nublado', 18.2, 17.0, 80, CURRENT_TIMESTAMP());


📡 Endpoints
🔎 Consultar Clima por Cidade

GET /api/clima/{cidade}

Resposta:

{
  "cidade": "curitiba",
  "descricao": "nublado",
  "temperatura": 18.2,
  "sensacaoTermica": 17.0,
  "umidade": 80,
  "atualizadoEm": "2025-12-11T18:20:23"
}

📌 Exemplo de Entidade
public ClimaCache(String cidade, String descricao, Double temperatura,
                  Double sensacaoTermica, Integer umidade) {
    this.cidade = cidade.toLowerCase().trim();
    this.descricao = descricao;
    this.temperatura = temperatura;
    this.sensacaoTermica = sensacaoTermica;
    this.umidade = umidade;
    this.atualizadoEm = LocalDateTime.now();
}

🖥️ Acessar H2 Console

Abra no navegador:

http://localhost:8080/h2-console


Usar:

JDBC URL: jdbc:h2:mem:clima-db
User: sa
Password: (vazio)


Rode:

SELECT * FROM clima_cache;

🧰 Como Rodar o Projeto
mvn spring-boot:run


Ou pela IDE:

IntelliJ → Run → Spring Boot App

💡 Melhorias futuras

Integração com API externa de clima (OpenWeather)

Cache com expiração automática

Autenticação JWT

Logs estruturados

Dockerfile + Docker Compose
