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

        // EI KOPIOI TAULUKKOA, VAAN VIITTAA SAMAAN TAULUKKOON:
        String[] lyhennetty = nimet;

        lyhennetty[0] = etunimi.substring(0, 1); // "J"
        lyhennetty[1] = toinenNimi.substring(0, 1); // "L"

        // Lyhennetty taulukko sisältää muuttuneet merkkijonot
        System.out.println(Arrays.toString(lyhennetty));

        // Myös alkuperäisen muuttujan kautta sisältö on muuttunut
        System.out.println(Arrays.toString(nimet));
    }
}
