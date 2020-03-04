package viikko7.tiedostot.th;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarCsvReader {

    public static void main(String[] args) {
        // Määritellään muuttuja try-lohkon ulkopuolella, jotta sitä voidaan käyttää
        // try-lohkon jälkeen:
        List<String> lines;

        try {
            Path csvPath = Paths.get("cars.csv");
            lines = Files.readAllLines(csvPath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Ensimmäisellä rivillä on tiedoston otsikot:
        String[] headers = lines.get(0).split(","); // ["Vuosi", "Merkki", "Malli"]

        // Muutetaan taulukko listaksi, jotta voimme käyttää 'indexOf'-metodia:
        List<String> headerList = Arrays.asList(headers);

        // Selvitetään sarakkeiden indeksit. Indeksejä ei kannata kovakoodata, koska
        // tiedoston rakenne saattaa vaihdella:
        int yearIndex = headerList.indexOf("Vuosi");
        int makeIndex = headerList.indexOf("Merkki");
        int modelIndex = headerList.indexOf("Malli");

        // Kerätään rivit Car-olioina tälle listalle:
        List<Car> cars = new ArrayList<>();

        // Hypätään otsikkorivi (0) yli ja aloitetaan riviltä 1:
        for (int i = 1; i < lines.size(); i++) {
            // Pilkotaan kukin rivi vuorollaan pilkkujen kohdista:
            String[] row = lines.get(i).split(",");

            // Luetaan riviltä halutut tiedot:
            String year = row[yearIndex];
            String make = row[makeIndex];
            String model = row[modelIndex];

            // Luodaan uusi Car-olio ja laitetaan talteen listalle:
            cars.add(new Car(year, make, model));
        }

        /*
         * Vaihtoehtoinen tapa listan läpikäyntiin ja arvojen tulostamiseen:
         * 
         * Listan forEach-metodille voidaan antaa operaatio, joka suoritetaan listan
         * jokaiselle arvolle. Tässä suoritettavaksi operaatioksi annetaan
         * metodiviittaus println-metodiin:
         */
        cars.forEach(System.out::println);
    }
}