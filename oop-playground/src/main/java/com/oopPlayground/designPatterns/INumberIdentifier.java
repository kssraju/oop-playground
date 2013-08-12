package com.oopPlayground.designPatterns;

import java.util.List;

public interface INumberIdentifier {
    List<Integer> identify(int from, int to, int count);

    List<Integer> identify(int from, int to);

    List<Integer> identify(List<Integer> numbers, int count);

    List<Integer> identify(List<Integer> numbers);

    boolean isIdentified(int number);
}

