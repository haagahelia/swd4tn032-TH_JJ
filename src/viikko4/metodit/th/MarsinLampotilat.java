package viikko4.metodit.th;

import java.util.Arrays;

public class MarsinLampotilat {

    public static void main(String[] args) {
        // Vaihe 1: kysy 10 mittaustulosta
        int[] mittaustulokset = kysyMittaustulokset(10);

        // Vaihe 2: tulosta tilasto
        tulostaTilasto(mittaustulokset);
    }

    // tämän metodin on palautettava aina int[] -tyyppinen taulukko!
    private static int[] kysyMittaustulokset(int maara) {
        int[] taulukko = new int[maara];
        // TODO: kysy oikeat mittaustulokset
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = 10 + i;
        }
        return taulukko;
    }

    private static void tulostaTilasto(int[] arvot) {
        // Vaihe 1: laske keskiarvo, pienin ja suurin
        int suurin = laskeSuurin(arvot);

        // TODO: laske pienin ja keskiarvo:
        // int pienin = laskePienin(arvot);

        // TODO: laske keskiarvo
        // double keskiarvo = laskeKeskiarvo(arvot);

        // TODO: tulosta arvot
        System.out.println(Arrays.toString(arvot));
        System.out.println("Suurin arvo: " + suurin);
    }

    private static int laskeSuurin(int[] arvot) {
        int suurin = arvot[0];
        for (int uusiLuku : arvot) {
            if (uusiLuku > suurin) {
                suurin = uusiLuku;
            }
        }
        return suurin;
    }
}
