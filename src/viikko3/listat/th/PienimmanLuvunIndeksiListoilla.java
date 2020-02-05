package viikko3.listat.th; // Poista tämä rivi Viopessa!

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PienimmanLuvunIndeksiListoilla {

    public static void main(String[] args) {
        // pienimmän luvun indeksit ovat 0, 4, 7, 12. Selvitettä ne koodaamalla:
        List<Integer> luvut = Arrays.asList(7, 98, 124, 53, 7, 346, 124, 7, 75, 124, 745, 124, 7);

        // kopiota tarvitaan, koska emme halua sortata alkuperäistä:
        List<Integer> kopio = new ArrayList<Integer>(luvut);
        Collections.sort(kopio);
        int pienin = kopio.get(0);

        System.out.println("Pienin luku on: " + pienin);

        System.out.println("Indeksit, joista löytyy luku " + pienin);

        for (int i = 0; i < luvut.size(); i++) {
            if (luvut.get(i) == pienin) {
                // tulosta vain, jos indeksistä löytyy luku luku, joka on pienin
                System.out.println(i);
            }
        }
    }
}
