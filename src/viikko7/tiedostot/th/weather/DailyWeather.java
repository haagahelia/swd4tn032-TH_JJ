package viikko7.tiedostot.th.weather;

import java.time.LocalDate;

/**
 * DailyWeather on dataluokka, joka mallintaa yksittäisen päivän havaintoja
 * Ilmatieteen Laitoksen havaintotiedostosta.
 */
public class DailyWeather {
    // CSV:n sarakkeet: "Vuosi", "Kk" ja "Pv"
    private LocalDate date;

    // CSV:n sarake: "Ylin lämpötila (degC)"
    private double maxTemp;

    // CSV:n sarake: "Alin lämpötila (degC)"
    private double minTemp;

    public DailyWeather(LocalDate date, double max, double min) {
        this.date = date;
        this.maxTemp = max;
        this.minTemp = min;
    }

    public double getMaxTemp() {
        return this.maxTemp;
    }

    public double getMinTemp() {
        return this.minTemp;
    }

    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "Weather on " + this.date + ", temperature max: " + this.maxTemp + " min: " + this.minTemp;
    }
}
