package viikko1.ehtorakenteet.th;

import java.time.LocalTime;

public class KellonajanKayttaminen {

    public static void main(String[] args) {

        // LocalTime `olioita` käytetään LocalTime-muuttujien kanssa:
        LocalTime nykyhetki = LocalTime.now();

        // metodikutsujen paluuarvot voidaan tulostaa vaikka suoraan:
        System.out.println(nykyhetki.getHour());

        // metodikutsujen paluuarvot voidaan myös sijoittaa muuttujiin:
        int tunnit = nykyhetki.getHour();
        System.out.println(tunnit);

        // metodikutsujen paluuarvoja voidaan yhdistellä muihin arvoihin:
        System.out.println("Kello on " + nykyhetki.getHour());

        if (nykyhetki.getHour() < 18) {
            System.out.println("Ei ole vielä ilta");
        }
        if (tunnit < 18) {
            System.out.println("Ei ole vielä ilta");
        }
    }
}
