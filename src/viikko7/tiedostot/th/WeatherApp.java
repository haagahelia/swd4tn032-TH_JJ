package viikko7.tiedostot.th;

import java.util.List;

import viikko7.tiedostot.th.weather.DailyWeather;
import viikko7.tiedostot.th.weather.WeatherFileUtility;

public class WeatherApp {

    public static void main(String[] args) {
        // Motivaatio:
        //
        // 1. WeatherApp-luokassa en halua tietää tarkasti mitä CSV-tiedosto pitää
        // sisällään
        //
        // 2. En halua käsitellä tiedostoihin liittyviä poikkeuksia
        //
        // Ratkaisu: eriytän tiedostonkäsittelyn omaan luokkaansa (WeatherFileUtility)

        WeatherFileUtility fileUtility = new WeatherFileUtility();

        List<DailyWeather> weatherObservations = fileUtility.readObservations();

        System.out.println("Read " + weatherObservations.size() + " daily observations");
        System.out.println("First observation: " + weatherObservations.get(0));
        System.out.println("Last observation: " + weatherObservations.get(weatherObservations.size() - 1));
    }

}
