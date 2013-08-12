package com.oopPlayground.designPatterns;

import java.util.ArrayList;
import java.util.List;

public class CompositeNumberIdentifier implements ICompositeNumberIdentifier {

    List<INumberIdentifier> internalIdentifiers;

    public CompositeNumberIdentifier(List<INumberIdentifier> numberIdentifiers) {
        this.internalIdentifiers = numberIdentifiers;
    }

    public List<Integer> identify(int from, int to, int count) {
        return identify(from, to).subList(0, count);
    }

    public List<Integer> identify(int from, int to) {
        List<Integer> identifiedNumbers = new ArrayList<>();
        if (internalIdentifiers.size() > 0) {
            identifiedNumbers = internalIdentifiers.get(0).identify(from, to);
            for (int i = 1; i < internalIdentifiers.size(); i++) {
                identifiedNumbers = internalIdentifiers.get(i).identify(identifiedNumbers);
            }
        }
        return identifiedNumbers;
    }

    public List<Integer> identify(List<Integer> numbers, int count) {
        return identify(numbers).subList(0, count);
    }

    public List<Integer> identify(List<Integer> numbers) {
        List<Integer> identifiedNumbers = internalIdentifiers.get(0).identify(numbers);
        for (INumberIdentifier identifier : internalIdentifiers) {
            identifiedNumbers = identifier.identify(identifiedNumbers);
        }
        return identifiedNumbers;
    }

    public boolean isIdentified(int number) {
        for (INumberIdentifier identifier : internalIdentifiers) {
            if (!identifier.isIdentified(number)) {
                return false;
            }
        }
        return true;
    }
}
