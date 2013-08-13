package com.oopPlayground.designPatterns.MathsWorks;

import java.util.List;

public interface ICompositeNumberFilter extends INumberFilter {
    List<INumberFilter> internalIdentifiers = null;
}

