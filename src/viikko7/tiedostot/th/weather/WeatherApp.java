package viikko7.tiedostot.th.weather;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * WeatherApp on ohjelmaluokka, jonka tarkoitus on ainoastaan tarjota
 * käyttäjälle käyttöliittymä ohjelman logiikkaan:
 * 
 * - WeatherApp ei sisällä oliomuuttujia (eikä siitä luoda olioita)
 */
public class WeatherApp {

    /*
     * Motivaatio logiikan jakaminen useisiin eri luokkiin:
     *
     * - WeatherApp-luokassa en halua tietää tarkasti, mitä CSV-tiedosto pitää
     * sisällään
     *
     * - En halua käsitellä tiedostoihin liittyviä poikkeuksia tässä luokassa
     *
     * Ratkaisu: eriytän tiedostonkäsittelyn omaan luokkaansa **WeatherFileUtility**
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Tällä oliolla suoritetaan tiedosto-operaatiot:
        WeatherFileUtility fileUtility = new WeatherFileUtility();

        // Tiedostoluokka palauttaa listan DailyWeather-olioita, jotka luettiin
        // tiedostosta:
        List<DailyWeather> weatherObservations = fileUtility.readObservations();

        // Kysytään vielä tämän päivän tiedot ja luodaan tätä päivää varten uusi
        // DailyWeather-olio!
        System.out.print("Enter maximum and minimum temperature for today: ");
        double maxTemp = input.nextDouble();
        double minTemp = input.nextDouble();

        LocalDate today = LocalDate.now();
        DailyWeather currentWeather = new DailyWeather(today, maxTemp, minTemp);

        // Tämän päivän säätiedot laitetaan listalle viimeiseksi:
        weatherObservations.add(currentWeather);

        System.out.println(weatherObservations.size() + " daily observations in total");

        // Tulosta lämpimin päivä, ylin lämpötila ja päivämäärä
        DailyWeather warmest = findWarmest(weatherObservations);
        System.out.println("Warmest day: " + warmest);

        // Tulosta kylmin päivä, alin lämpötila ja päivämäärä
        DailyWeather coldest = findColdest(weatherObservations);
        System.out.println("Coldest day: " + coldest);

        // Tallennetaan luetut tiedot sekä nykyisen päivän säätiedot takaisin
        // tiedostoon:
        fileUtility.writeObservations(weatherObservations);
    }

    /* Selvittää, mikä listan päivistä on lämpimin ja palauttaa sen. */
    private static DailyWeather findWarmest(List<DailyWeather> all) {
        // max-muuttuja on "sopivimman säilyttäjä"
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

    /* Vertailua ei tarvitse tehdä metodiviittauksilla! Katso esim. `findWarmest` */
    private static DailyWeather findColdest(List<DailyWeather> all) {
        // DailyWeather::getMinTemp on metodiviittaus. Comparator.comparing käyttää sitä
        // vertaillakseen DailyWeather-olioita toisiinsa. Collections.min etsii
        // vertailujen perusteella pienimmän arvon:
        return Collections.min(all, Comparator.comparing(DailyWeather::getMinTemp));
    }
}
