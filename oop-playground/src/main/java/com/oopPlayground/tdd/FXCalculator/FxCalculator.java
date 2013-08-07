package com.oopPlayground.tdd.FXCalculator;

public class FxCalculator {

    ExchangeRate exchangeRate;
    RateStorage rateStorage;

    public FxCalculator(ExchangeRate exchangeRate) {
        this(exchangeRate, new RateStorage());
    }

    public FxCalculator(ExchangeRate exchangeRate, RateStorage rateStorage) {
        this.exchangeRate = exchangeRate;
        this.rateStorage = rateStorage;
    }

    public int convert(int sourceAmount, String sourceCurrency, String destinationCurrency) {

        int conversionRate = rateStorage.getConversionRate(sourceCurrency, destinationCurrency);
        if (conversionRate == 0) {
            conversionRate = exchangeRate.getConversionRate(sourceCurrency, destinationCurrency);
            rateStorage.storeRate(sourceCurrency, destinationCurrency, conversionRate);
        }
        return sourceAmount / conversionRate;
    }
}

