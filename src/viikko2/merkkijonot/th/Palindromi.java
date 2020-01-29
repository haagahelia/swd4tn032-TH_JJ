package viikko2.merkkijonot.th;

import java.util.Scanner;

public class Palindromi {

    /*
     * DISCLAIMER: merkkijonojen jatkuva yhdisteleminen saattaa aiheuttaa valtavaa
     * muistinkäyttöä, katso: https://stackoverflow.com/a/8726248
     */
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Anna tarkastettava palindromi:");
        String syote = lukija.nextLine();

        // viimeinen indeksi on pituus - 1
        int vikaIndeksi = syote.length() - 1;

        // kokoojamuuttuja
        String kaannetty = "";

        // askeltaja: 18, 17, 16, 15.... 0
        for (int i = vikaIndeksi; i >= 0; i--) {
            String kirjain = syote.substring(i, i + 1);
            kaannetty = kaannetty + kirjain;
        }

        if (kaannetty.equalsIgnoreCase(syote)) {
            System.out.println(syote + " on palindromi!");
        } else {
            System.out.println(syote + " ei ole palindromi!");
        }
    }
}
