package viikko2.toisto.th;

import java.util.Scanner;

public class SademaaratBreak {

    // kysytään sademääriä kunnes käyttäjä syöttää negatiivisen luvun
    public static void main(String[] args) {
        System.out.println("Syötä sademääriä, negatiivinen luku lopettaa.");

        Scanner lukija = new Scanner(System.in);
        int paivia = 0;
        int summa = 0; // kaikkien sademäärien summa
        int maksimi = 0;

        // valitaan luku, joka on varmasti isompi kuin mikään oikea annettu arvo
        int minimi = Integer.MAX_VALUE;

        while (true) {
            System.out.print("Anna seuraava sademäärä: ");
            int sademaara = lukija.nextInt();

            if (sademaara < 0) {
                // break poistuu toistorakenteesta välittömästi
                break;
            }
            paivia++; // sama kuin paivia = paivia + 1;
            summa += sademaara; // sama kuin: summa = summa + sademaara;

            // suurimman päivittäminen if-vertailulla (versio 1)
            if (sademaara > maksimi) {
                maksimi = sademaara;
            }

            // pienimmän päivittäminen min-metodilla (versio 2)
            minimi = Math.min(minimi, sademaara);
        }

        System.out.println(); // tulostaa tyhjän rivin
        System.out.println("Päiviä: " + paivia);
        System.out.println("Sadetta yhteensä: " + summa);
        System.out.println("Sadetta keskimäärin: " + (1.0 * summa) / paivia);
        System.out.println("Suurin päivittäinen sademäärä: " + maksimi);
        System.out.println("Pienin päivittäinen sademäärä: " + minimi);

        lukija.close();
    }
}
