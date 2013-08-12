package com.oopPlayground.designPatterns;

import java.util.List;

public interface ICompositeNumberIdentifier extends INumberIdentifier {
    List<INumberIdentifier> internalIdentifiers = null;
}

