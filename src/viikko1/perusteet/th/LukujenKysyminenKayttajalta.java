package viikko1.perusteet.th;

import java.util.Scanner;

public class LukujenKysyminenKayttajalta {

    public static void main(String[] args) {
        // System.out toimii tulostamisessa
        // System.in toimii syötteiden lukemisessa

        // alustetaan lukija, joka lukee System.in-tietovirtaa
        Scanner lukija = new Scanner(System.in);

        System.out.println("Syötä kokonaisluku:");
        int luku = lukija.nextInt(); // anna minulle seuraava luku käyttäjältä
        System.out.println("Syötit luvun " + luku);
    }
}
