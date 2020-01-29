package viikko2.toisto.th;

import java.util.Scanner;

public class SkippaaTyhjaMerkkijono {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Anna nimi: ");
        String nimi = lukija.nextLine();

        System.out.println("Anna kuvaus: ");
        String kuvaus = lukija.nextLine();

        System.out.println("Nimi: " + nimi);
        if (kuvaus.isEmpty() == false) {
            System.out.println("Kuvaus: " + kuvaus);
        }
    }
}
