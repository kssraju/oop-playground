package com.oopPlayground.designPatterns.WeatherControlSystem;

public abstract class WeatherLoggerObserver implements IObserver<Weather>, ILogger<Weather> {

    public abstract void log(Weather object);

    public void update(Weather state) {
        log(state);
    }
}

