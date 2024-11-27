package com.curconv.exchangeRateAPI.application;

import java.util.HashMap;
import java.util.Map;

import com.curconv.exchangeRateAPI.domain.entity.ExchangeRate;
import com.curconv.exchangeRateAPI.domain.service.ExchangeRateService;
import com.curconv.exchangeRateAPI.infrastructure.api.ExchangeRateApiClient;
import com.google.gson.JsonObject;

public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateApiClient apiClient;

    public ExchangeRateServiceImpl() {
        this.apiClient = new ExchangeRateApiClient();
    }

    @Override
    public ExchangeRate getExchangeRates() {
        JsonObject response = apiClient.fetchExchangeRates();

        String baseCurrency = response.get("base_code").getAsString();
        JsonObject ratesJson = response.getAsJsonObject("conversion_rates");

        Map<String, Double> conversionRates = new HashMap<>();
        ratesJson.entrySet().forEach(entry -> conversionRates.put(entry.getKey(), entry.getValue().getAsDouble()));

        return new ExchangeRate(baseCurrency, conversionRates);
    }
}

