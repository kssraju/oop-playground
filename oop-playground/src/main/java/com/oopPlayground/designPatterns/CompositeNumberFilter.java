package com.oopPlayground.designPatterns;

import java.util.ArrayList;
import java.util.List;

public class CompositeNumberFilter implements ICompositeNumberFilter {

    List<INumberFilter> internalIdentifiers;

    public CompositeNumberFilter(List<INumberFilter> numberIdentifiers) {
        this.internalIdentifiers = numberIdentifiers;
    }

    public List<Integer> filter(int from, int to, int count) {
        return filter(from, to).subList(0, count);
    }

    public List<Integer> filter(int from, int to) {
        List<Integer> identifiedNumbers = new ArrayList<>();
        if (internalIdentifiers.size() > 0) {
            identifiedNumbers = internalIdentifiers.get(0).filter(from, to);
            for (int i = 1; i < internalIdentifiers.size(); i++) {
                identifiedNumbers = internalIdentifiers.get(i).filter(identifiedNumbers);
            }
        }
        return identifiedNumbers;
    }

    public List<Integer> filter(List<Integer> numbers, int count) {
        return filter(numbers).subList(0, count);
    }

    public List<Integer> filter(List<Integer> numbers) {
        List<Integer> identifiedNumbers = internalIdentifiers.get(0).filter(numbers);
        for (INumberFilter identifier : internalIdentifiers) {
            identifiedNumbers = identifier.filter(identifiedNumbers);
        }
        return identifiedNumbers;
    }

    public boolean isFiltered(int number) {
        for (INumberFilter identifier : internalIdentifiers) {
            if (!identifier.isFiltered(number)) {
                return false;
            }
        }
        return true;
    }
}
