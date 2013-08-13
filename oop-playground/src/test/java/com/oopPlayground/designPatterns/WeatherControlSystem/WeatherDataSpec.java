package com.oopPlayground.designPatterns.WeatherControlSystem;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class WeatherDataSpec {

    Weather weather;
    WeatherControlSystem weatherControlSystem;

    @Before
    public void setup() {
        weather = new Weather();
        weather.setTemp(25);
        weather.setHumidity(60);
        weather.setPressure(50);

        weatherControlSystem = new WeatherControlSystem();
    }

    @Test
    public void shouldRefreshWeatherDisplayWhenWeatherChanges() {
        WeatherDisplayObserver currentDisplay = mock(WeatherDisplayObserver.class);
        weatherControlSystem.addObserver(currentDisplay);

        weatherControlSystem.setMeasurements(weather);

        weatherControlSystem.measurementsChanged();

        verify(currentDisplay).update(weather);
    }

    @Test
    public void shouldAddANewDisplay() {
        IObserver currentDisplay = mock(IObserver.class);
        weatherControlSystem.addObserver(currentDisplay);
        weatherControlSystem.setMeasurements(weather);

        weatherControlSystem.measurementsChanged();

        verify(currentDisplay).update(weather);
    }

    @Test
    public void shouldRemoveAnExistingDisplay() {
        IObserver currentDisplay = mock(IObserver.class);
        weatherControlSystem.addObserver(currentDisplay);
        weatherControlSystem.setMeasurements(weather);
        weatherControlSystem.removeObservers(currentDisplay);

        weatherControlSystem.measurementsChanged();

        verify(currentDisplay, times(0)).update(weather);
    }

    @Test
    public void shouldDisplayWeatherChangesToBothDisplays() {
        IObserver currentDisplay = mock(CurrentWeatherDisplay.class);
        IObserver dailyStatisticsDisplay = mock(DailyStatisticsDisplay.class);
        weatherControlSystem.addObserver(currentDisplay);
        weatherControlSystem.addObserver(dailyStatisticsDisplay);

        weatherControlSystem.setMeasurements(weather);

        weatherControlSystem.measurementsChanged();

        verify(currentDisplay, times(1)).update(weather);
        verify(dailyStatisticsDisplay, times(1)).update(weather);
    }

    @Test
    public void shouldDisplayAndLogWeatherChanges() {
        IObserver displayObserver = mock(WeatherDisplayObserver.class);
        IObserver loggerObserver = mock(WeatherLoggerObserver.class);
        weatherControlSystem.addObserver(displayObserver);
        weatherControlSystem.addObserver(loggerObserver);

        weatherControlSystem.setMeasurements(weather);

        weatherControlSystem.measurementsChanged();

        verify(displayObserver, times(1)).update(weather);
        verify(loggerObserver, times(1)).update(weather);
    }
}




