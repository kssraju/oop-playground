package com.oopPlayground.designPatterns.ObserverPattern;

public interface IObservable<T extends State> {
    public void addObserver(IObserver<T> observer);

    void removeObservers(IObserver<T> observer);

    void notifyObservers(T state);
}

