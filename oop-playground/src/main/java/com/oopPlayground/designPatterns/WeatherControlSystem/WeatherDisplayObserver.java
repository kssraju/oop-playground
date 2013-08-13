package com.oopPlayground.designPatterns.WeatherControlSystem;

public abstract class WeatherDisplayObserver implements IObserver<Weather>, IDisplay<Weather> {

    public abstract void display(Weather object);

    public void update(Weather state) {
        display(state);
    }
}