package com.example.demo.config;

// config/OpenWeatherConfig.java

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "openweather")
public class OpenWeatherConfig {
    private String apiKey;
    private String url;

    // getters e setters
    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}