package viikko1.perusteet.th;

import java.util.Scanner;

public class KokonaislukujenLaskuoperaatiot {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Syötä kaksi kokonaislukua:");
        int luku1 = lukija.nextInt();
        int luku2 = lukija.nextInt();

        // HUOM! mahdollinen kokonaisluvun "ylivuoto"
        System.out.println("Summa: " + (luku1 + luku2));
        System.out.println("Erotus: " + (luku1 - luku2));

        System.out.println("Tulo: " + luku1 * luku2);

        // HUOM! Katkaiseva jakolasku 9 / 4 === 2!!
        System.out.println("Osamäärä: " + (luku1 / luku2));

        System.out.println("Jakojäännös: " + (luku1 % luku2));
    }
}
