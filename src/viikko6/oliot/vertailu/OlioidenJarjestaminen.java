package viikko6.oliot.vertailu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OlioidenJarjestaminen {

    public static void main(String[] args) {
        List<String> nimet = Arrays.asList("Marja-Liisa Kirvesniemi", "Kaisa Mäkäräinen", "Krista Pärmäkoski");

        Collections.sort(nimet);
        System.out.println(nimet); // tulostaa [Kaisa Mäkäräinen, Krista Pärmäkoski, Marja-Liisa Kirvesniemi]

        List<Tuote> tuotteet = Arrays.asList(new Tuote("Maito"), new Tuote("Leipä"), new Tuote("Piimä"));
        // Collections.sort(tuotteet); // ei toimi, koska sort ei tiedä millä
        // perusteella järjestellä!

        // merkkijonot ovat yhteensopivia "Comparable"-tyypin kanssa!
        int tulos = "Marja-Liisa".compareTo("Kaisa Mäkäräinen");
        System.out.println(tulos); // (2). Positiivinen luku tarkoittaa, että 'this' tulee toisen jälkeen

        System.out.println("a".compareTo("b")); // -1, eli 'this' on ennen toista merkkijonoa
        System.out.println("x".compareTo("x")); // 0, eli ovat samassa kohdassa

        // miten voidaan käyttää jotain muuta kuin compareTo-järjestystä?!
        List<String> kirjaimet = Arrays.asList("b", "A", "X", "w");

        Collections.sort(kirjaimet);
        System.out.println(kirjaimet); // oletuksena kirjainkoko aiheuttaa bugeja: [A, X, b, w]

        System.out.println("X".compareTo("b")); // -10, negatiivinen
        System.out.println("X".compareToIgnoreCase("b")); // 22, positiivinen

        // kerrotaan Collections.sort-metodille, että käytä compareToIgnoreCase:a
        Collections.sort(kirjaimet, String::compareToIgnoreCase);
        System.out.println(kirjaimet); // [A, b, w, X], eli vertailu toimi!

        // Miten järjestellään nimen pituuden mukaan?
        // Kerrotaan Comparator-oliolle, että vertailee length-metodin tulosten mukaan:
        Collections.sort(nimet, Comparator.comparing(String::length));

        System.out.println(nimet);
        // Tulostaa nimet pituuden mukaan:
        // Kaisa Mäkäräinen, Krista Pärmäkoski, Marja-Liisa Kirvesniemi
    }
}
