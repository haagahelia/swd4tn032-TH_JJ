package viikko4.metodit.th;

import java.util.ArrayList;

/**
 * Luo tehtäväpohjaan metodi public static void
 * tulostaRajatutLuvut(ArrayList<Integer> luvut, int alaraja, int ylaraja).
 * Metodin tulee tulostaa parametrina annetulta listalta ne luvut, joiden arvot
 * ovat välillä [alaraja, ylaraja]. Alla on muutama esimerkki metodin
 * toiminnasta.
 * 
 * Tämän tehtävän on laatinut Helsingin yliopiston Agile Education Research
 * -tutkimusryhmä. Tehtävä on lisensoitu on lisensoitu Creative Commons BY-NC-SA
 * 4.0 -lisenssillä ja se on julkaistu kurssilla https://ohjelmointi-19.mooc.fi.
 */
public class TulostaRajatut {

    public static void main(String[] args) {
        ArrayList<Integer> luvut = new ArrayList<>();
        luvut.add(3); // 0
        luvut.add(2); // 1
        luvut.add(6); // 2
        luvut.add(-1); // 3
        luvut.add(5); // 4
        luvut.add(1); // 5

        System.out.println("Luvut välillä [0, 5]");
        tulostaRajatutLuvut(luvut, 0, 5);

        System.out.println("Luvut välillä [3, 10]");
        tulostaRajatutLuvut(luvut, 3, 10);
    }

    public static void tulostaRajatutLuvut(ArrayList<Integer> lista, int alaraja, int ylaraja) {
        for (int i = 0; i < lista.size(); i++) {
            // i on indeksi, joka juoksee välillä 0...4

            int luku = lista.get(i); // luku sisältää numeron, joka ehkä halutaan tulostaa

            if (alaraja <= luku && luku <= ylaraja) {
                System.out.println(luku);
            }
        }
    }
}
