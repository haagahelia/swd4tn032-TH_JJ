package viikko2.merkkijonot.th;

public class MerkkijononPituusJaLapikaynti2 {

    public static void main(String[] args) {
        String merkkijono = "Haaga-Helia";

        // pituus on aina suurempi kuin viimeinen indeksi!
        int pituus = merkkijono.length();

        // i:n arvot: 0, 1, 2, 3, 4, 5, 6, ... 10
        for (int i = 0; i < pituus; i++) {
            // Merkkijonon loppuindeksit: 1, 2, 3, 4, 5, 6, 7, ... 11
            // vikaIndeksi on aina i + 1!
            int vikaIndeksi = i + 1;

            String osamerkkijono = merkkijono.substring(0, vikaIndeksi);
            System.out.println(osamerkkijono);
        }
    }
}
