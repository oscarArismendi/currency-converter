package com.curconv;

import com.curconv.exchangeRateAPI.application.ExchangeRateServiceImpl;
import com.curconv.exchangeRateAPI.domain.entity.ExchangeRate;
import com.curconv.exchangeRateAPI.domain.service.ExchangeRateService;

public class Main {
    public static void main(String[] args) {
        ExchangeRateService exchangeRateService = new ExchangeRateServiceImpl();

        try {
            ExchangeRate exchangeRate = exchangeRateService.getExchangeRates();
            System.out.println("Exchange Rate Data: " + exchangeRate);
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}