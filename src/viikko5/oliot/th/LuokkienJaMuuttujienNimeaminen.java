package viikko5.oliot.th;

public class LuokkienJaMuuttujienNimeaminen {

    /*
     * Luokissa voi olla kahdenlaisia metodeja:
     * 
     * 1. staattisia luokkametodeja (static-avainsana)
     * 
     * 2. oliometodeja (ei static-avainsanaa)
     */
    public static void main(String[] args) {

        // String-arvot ovat olioita, vaikka niitä luodaan myös ilman
        // new-avainsanaa:
        String text = new String("Tämä on olio");

        // Muuttujien nimet kirjoitetaan 'aina' pienellä alkukirjaimella.
        // Muuttuja _viittaa_ olioon, ja sen kautta voidaan kutsua _olion_
        // metodeja:
        String uppercase = text.toUpperCase(); // kutsu oliomuuttujan kautta

        // Integer on luokka. Luokkien nimet kirjoitetaan aina isolla alkukirjaimella.
        // Koska parseInt kutsutaan luokalle, eikä oliolle, on se staattinen metodi!!
        Integer number = Integer.parseInt("123"); // kutsu luokan nimen kautta
    }
}
