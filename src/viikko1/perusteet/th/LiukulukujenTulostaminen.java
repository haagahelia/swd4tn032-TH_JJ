package viikko1.perusteet.th;

import java.text.DecimalFormat;

public class LiukulukujenTulostaminen {

    public static void main(String[] args) {
        // Koodiin kirjoitetaan liukuluvut pisteellä eroteltuna:
        double liukuluku = 123.456;

        // Liukuluvut tulostetaan pisteellä eroteltuna:
        System.out.println(liukuluku); // 123.456

        DecimalFormat kaksiDesimaalia = new DecimalFormat("0.00");

        // annetaan muotoiltava luku, saadaan merkkijono
        String muotoiltu = kaksiDesimaalia.format(liukuluku);

        System.out.println(muotoiltu);
    }
}
