package viikko1.perusteet.th;

import java.text.DecimalFormat;

public class LiukulukujenTulostaminen {

    public static void main(String[] args) {
        // koodiin kirjoitetaan liukuluvut pisteellä eroteltuna:
        double liukuluku = 123.456;

        // liukuluvut tulostetaan normaalisti pisteellä eroteltuna ilman pyöristyksiä:
        System.out.println(liukuluku); // tulostaa 123.456

        /*
         * Desimaaleja voidaan muotoilla DecimalFormat-luokan avulla. Tässä luomme uuden
         * DecimalFormat-olion ja annamme sille muotoilusäännöksi "0.00". "0.00"
         * muotoilee luvun kahden desimaalin tarkkuudella käyttäen käyttöjärjestelmän
         * desimaalierotinta (Suomessa pilkku).
         */
        DecimalFormat kaksiDesimaalia = new DecimalFormat("0.00");

        // annetaan muotoiltava luku format-metodille, saadaan takaisin muotoiltu
        // merkkijono
        String muotoiltu = kaksiDesimaalia.format(liukuluku);

        // tulostetaan lopulta muotoiltu merkkijono
        System.out.println(muotoiltu); // tulostaa 123,46 <-- pyöristetty kahteen desimaaliin, erottimena pilkku
    }
}
