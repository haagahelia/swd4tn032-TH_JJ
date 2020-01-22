package viikko1.ehtorakenteet.th;

import java.util.Scanner;

public class JunalippujenHinta {

    // 1. Kysytään ostaako käyttäjä kuukausilipun vai kertalippuja
    // 2. Jos ostaa kuukausilipun, kerrotaan kuukausihinta
    // 3. Jos kertalippuja, kysytään kuinka monta, ja kerrotaan yhteishinta
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Ostatko kuukausilipun (1) vai kertalippuja (2)?");
        int vastaus = lukija.nextInt();

        if (vastaus == 1) {
            System.out.println("Kuukausilippu maksaa 100 €");
        } else {
            System.out.println("Kuinka monta kertalippua käytät kuukaudessa?");
            int kertaLippujenMaara = lukija.nextInt();
            int hinta = kertaLippujenMaara * 10;

            if (hinta > 100) {
                System.out.println("Kuukausilippu olisi halvempi");
            } else {
                System.out.println("Säästät " + (100 - hinta) + " € verrattuna kuukausilippuun");
            }
        }

        lukija.close();
    }
}
