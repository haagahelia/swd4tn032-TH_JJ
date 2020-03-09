package viikko7.tiedostot.th.weather;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Tämä WeatherFileUtility-luokka sisältää tiedosto-operaatioita
 * 
 *  - ei sisällä main-metodia (ei ole ohjelmaluokka)
 * 
 *  - ei sisällä oliomuuttujia (ei ole "dataluokka")
 */
public class WeatherFileUtility {

    public List<DailyWeather> readObservations() {
        Path filePath = Paths.get("csv", "saatiedot.csv");
        try {
            List<String> rows = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            List<DailyWeather> observations = new ArrayList<>();

            // Pilkkoo otsikkorivin taulukoksi pilkkujen kohdilta:
            String[] headers = rows.get(0).split(",");

            // Lähdetään liikkeelle riviltä 1, koska rivi 0 sisältää otsikot
            for (int i = 1; i < rows.size(); i++) {
                // Nykyisen rivin "raakadata":
                String row = rows.get(i);

                // Muutetaan teksti olioksi parseDailyWeather-metodin avulla:
                DailyWeather currentDay = parseDailyWeather(row, headers);

                // Virheellinen rivi tuottaa null-arvoja, joita emme halua mukaan listalle:
                if (currentDay != null) {
                    observations.add(currentDay);
                }
            }
            return observations; // 4. palautetaan lista

        } catch (IOException exception) {
            // `exception` on poikkeusolio, jolla on mm. getMessage() metodi virheilmoitusta
            // varten:
            String errorMessage = exception.getMessage();
            System.out.println(errorMessage);

            // Virhetilanteessa palautetaan tyhjä lista:
            return new ArrayList<DailyWeather>();
        }
    }

    public void writeObservations(List<DailyWeather> weatherObservations) {
        Path filePath = Paths.get("csv", "saatiedot.csv");

        try {
            // Kootaan kaikki kirjoitettavat rivit rows-listalle:
            List<String> rows = new ArrayList<String>();

            // Listan ensimmäinen rivi sisältää ennalta tunnetut otsikot:
            rows.add("Vuosi,Kk,Pv,Ylin lämpötila (degC),Alin lämpötila (degC)");

            for (DailyWeather current : weatherObservations) {
                // Tällä kierroksella käsiteltävän havainnon päivämäärä:
                LocalDate date = current.getDate();

                // Muodostetaan pilkulla eroteltu merkkijono: "vuosi,kk,pv,maxTemp,minTemp"
                String currentCSV = date.getYear() + "," + date.getMonthValue() + "," + date.getDayOfMonth() + ","
                        + current.getMaxTemp() + "," + current.getMinTemp();

                // Lisätään muodostettu rivi listalle:
                rows.add(currentCSV);
            }

            // Tallennetaan kaikki muodostetut rivit tiedostoon:
            Files.write(filePath, rows, StandardCharsets.UTF_8);

        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    /*
     * csvInput: esim. "2010,1,10,00:00,UTC,0.4,33,-12.6,-10.8,-17"
     * 
     * Pilkkoo annetun tekstin ja muodostaa DailyWeather-olion.
     */
    private DailyWeather parseDailyWeather(String csvInput, String[] headers) {
        String[] data = csvInput.split(",");
        List<String> headerList = Arrays.asList(headers);

        // Selvitetään sarakkeiden indeksit CSV-tiedostossa. Indeksejä ei kannata
        // kovakoodata, koska tiedoston rakenne saattaa vaihdella:
        int yearIndex = headerList.indexOf("Vuosi");
        int monthIndex = headerList.indexOf("Kk");
        int dayIndex = headerList.indexOf("Pv");
        int maxTempIndex = headerList.indexOf("Ylin lämpötila (degC)");
        int minTempIndex = headerList.indexOf("Alin lämpötila (degC)");

        if (data.length == headerList.size()) {
            // Luetaan päivämäärän palaset ja muodostetaan LocalDate-olio:
            int year = Integer.parseInt(data[yearIndex]);
            int month = Integer.parseInt(data[monthIndex]);
            int dayOfMonth = Integer.parseInt(data[dayIndex]);
            LocalDate observationDate = LocalDate.of(year, month, dayOfMonth);

            double maxTemp = Double.parseDouble(data[maxTempIndex]);
            double minTemp = Double.parseDouble(data[minTempIndex]);

            return new DailyWeather(observationDate, maxTemp, minTemp);
        } else {
            System.err.println("Ongelma rivillä: " + csvInput);
            return null;
        }
    }
}
