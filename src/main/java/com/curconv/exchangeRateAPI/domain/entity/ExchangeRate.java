package com.curconv.exchangeRateAPI.domain.entity;

import java.util.Map;

public class ExchangeRate {
    private final String baseCurrency;
    private final Map<String, Double> conversionRates;

    public ExchangeRate(String baseCurrency, Map<String, Double> conversionRates) {
        this.baseCurrency = baseCurrency;
        this.conversionRates = conversionRates;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", conversionRates=" + conversionRates +
                '}';
    }
}
