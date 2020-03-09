package viikko7.tiedostot.th;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import viikko7.tiedostot.th.weather.DailyWeather;
import viikko7.tiedostot.th.weather.WeatherFileUtility;

/*
 * WeatherApp on ohjelmaluokka, jonka tarkoitus on ainoastaan tarjota
 * käyttäjälle käyttöliittymä ohjelman logiikkaan:
 * 
 * - WeatherApp ei sisällä oliomuuttujia (eikä siitä luoda olioita)
 */
public class WeatherApp {

    // Motivaatio:
    //
    // 1. WeatherApp-luokassa en halua tietää tarkasti mitä CSV-tiedosto pitää
    // sisällään
    //
    // 2. En halua käsitellä tiedostoihin liittyviä poikkeuksia
    //
    // Ratkaisu: eriytän tiedostonkäsittelyn omaan luokkaansa (WeatherFileUtility)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        WeatherFileUtility fileUtility = new WeatherFileUtility();

        List<DailyWeather> weatherObservations = fileUtility.readObservations();

        // Kysytään tämän päivän tiedot ja tallennetaan ne tiedostoon!
        LocalDate today = LocalDate.now();

        System.out.print("Enter maximum and minimum temperature for today: ");
        double maxTemp = input.nextDouble();
        double minTemp = input.nextDouble();

        DailyWeather currentWeather = new DailyWeather(today, maxTemp, minTemp);
        weatherObservations.add(currentWeather);

        System.out.println(weatherObservations.size() + " daily observations in total");

        // Tulosta lämpimin päivä, ylin lämpötila ja päivämäärä
        DailyWeather warmest = findWarmest(weatherObservations);
        System.out.println("Warmest day: " + warmest);

        // Tulosta kylmin päivä, alin lämpötila ja päivämäärä
        DailyWeather coldest = findColdest(weatherObservations);
        System.out.println("Coldest day: " + coldest);

        fileUtility.writeObservations(weatherObservations);
    }

    // Selvittää, mikä listan päivistä on lämpimin ja palauttaa sen
    private static DailyWeather findWarmest(List<DailyWeather> all) {
        DailyWeather max = all.get(0);

        // Käydään kaikki arvot läpi
        for (int i = 0; i < all.size(); i++) {
            // Asetetaan arvo muuttujaan (done: current)
            DailyWeather current = all.get(i);

            // Vertaillaan max-arvoa nykyiseen arvoon
            if (max.getMaxTemp() < current.getMaxTemp()) {
                max = current; // Jos nykyinen arvo on suurempi, korvataan max-arvo
            }
        }

        return max;
    }

    // Vertailua ei tarvitse tehdä metodiviittauksilla! Katso esim. `findWarmest`
    private static DailyWeather findColdest(List<DailyWeather> all) {
        return Collections.min(all, Comparator.comparing(DailyWeather::getMinTemp));
    }
}
