package com.oopPlayground.tdd;

public class FxCalculator {

    ExchangeRate exchangeRate;

    public FxCalculator(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public int convert(int sourceAmount, String sourceCurrency, String destinationCurrency) {
         return sourceAmount / exchangeRate.getConversionRate(sourceCurrency, destinationCurrency);
    }
}

