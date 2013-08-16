package com.oopPlayground.designPatterns.WeatherControlSystem;

import com.oopPlayground.designPatterns.ObserverPattern.IObserver;

public abstract class WeatherLoggerObserver implements IObserver<Weather>, ILogger<Weather> {

    public abstract void log(Weather object);

    public void update(Weather state) {
        log(state);
    }
}

