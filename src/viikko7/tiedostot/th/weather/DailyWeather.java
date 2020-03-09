package viikko7.tiedostot.th.weather;

import java.time.LocalDate;

public class DailyWeather {
    // Vuosi Kk Pv
    private LocalDate date;

    // Sademäärä (mm)
    private double rain;

    // Lumensyvyys (cm)
    private double snow;

    // Ylin lämpötila (degC)
    private double maxTemp;

    // Alin lämpötila (degC)
    private double minTemp;

    public DailyWeather(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Weather on " + this.date;
    }
}
