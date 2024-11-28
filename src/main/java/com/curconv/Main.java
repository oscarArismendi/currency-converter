package com.curconv;

import com.curconv.exchangeRateAPI.application.ExchangeRateServiceImpl;
import com.curconv.exchangeRateAPI.domain.entity.ExchangeRate;
import com.curconv.exchangeRateAPI.domain.service.ExchangeRateService;
import com.curconv.utils.CurrencyConversionMenu;

public class Main {
    public static void main(String[] args) {
        ExchangeRateService exchangeRateService = new ExchangeRateServiceImpl();

        try {
            ExchangeRate exchangeRate = exchangeRateService.getExchangeRates();
            System.out.println("Exchange Rate Data: " + exchangeRate);
            CurrencyConversionMenu.showMenu(exchangeRate);
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}