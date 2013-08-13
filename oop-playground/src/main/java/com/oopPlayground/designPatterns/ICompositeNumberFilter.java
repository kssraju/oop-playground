package com.oopPlayground.designPatterns;

import java.util.List;

public interface ICompositeNumberFilter extends INumberFilter {
    List<INumberFilter> internalIdentifiers = null;
}

