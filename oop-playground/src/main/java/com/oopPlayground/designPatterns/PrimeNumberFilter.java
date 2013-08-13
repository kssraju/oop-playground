package com.oopPlayground.designPatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumberFilter implements INumberFilter {

    public List<Integer> filter(int from, int to, int count) {
        return filter(from, to).subList(0, count);
    }

    public List<Integer> filter(int from, int to) {
        List<Integer> primeNumbers = new ArrayList<>();
        createPrimeSieve(to);
        for (int i = from; i < to; i++) {
            if (isSievedPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    public List<Integer> filter(List<Integer> numbers, int count) {
        return filter(numbers).subList(0, count);
    }

    public List<Integer> filter(List<Integer> numbers) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }
        return primeNumbers;
    }

    public boolean isFiltered(int number) {
        return isPrime(number);
    }

    private boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private boolean[] primes;

    private boolean isSievedPrime(int number) {
        return primes[number];
    }

    private void createPrimeSieve(int size) {
        primes = new boolean[size];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }
}
