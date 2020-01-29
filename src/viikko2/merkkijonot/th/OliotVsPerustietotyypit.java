package viikko2.merkkijonot.th;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OliotVsPerustietotyypit {

    public static void main(String[] args) {
        // perustietotyyppien nimet alkavat pienellä (int):
        // alkeistietotyypeillä ei ole metodeja
        int luku = 93;

        Scanner lukija = new Scanner(System.in);
        // lukija.hasNextLine(); olioilla on metodeja

        System.out.println(10 == 10);

        DecimalFormat desimaalit = new DecimalFormat("0.00");
        DecimalFormat desimaalit2 = new DecimalFormat("0.00");

        // kun vertailemme olioita, ovat ne yhtäsuuria vain silloin,
        // kun kyseessä on täysin sama olio:
        System.out.println(desimaalit == desimaalit2);

        System.out.println(desimaalit == desimaalit);
    }
}
