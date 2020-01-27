package viikko2.toisto.th;

import java.util.Scanner;

public class SademaaratIteroimalla {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Syötä sademäärät millimetreinä yhdelle riville");
        double eka = lukija.nextDouble();

        double summa = eka;
        double minimi = eka;
        double maksimi = eka;
        int paivia = 1;

        // jatketaan syötettujen lukujen lukemista eli iteroidaan,
        // kunnes luvut loppuvat:
        while (lukija.hasNextDouble()) {
            double maara = lukija.nextDouble();

            summa += maara;
            minimi = Math.min(minimi, maara);
            maksimi = Math.max(maksimi, maara);
            paivia++;
        }

        System.out.println();
        System.out.println("Yhteensä: " + summa);
        System.out.println("Päiviä: " + paivia);
        System.out.println("Maksimi: " + maksimi);
        System.out.println("Minimi: " + minimi);
        System.out.println("Keskiarvo: " + summa / paivia);
    }
}
