package viikko7.tiedostot.th.weather;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// WeatherFileUtility sisältää tiedosto-operaatioita

// ei sisällä main-metodia (ei ole ohjelmaluokka)

// ei sisällä oliomuuttujia (ei ole "dataluokka")
public class WeatherFileUtility {

    public List<DailyWeather> readObservations() {
        Path filePath = Paths.get("csv", "saatiedot.csv");
        try {
            List<String> rows = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            String headers = rows.get(0);

            // 1. luodaan tyhjä lista
            List<DailyWeather> observations = new ArrayList<>();

            // 2. **luodaan jokaista riviä kohden uusi olio**
            // Lähdetään liikkeelle riviltä 1, koska rivi 0 sisältää otsikot
            for (int i = 1; i < rows.size(); i++) {
                String row = rows.get(i);

                String[] data = row.split(",");

                int year = Integer.parseInt(data[0]);
                int month = Integer.parseInt(data[1]);
                int dayOfMonth = Integer.parseInt(data[2]);

                LocalDate observationDate = LocalDate.of(year, month, dayOfMonth);

                // 3. asetetaan olio kerrallaan listalle
                DailyWeather currentDay = new DailyWeather(observationDate);
                observations.add(currentDay);
            }

            // 4. palautetaan lista
            return observations;
        } catch (IOException exception) {
            String errorMessage = exception.getMessage();
            System.out.println(errorMessage);

            // Virhetilanteessa palautetaan tyhjä lista:
            return new ArrayList<DailyWeather>();
        }
    }
}
