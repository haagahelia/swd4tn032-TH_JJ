package viikko4.metodit.th;

public class MainMetodi {

    public static void main(String[] args) {
        // public - tarkoittaa näkyvyys, eli tätä metodia voidaan kutsua mistä vain
        // näkyvyyden vaihtoehdot: public, protected, private ja "oletus"
        // Esim. Math.round on julkinen, koska voimme kutsua sitä omasta koodista
        double a = Math.round(7.2);

        // static, eli "staattinen luokkametodi", kutsutaan aina luokan nimellä
        double b = Math.round(7.7);

        // oliometodit liittyvät aina tiettyyn olioon, tässä "Hello"-merkkijono
        String hello = "Hello";
        hello.toUpperCase(); // ei-staattinen eli oliometodi

        // void tarkoittaa sitä, että metodilla ei ole paluuarvoa
        System.out.println("println on void-tyyppinen metodi"); // tämän metodin paluuarvoa ei ole

        double c = Math.round(3.14); // palauttaa merkkijonon, eli on tyyppiä double

        // main on metodin nimi. Omat metodit voidaan nimetä vapaasti.
        // main-metodilla on erityinen rooli ohjelman käynnistyksessä.

        // (String[] args)
        // metodin parametrimuuttujat sulkujen sisällä. args sisältää
        // "komentoriviparametrit"

    }
}
