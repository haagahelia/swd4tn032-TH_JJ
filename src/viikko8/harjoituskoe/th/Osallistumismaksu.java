package viikko8.harjoituskoe.th;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Osallistumismaksu {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Kirjoita ikäsi: ");
        int ika = lukija.nextInt();

        double hinta1 = 8;
        double hinta2 = 12.5;

        // olio, jota voidaan käyttää muotoilemisessa:
        DecimalFormat muotoilija = new DecimalFormat("0.00");

        if (ika < 18) {
            // muotoillaan annettava liukuluku edellä määritettyyn muotoon:
            String hinta1Str = muotoilija.format(hinta1);

            // tulostetaan muuttujaan asetettu arvo 8,00
            System.out.println("Osallistumismaksusi on " + hinta1Str + " euroa.");
        } else {
            // muotoillaan annettava liukuluku edellä määritettyyn muotoon:
            String hinta2Str = muotoilija.format(hinta2);

            // tulostetaan muuttujaan asetettu arvo 12,50
            System.out.println("Osallistumismaksusi on " + hinta2Str + " euroa.");
        }
    }
}
