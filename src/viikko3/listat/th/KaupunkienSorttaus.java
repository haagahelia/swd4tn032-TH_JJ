package viikko3.listat.th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KaupunkienSorttaus {

    public static void main(String[] args) {
        List<String> kaupungit = new ArrayList<>();
        kaupungit.add("Rauma");
        kaupungit.add("Helsinki");
        kaupungit.add("Espoo");
        kaupungit.add("Vantaa");
        kaupungit.add("Turku");

        // Tulostaa siinä järjestyksessä, kun lisäsimme arvot:
        System.out.println(kaupungit); // [Rauma, Helsinki, Espoo, Vantaa, Turku]

        // Järjestää "luonnolliseen" järjestykseen:
        Collections.sort(kaupungit);

        // Lista on nyt eri järjestyksessä:
        System.out.println(kaupungit); // [Espoo, Helsinki, Rauma, Turku, Vantaa]
    }
}
