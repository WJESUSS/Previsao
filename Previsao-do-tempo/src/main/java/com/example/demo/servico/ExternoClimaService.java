package com.example.demo.servico;




import com.example.demo.config.OpenWeatherConfig;
import com.example.demo.model.ClimaCache;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.json.JSONObject;




@Service
public class ExternoClimaService {

    private final WebClient webClient;
    private final OpenWeatherConfig config;

    public ExternoClimaService(WebClient.Builder webClientBuilder, OpenWeatherConfig config) {
        this.webClient = webClientBuilder.build();
        this.config = config;
    }

    public Mono<ClimaCache> buscarClimaAtual(String cidade) {
        String url = config.getUrl() + "?q=" + cidade + "&appid=" + config.getApiKey() + "&units=metric&lang=pt_br";

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> {
                    JSONObject json = new JSONObject(response);

                    if (json.has("cod") && json.getInt("cod") != 200) {
                        throw new RuntimeException("Cidade não encontrada: " + cidade);
                    }

                    String descricao = json.getJSONArray("weather")
                            .getJSONObject(0).getString("description");

                    JSONObject main = json.getJSONObject("main");

                    double temp = main.getDouble("temp");
                    double sensacao = main.getDouble("feels_like");
                    int umidade = main.getInt("humidity");

                    return new ClimaCache(cidade, descricao, temp, sensacao, umidade);
                });
    }
}