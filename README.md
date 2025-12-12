# ☀️ Clima API Brasil  
**API RESTful de consulta de clima com cache em memória (H2) – Spring Boot 3 + Java 21**

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen.svg" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Java-21-blue.svg" alt="Java 21"/>
  <img src="https://img.shields.io/badge/H2-Database-orange.svg" alt="H2"/>
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="MIT License"/>
</p>

<p align="center">
  <strong>Projeto pronto para rodar em 10 segundos</strong>  
  Consulta clima de cidades brasileiras com cache rápido e console H2 embutido
</p>

---

## ✨ Funcionalidades Atuais

- Consulta clima por nome da cidade → `GET /api/clima/{cidade}`
- Dados em cache (H2 em memória) com 3 cidades pré-cadastradas
- Busca **case-insensitive** (São Paulo = são paulo = SÃO PAULO)
- Console H2 acessível para inspeção dos dados
- SQL formatado e exibido no console

## Endpoints

| Método | URL                    | Descrição                  | Exemplo                          |
|--------|------------------------|----------------------------|----------------------------------|
| GET    | `/api/clima/{cidade}`  | Retorna clima da cidade    | `/api/clima/rio de janeiro`      |
| GET    | `/api/clima/são paulo` | Funciona com acentos!      | `/api/clima/Curitiba`            |

### Resposta (JSON)


<hr/>

<h2>🏁 Como Rodar o Projeto (3 formas)</h2>

<h3>1️⃣ Via Maven (terminal)</h3>
<pre><code>mvn spring-boot:run</code></pre>

<h3>2️⃣ Via IntelliJ / Eclipse</h3>
<pre><code>Clique no botão verde → Run 'SuaApplication'</code></pre>

<h3>3️⃣ Após rodar, acesse:</h3>
<ul>
  <li>🌐 <b>API:</b> http://localhost:8080/api/clima/são paulo</li>
  <li>🗄️ <b>H2 Console:</b> http://localhost:8080/h2-console</li>
</ul>

<hr/>

<h2>🗄️ Configuração do Console H2</h2>

<table>
  <tr><td><b>JDBC URL:</b></td><td>jdbc:h2:mem:clima-db</td></tr>
  <tr><td><b>User:</b></td><td>sa</td></tr>
  <tr><td><b>Password:</b></td><td>(vazio)</td></tr>
</table>

<h3>Execute no console:</h3>
<pre><code>SELECT * FROM clima_cache;</code></pre>

<hr/>

<h2>🌱 Dados Iniciais (data.sql)</h2>

<pre><code>INSERT INTO clima_cache (cidade, descricao, temperatura, sensacao_termica, umidade, atualizado_em)
VALUES ('são paulo', 'céu limpo', 28.5, 30.1, 60, CURRENT_TIMESTAMP());

INSERT INTO clima_cache (cidade, descricao, temperatura, sensacao_termica, umidade, atualizado_em)
VALUES ('rio de janeiro', 'ensolarado', 32.0, 35.0, 55, CURRENT_TIMESTAMP());

INSERT INTO clima_cache (cidade, descricao, temperatura, sensacao_termica, umidade, atualizado_em)
VALUES ('curitiba', 'nublado', 18.2, 17.0, 80, CURRENT_TIMESTAMP());
</code></pre>

<hr/>

<h2>📡 Endpoint Principal</h2>

<h3>🔎 Consultar Clima por Cidade</h3>

<pre><code>GET /api/clima/{cidade}
</code></pre>

<h3>Exemplo de Resposta:</h3>




```json
{
  "cidade": "curitiba",
  "descricao": "nublado",
  "temperatura": 18.2,
  "sensacaoTermica": 17.0,
  "umidade": 80,
  "atualizadoEm": "2025-12-11T18:20:23"
}

