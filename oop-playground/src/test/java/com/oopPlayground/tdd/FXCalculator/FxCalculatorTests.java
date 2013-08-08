package com.oopPlayground.tdd.FXCalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.*;

public class FxCalculatorTests {

    private FxCalculator fxCalculator;
    private ExchangeRate exchangeRate;

    @Before
    public void setup() {
        exchangeRate = mock(ExchangeRate.class);
        fxCalculator = new FxCalculator(exchangeRate);
    }

    @Test
    public void itConvertAmountFromGBPToINR() {
        int expectedINRAmount = 100;
        int GBPAmount = 200;
        String sourceCurrency = "GBP";
        String destinationCurrency = "INR";
        given(exchangeRate.getConversionRate(sourceCurrency, destinationCurrency)).willReturn(2);

        int actualINRAmount = fxCalculator.convert(GBPAmount, "GBP", "INR");

        Assert.assertEquals(expectedINRAmount, actualINRAmount);
    }

    @Test
    public void itGetsRateFromRemoteStorage() {
        int amount = 300;
        String sourceCurrency = "GBP";
        String destinationCurrency = "INR";
        int expectedAmount = 150;

        RateStorage rateStorage = mock(RateStorage.class);
        fxCalculator = new FxCalculator(exchangeRate, rateStorage);
        given(exchangeRate.getConversionRate(sourceCurrency, destinationCurrency)).willReturn(2);
        given(rateStorage.getConversionRate(sourceCurrency, destinationCurrency)).willReturn(2);

        int actualAmount = fxCalculator.convert(amount, sourceCurrency, destinationCurrency);

        Assert.assertEquals(expectedAmount, actualAmount);
        verify(rateStorage, times(1)).getConversionRate(sourceCurrency, destinationCurrency);
        verify(exchangeRate, times(0)).getConversionRate(sourceCurrency, destinationCurrency);
    }

    @Test
    public void itGetsRateFromExchangeRateWhenStorageIsEmpty() {
        int amount = 300;
        String sourceCurrency = "GBP";
        String destinationCurrency = "INR";
        int expectedAmount = 150;

        RateStorage rateStorage = mock(RateStorage.class);
        fxCalculator = new FxCalculator(exchangeRate, rateStorage);
        given(exchangeRate.getConversionRate(sourceCurrency, destinationCurrency)).willReturn(2);
        given(rateStorage.getConversionRate(sourceCurrency, destinationCurrency)).willReturn(0);

        int actualAmount = fxCalculator.convert(amount, sourceCurrency, destinationCurrency);

        Assert.assertEquals(expectedAmount, actualAmount);
        verify(rateStorage, times(1)).storeRate(sourceCurrency, destinationCurrency, 2);
    }
}
