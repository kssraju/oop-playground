package com.oopPlayground.designPatterns.WeatherControlSystem;

public interface IObservable<T extends State> {
    public void addObserver(IObserver<T> observer);

    void removeObservers(IObserver<T> observer);

    void notifyObservers(T state);
}

