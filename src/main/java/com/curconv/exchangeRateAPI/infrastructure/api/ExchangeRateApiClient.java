package com.curconv.exchangeRateAPI.infrastructure.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.github.cdimascio.dotenv.Dotenv;

public class ExchangeRateApiClient {
    private static final String API_URL_TEMPLATE = "https://v6.exchangerate-api.com/v6/%s/latest/USD";
    private final String apiKey;
    private final HttpClient httpClient;

    public ExchangeRateApiClient() {
        // Automatically load the .env file from src/main/resources
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("EXCHANGE_API_KEY");
        if (this.apiKey == null || this.apiKey.isEmpty()) {
            throw new IllegalStateException("API key not found. Ensure EXCHANGE_API_KEY is set in the .env file in src/main/resources.");
        }
        this.httpClient = HttpClient.newHttpClient();
    }

    public JsonObject fetchExchangeRates() {
        String apiUrl = String.format(API_URL_TEMPLATE, apiKey);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return JsonParser.parseString(response.body()).getAsJsonObject();
            } else {
                throw new RuntimeException("Failed to fetch exchange rates: HTTP " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error during API call: " + e.getMessage(), e);
        }
    }
}