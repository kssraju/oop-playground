package com.oopPlayground.designPatterns.MathsWorks;

import java.util.List;

public class MathsWorks {

    private INumberFilter numberIdentifier;

    public MathsWorks(INumberFilter numberIdentifier) {

        this.numberIdentifier = numberIdentifier;
    }

    public List<Integer> identify(int from, int to, int count) {
        return numberIdentifier.filter(from, to, count);
    }

    public List<Integer> identify(int from, int to) {
        return numberIdentifier.filter(from, to);
    }

    public List<Integer> identify(List<Integer> numbers, int count) {
        return numberIdentifier.filter(numbers, count);
    }

    public List<Integer> identify(List<Integer> numbers) {
        return numberIdentifier.filter(numbers);
    }

    public boolean isIdentified(int number) {
        return numberIdentifier.isFiltered(number);
    }
}

