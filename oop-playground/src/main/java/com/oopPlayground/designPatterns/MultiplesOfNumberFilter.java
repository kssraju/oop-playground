package com.oopPlayground.designPatterns;

import java.util.ArrayList;
import java.util.List;

public class MultiplesOfNumberFilter implements INumberFilter {

    private int multipleOf;

    public MultiplesOfNumberFilter(int number) {
        this.multipleOf = number;
    }

    public List<Integer> filter(int from, int to, int count) {
        return filter(from, to).subList(0, count);
    }

    public List<Integer> filter(int from, int to) {
        List<Integer> multiples = new ArrayList<>();
        for (int i = (from % multipleOf == 0 ? from : from + multipleOf - from % multipleOf); i <= to; i += multipleOf) {
            multiples.add(i);
        }
        return multiples;
    }

    public List<Integer> filter(List<Integer> numbers, int count) {
        return filter(numbers).subList(0, count);
    }

    public List<Integer> filter(List<Integer> numbers) {
        List<Integer> multiples = new ArrayList<>();
        for (int number : numbers) {
            if (number % multipleOf == 0) {
                multiples.add(number);
            }
        }
        return multiples;
    }

    public boolean isFiltered(int number) {
        return number % multipleOf == 0;
    }
}

