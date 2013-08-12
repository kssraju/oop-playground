package com.oopPlayground.designPatterns;

import java.util.List;

public class MathsWorks {

    private INumberIdentifier numberIdentifier;

    public MathsWorks(INumberIdentifier numberIdentifier) {

        this.numberIdentifier = numberIdentifier;
    }

    public List<Integer> identify(int from, int to, int count) {
        return numberIdentifier.identify(from, to, count);
    }

    public List<Integer> identify(int from, int to) {
        return numberIdentifier.identify(from, to);
    }

    public List<Integer> identify(List<Integer> numbers, int count) {
        return numberIdentifier.identify(numbers, count);
    }

    public List<Integer> identify(List<Integer> numbers) {
        return numberIdentifier.identify(numbers);
    }

    public boolean isIdentified(int number) {
        return numberIdentifier.isIdentified(number);
    }
}

