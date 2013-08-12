package com.oopPlayground.designPatterns;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathsWorksSpec {

    private MathsWorks mathsWorks;
    private INumberIdentifier evenIdentifier;
    private INumberIdentifier primeIdentifier;
    private INumberIdentifier multiplesOfNumberIdentifier;

    @Before
    public void setup() {
        evenIdentifier = new EvenNumberIdentifier();
        primeIdentifier = new PrimeNumberIdentifier();
    }

    @Test
    public void shouldIdentifyPrimeNumbers() {
        mathsWorks = new MathsWorks(primeIdentifier);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);

        List<Integer> actual = mathsWorks.identify(1, 10);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldIdentifyEvenNumbers() {
        mathsWorks = new MathsWorks(evenIdentifier);
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> actual = mathsWorks.identify(1, 10);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldIdentifyEvenPrimes() {
        INumberIdentifier evenPrimeIdentifier = new CompositeNumberIdentifier(Arrays.asList(evenIdentifier, primeIdentifier));
        mathsWorks = new MathsWorks(evenPrimeIdentifier);
        List<Integer> expected = Arrays.asList(2);

        List<Integer> actual = mathsWorks.identify(1, 10);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldIdentifyMultiplesOfFive() {
        multiplesOfNumberIdentifier = new MultiplesOfNumberIdentifier(5);
        mathsWorks = new MathsWorks(multiplesOfNumberIdentifier);
        List<Integer> expected = Arrays.asList(5, 10);

        List<Integer> actual = mathsWorks.identify(1, 10);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldIdentifyEvenMultiplesOfFive() {
        multiplesOfNumberIdentifier = new MultiplesOfNumberIdentifier(5);
        INumberIdentifier evenMultiplesOfFiveIdentifier = new CompositeNumberIdentifier(Arrays.asList(evenIdentifier, multiplesOfNumberIdentifier));
        mathsWorks = new MathsWorks(evenMultiplesOfFiveIdentifier);
        List<Integer> expected = Arrays.asList(10);

        List<Integer> actual = mathsWorks.identify(1, 10);

        Assert.assertEquals(expected, actual);
    }
}
