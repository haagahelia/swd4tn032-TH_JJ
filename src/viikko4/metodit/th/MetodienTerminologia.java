package viikko4.metodit.th;

public class MetodienTerminologia {

    public static void main(String[] args) {
        double a = 3.14;

        // parametriarvo on jokin arvo, joka annetaan toiselle metodille
        double b = Math.round(a); // a on tässä parametriarvo

        // paluuarvo on jokin arvo, jonka metodi palauttaa takaisin kutsun jälkeen:
        double c = Math.round(a); // paluuarvo asetetaan muuttujaan c
    }
}
