package viikko3.listat.th;

import java.net.URL;
import java.util.Scanner;

public class KaupungitVerkosta {

    public static void main(String[] args) throws Exception {
        URL csvTiedosto = new URL("https://git.io/Jv3N3");
        Scanner lukija = new Scanner(csvTiedosto.openStream());

        String ekaRivi = lukija.nextLine();
        System.out.println(ekaRivi);

        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();

            int loppuindeksi = rivi.indexOf(",");
            String kaupunki = rivi.substring(0, loppuindeksi);

            String vakilukuString = rivi.substring(loppuindeksi + 1);
            int vakiluku = Integer.parseInt(vakilukuString);

            if (vakiluku >= 10_000) {
                System.out.println(kaupunki + ", väkiluku: " + vakiluku);
            }
        }
        lukija.close(); // sulkee yhteyden
    }
}
