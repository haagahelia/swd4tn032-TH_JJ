package viikko2.merkkijonot.th;

import java.util.Scanner;

public class ParseIntJaDouble {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Anna luku: ");

        // nextInt lukee numeron, mutta jättää rivinvaihdon tietovirtaan
        // int luku = lukija.nextInt();

        String rivi = lukija.nextLine();
        int luku = Integer.parseInt(rivi); // parseInt ottaa merkkijonon ja palauttaa kokonaisluvun

        System.out.println("Anna tekstiä: ");
        String teksti = lukija.nextLine(); // tämä skipataan, jos puskurissa on jo rivinvaihto

        System.out.println("Syötit:");
        System.out.println(luku);
        System.out.println(teksti);
    }
}
