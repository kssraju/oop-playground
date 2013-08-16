package com.oopPlayground.designPatterns.ObserverPattern;

public interface IObserver<T extends State>{
    void update(T state);
}

