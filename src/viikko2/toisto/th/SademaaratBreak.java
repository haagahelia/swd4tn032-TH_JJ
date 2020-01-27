package viikko2.toisto.th;

import java.util.Scanner;

public class SademaaratBreak {

    // kysytään sademääriä kunnes käyttäjä syöttää negatiivisen luvun
    public static void main(String[] args) {
        System.out.println("Syötä sademääriä, negatiivinen luku lopettaa.");

        Scanner lukija = new Scanner(System.in);
        int paivia = 0;
        int summa = 0; // kaikkien sademäärien summa

        while (true) {
            System.out.print("Anna seuraava sademäärä: ");
            int sademaara = lukija.nextInt();
            if (sademaara < 0) {
                break;
            }
            paivia++; // sama kuin paivia = paivia + 1;
            summa += sademaara; // sama kuin: summa = summa + sademaara;
        }
        System.out.println();
        System.out.println("Päiviä: " + paivia);
        System.out.println("Sadetta yhteensä: " + summa);
        System.out.println("Sadetta keskimäärin: " + (1.0 * summa) / paivia);
    }
}
