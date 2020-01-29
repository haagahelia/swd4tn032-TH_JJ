package viikko2.merkkijonot.th;

import java.util.Scanner;

public class MerkkijonojenKaantaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Anna käännettävä teksti:");
        String syote = lukija.nextLine();

        // viimeinen indeksi on pituus - 1
        int vikaIndeksi = syote.length() - 1;

        // askeltaja: 18, 17, 16, 15.... 0
        for (int i = vikaIndeksi; i >= 0; i--) {
            String kirjain = syote.substring(i, i + 1);
            System.out.print(kirjain);
        }
    }
}
