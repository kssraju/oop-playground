package com.oopPlayground.designPatterns.WeatherControlSystem;

public class WeatherControlSystem extends Observable<Weather> {

    private Weather weather;

    public void setMeasurements(Weather weather) {
        this.weather = weather;
    }

    public void measurementsChanged() {
        notifyObservers(this.weather);
    }

    @Override
    public void addObserver(IObserver<Weather> observer) {
        super.addObserver(observer);
    }

    @Override
    public void removeObservers(IObserver<Weather> observer) {
        super.removeObservers(observer);
    }

    @Override
    public void notifyObservers(Weather state) {
        super.notifyObservers(state);
    }
}

