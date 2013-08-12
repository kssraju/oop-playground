package com.oopPlayground.designPatterns;

import java.util.ArrayList;
import java.util.List;

public class MultiplesOfNumberIdentifier implements INumberIdentifier {

    private int multipleOf;

    public MultiplesOfNumberIdentifier(int number) {
        this.multipleOf = number;
    }

    public List<Integer> identify(int from, int to, int count) {
        return identify(from, to).subList(0, count);
    }

    public List<Integer> identify(int from, int to) {
        List<Integer> multiples = new ArrayList<>();
        for (int i = (from % multipleOf == 0 ? from : from + multipleOf - from % multipleOf); i <= to; i += multipleOf) {
            multiples.add(i);
        }
        return multiples;
    }

    public List<Integer> identify(List<Integer> numbers, int count) {
        return identify(numbers).subList(0, count);
    }

    public List<Integer> identify(List<Integer> numbers) {
        List<Integer> multiples = new ArrayList<>();
        for (int number : numbers) {
            if (number % multipleOf == 0) {
                multiples.add(number);
            }
        }
        return multiples;
    }

    public boolean isIdentified(int number) {
        return number % multipleOf == 0;
    }
}

