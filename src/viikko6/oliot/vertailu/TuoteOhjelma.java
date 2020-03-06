package viikko6.oliot.vertailu;

import java.util.List;

public class TuoteOhjelma {

    public static void main(String[] args) {
        Tuote maito1 = new Tuote("Maito");
        Tuote maito2 = new Tuote("Maito");

        System.out.println(maito1);
        System.out.println(maito2);

        System.out.println("Vertailuoperaattori: " + (maito1 == maito2)); // false, koska maito1 on eri olio kuin maito2
        System.out.println("equals: " + maito1.equals(maito2)); // false => true, koska toteutimme equals-metodin

        // Toinen esimerkki: listoilta hakeminen
        List<Tuote> tuotteet = List.of(maito1, new Tuote("Leipä"), new Tuote("Piimä"));

        boolean onLeipa = tuotteet.contains(new Tuote("Leipä"));
        int piimaIndeksi = tuotteet.indexOf(new Tuote("Piimä"));

        System.out.println("contains: " + onLeipa); // true, koska lista kutsuu equals-metodia etsiessään arvoa
        System.out.println("indexOf: " + piimaIndeksi); // palauttaa 2, koska equals-vertailu indeksin 2 kanssa palautti
                                                        // true

    }
}
