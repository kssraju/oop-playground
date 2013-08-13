package com.oopPlayground.designPatterns.WeatherControlSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T extends State> implements IObservable<T> {

    List<IObserver<T>> observers;

    public Observable(){
        observers = new ArrayList<>();
    }

    public void addObserver(IObserver<T> observer) {
        observers.add(observer);
    }

    public void removeObservers(IObserver<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers(T state) {
        for (IObserver observer : observers) {
            observer.update(state);
        }
    }
}
