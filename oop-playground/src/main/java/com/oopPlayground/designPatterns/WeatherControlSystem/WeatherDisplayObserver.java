package com.oopPlayground.designPatterns.WeatherControlSystem;

import com.oopPlayground.designPatterns.ObserverPattern.IObserver;

public abstract class WeatherDisplayObserver implements IObserver<Weather>, IDisplay<Weather> {

    public abstract void display(Weather object);

    public void update(Weather state) {
        display(state);
    }
}