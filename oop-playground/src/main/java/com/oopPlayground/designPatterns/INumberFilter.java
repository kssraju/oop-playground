package com.oopPlayground.designPatterns;

import java.util.List;

public interface INumberFilter {
    List<Integer> filter(int from, int to, int count);

    List<Integer> filter(int from, int to);

    List<Integer> filter(List<Integer> numbers, int count);

    List<Integer> filter(List<Integer> numbers);

    boolean isFiltered(int number);
}

