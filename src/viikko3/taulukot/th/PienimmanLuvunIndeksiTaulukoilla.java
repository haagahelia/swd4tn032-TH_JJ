package viikko3.taulukot.th; // Poista tämä rivi Viopessa!

import java.util.Arrays;

public class PienimmanLuvunIndeksiTaulukoilla {

    public static void main(String[] args) {
        // pienimmän luvun indeksit ovat 0, 4, 7, 12. Selvitettä ne koodaamalla:
        int[] luvut = { 7, 98, 124, 53, 7, 346, 124, 7, 75, 124, 745, 124, 7 };

        // kopiota tarvitaan, koska emme halua sortata alkuperäistä:
        int[] kopio = Arrays.copyOf(luvut, luvut.length);
        Arrays.sort(kopio);
        int pienin = kopio[0];

        System.out.println("Pienin luku on: " + pienin);

        System.out.println("Indeksit, joista löytyy luku " + pienin);

        for (int i = 0; i < luvut.length; i++) {
            if (luvut[i] == pienin) {
                // tulosta vain, jos indeksistä löytyy luku luku, joka on pienin
                System.out.println(i);
            }
        }
    }
}
