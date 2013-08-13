package com.oopPlayground.designPatterns.WeatherControlSystem;

public interface IObserver<T extends State>{
    void update(T state);
}

