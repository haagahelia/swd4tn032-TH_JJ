package viikko2.merkkijonot.th;

import java.util.Scanner;

public class Lumi {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // laskurit
        int yhteensa = 0;
        int lumi = 0;

        while (true) {
            System.out.print("Anna nimi: ");
            String nimi = lukija.nextLine();

            if (nimi.equalsIgnoreCase("lumi")) {
                lumi++;
            }

            if (nimi.equalsIgnoreCase("loppu")) {
                break;
            }

            yhteensa++;
        }

        System.out.println("Nimiä oli " + yhteensa + " kappaletta.");
        System.out.println("Nimi Lumi esiintyi " + lumi + " kertaa.");
    }
}
