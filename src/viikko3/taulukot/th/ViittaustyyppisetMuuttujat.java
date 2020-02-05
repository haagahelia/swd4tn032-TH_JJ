package viikko3.taulukot.th;

import java.util.Arrays;

public class ViittaustyyppisetMuuttujat {

    public static void main(String[] args) {

        String[] nimet = { "Johan", "Ludvig", "Runeberg" };
        String merkkijono = Arrays.toString(nimet);
        System.out.println(merkkijono);

        String etunimi = nimet[0]; // "Johan"
        String toinenNimi = nimet[1]; // "Ludvig"
        String sukunimi = nimet[2]; // "Runeberg"

        String[] lyhennetty = Arrays.copyOf(nimet, nimet.length);

        lyhennetty[0] = etunimi.substring(0, 1); // "J"
        lyhennetty[1] = toinenNimi.substring(0, 1); // "L"

        // Lyhennetty taulukko
        System.out.println(Arrays.toString(lyhennetty));

        // Alkuperäinen taulukko
        System.out.println(Arrays.toString(nimet));
    }
}
