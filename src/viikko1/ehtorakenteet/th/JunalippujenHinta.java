package viikko1.ehtorakenteet.th;

import java.util.Scanner;

/*
 * Tässä esimerkissä demonstroidaan sisäkkäistä vaihtoehtorakennetta. Käyttäjän
 * ensimmäisestä vastauksesta riippuen häneltä joko kysytään toinen kysymys tai
 * tulostetaan vastaus suoraan. Toisen kysymyksen vastauksesta riippuen
 * suoritetaan jompi kumpi vaihtoehtoisista lohkoista.
 * 
 * DISCLAIMER: esimerkki on kirjoitettu suurempia suunnittelematta, ja
 * esimerkiksi kuukausilipun ja kertalippujen hintojen tulisi olla määritelty
 * muuttujissa, eikä kirjoitettu useisiin eri kohtiin ohjelmakoodissa.
 */
public class JunalippujenHinta {

    /*
     * 1. Kysytään ostaako käyttäjä kuukausilipun vai kertalippuja
     * 
     * 2. Jos ostaa kuukausilipun, kerrotaan kuukausihinta
     * 
     * 3. Jos kertalippuja, kysytään kuinka monta, ja kerrotaan tulisiko
     * kuukausilippu halvemmaksi
     */
    public static void main(String[] args) {
        final int kertalipunHinta = 10;
        final int kuukausilipunHinta = 100;

        Scanner lukija = new Scanner(System.in);

        System.out.println("Ostatko kuukausilipun (1) vai kertalippuja (2)?");
        int vastaus = lukija.nextInt();

        if (vastaus == 1) {
            System.out.println("Kuukausilippu maksaa " + kuukausilipunHinta + " €");
        } else {
            System.out.println("Kuinka monta kertalippua käytät kuukaudessa?");
            int kertalippuja = lukija.nextInt();
            int kokonaishinta = kertalippuja * kertalipunHinta;

            if (kokonaishinta > kuukausilipunHinta) {
                System.out.println("Kuukausilippu olisi halvempi");
            } else {
                int saasto = kuukausilipunHinta - kokonaishinta;
                System.out.println("Säästät " + saasto + " € verrattuna kuukausilippuun");
            }
        }

        lukija.close();
    }
}
