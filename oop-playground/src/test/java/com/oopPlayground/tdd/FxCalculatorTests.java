package com.oopPlayground.tdd;

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
        given(exchangeRate.getConversionRate("GBP", "INR")).willReturn(2);

        int actualINRAmount = fxCalculator.convert(GBPAmount, "GBP", "INR");

        Assert.assertEquals(expectedINRAmount, actualINRAmount);
    }
}
