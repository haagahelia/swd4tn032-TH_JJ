package viikko2.merkkijonot.th;

public class MerkkijononPituusJaLapikaynti {

    public static void main(String[] args) {
        String merkkijono = "Haaga-Helia";

        int pituus = merkkijono.length();
        System.out.println(pituus);

        // pituus on aina suurempi kuin viimeinen indeksi!
        for (int i = 0; i < pituus; i++) {
            char kirjain = merkkijono.charAt(i);
            System.out.println(kirjain);
        }
    }
}
