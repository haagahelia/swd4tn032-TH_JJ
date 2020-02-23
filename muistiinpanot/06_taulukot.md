Tämä sivu on siirretty Wikiin: https://github.com/haagahelia/swd4tn032-TH_JJ/wiki

# Taulukot (array)

Taulukot ovat varsin alkeellisia tietorakenteita, joihin voidaan varastoida useita saman typpisiä arvoja. Toisin kuin listojen, taulukon pituus on kiinteä, eli sitä ei voi lyhentää eikä kasvattaa. Samaan muuttujaan voidaan toki sijoittaa uusi, eri pituinen taulukko.

Taulukoita, kuten listoja ja kaikkia muitakin olioita, käytetään viittaustyyppisillä muuttujilla. Taulukkoa ei siis automaattisesti kopioida, kun sitä käytetään eri paikoista.

## Taulukkomuuttujat

Taulukkoja voidaan sijoittaa muuttujiin, joissa taulukossa tallennettavan tyypin nimen jälkeen esiintyy hakasulut, esim:

```java
int[] numerot;
String[] sanat;
Yhteystieto[] yhteystiedot;
Auto[] autot;
```

Tässä vaiheessa kurssia pitäydymme Javan valmiissa tietotyypeissä kuten `String` emmekä vielä toteuta omia luokkia, kuten `Yhteystieto`.

## Taulukon luominen

Taulukot luodaan new-avainsanalla ja taulukon pituus määritellään hakasuluissa. Hakasulkujen sisään määritellään tällä syntaksilla **taulukon pituus, jota ei voi enää muuttaa taulukon luomisen jälkeen**.

```java
String[] sanat = new String[10];
int[] numerot = new int[10];
```

## Taulukon alkioihin viittaaminen

Taulukon alkioihin viitataan taulukon indeksien perusteella hakasulkujen avulla:
* Ensimmäinen indeksi on 0
* Viimeinen on taulukon pituus - 1

Tässä esimerkissä luodaan kolmepaikkainen kokonaislukutaulukko, jonka jälkeen taulukon indekseihin 0 ja 2 asetetaan arvot:

```java
// Luodaan muuttuja ja taulukko:
int[] luvut = new int[3];

// Asetetaan taulukkoon arvoja:
luvut[0] = 2;
luvut[2] = 5;

// Arvojen lukeminen taulukosta:
System.out.println(luvut[0]);
int luku = luvut[2];
```

[Katso Java Visualizerissa!](https://goo.gl/Dmrxhz)

Tämä esimerkki on lainattu Helsingin yliopiston Agile Education Research –tutkimusryhmän oppimateriaalista, joka on lisensoitu Creative Commons BY-NC-SA-lisenssillä. https://2017-ohjelmointi.github.io/part6/ 

## Taulukon luominen valmiilla arvoilla

Jos taulukkoon asetettavat alkuarvot ovat jo valmiiksi tiedossa, taulukko voidaan alustaa myös aaltosulkeiden avulla tietyille arvoille.

Tällöin taulukon pituutta ei ilmoiteta hakasuluissa, vaan pituus määräytyy alkuarvojen määrän mukaan, esim: `int[] arvot = new int[] { 2, 7, 5, 6 };`. Java osaa myös päätellä tässä tapauksessa taulukon tyypin, joten voimme kirjoittaa lyhyesti `int[] arvot = { 2, 7, 5, 6 };`.

```java
// alustaminen valmiilla arvoilla:
int[] numerot1 = new int[] { 2, 7, 5, 6 };

// alustaminen valmiilla arvoilla (Java päättelee tyypin):
int[] numerot2 = { 2, 7, 5, 6 };

// vastaavasti merkkijonoilla:
String[] merkkijonot1 = new String[] { "Ferrari", "McLaren", "Sauber" };

// Java päättelee tyypin:
String[] merkkijonot2 = { "Ferrari", "McLaren", "Sauber" };

// alustaminen yksi alkio kerrallaan:
int[] numerot3 = new int[4];
luvut1[0] = 2;
luvut1[1] = 7;
luvut1[2] = 5;
luvut1[3] = 6;
```

## Taulukon koko ja sen arvojen läpikäynti

Taulukon koon saa selville taulukkoon liittyvän muuttujan `length` avulla. `length`-muuttujaan pääsee käsiksi kirjoittamalla taulukon muuttujan nimen, pisteen sekä length-muuttujan nimen, eli esimerkiksi `taulukko.length`. 

**Huomaa**, että kyseessä ei ole metodikutsu kuten listoilla, eli `taulukko.length()` ei toimi.

Taulukon alkioiden läpikäynti voidaan toteuttaa esim. while- tai for-toistolauseen avulla.
```java
int[] luvut = new int[4];
luvut[0] = 42;
luvut[1] = 13;
luvut[2] = 12;
luvut[3] = 7;

System.out.println("Taulukossa on " + luvut.length + " alkiota.");

int indeksi = 0;
while (indeksi < luvut.length) {
    System.out.println(luvut[indeksi]);
    indeksi++;
}
```
[Katso Java Visualizerissa!](https://goo.gl/XzEiAc)

Tämän esimerkki on lainattu Helsingin yliopiston Agile Education Research –tutkimusryhmän oppimateriaalista, joka on lisensoitu Creative Commons BY-NC-SA-lisenssillä. https://2017-ohjelmointi.github.io/part6/ 

# Taulukon hyödyntämistä

## Merkkijonon split-metodi

Merkkijonoilla (String-luokka) on `split`-niminen metodi, jolla merkkijono voidaan pilkkoa osiin tietyn merkin tai osamerkkijonon kohdalta. Split palauttaa **merkkijonotaulukon**, jossa on alkuperäisen merkkijonon osat ilman pilkkomisessa käytettyjä merkkejä.

```java
String teksti = "sana sanat sanoja";

// pilkotaan välilyöntien kohdalta
String[] sanat = teksti.split(" ");

System.out.println(sanat.length);
System.out.println(sanat[0]);
System.out.println(sanat[1]);
System.out.println(sanat[2]);
```

[Katso Java Visualizerissa!](https://goo.gl/MQ4HW8)

## For each –toistokäsky ja listojen sekä taulukoiden läpikäynti

Taulukon kaikki alkiot voidaan käydä läpi for each -toistokäskyllä kuten listojen alkiot. https://www.google.com/search?q=for+each+loop+java+array


## Vertailu: taulukoiden ja listojen eroja

```java
// Luodaan 10 merkkijonon pituinen taulukko:
String[] taulukko = new String[10];

// Lisätään sana taulukkoon:
taulukko[0] = "taulukkoon";

System.out.println(taulukko[0]);

System.out.println(taulukko.length); // 10
// Luodaan tyhjä merkkijonolista:
List<String> lista = new ArrayList<>();

// Lisätään sana listaan
lista.add("listalle");

System.out.println(lista.get(0));

System.out.println(lista.size()); // 1
```

Taulukot                                            | Listat
----------------------------------------------------|--------------------------
Taulukon pituus määrätään sitä luotaessa            | Listan pituus kasvaa alkioita lisättäessä
Taulukon alkioita käsitellään hakasulkujen avulla   | Listan alkioita käsitellään metodien avulla
Taulukon pituus on aina kiinteä                     | Lista luodaan tyhjänä ja se kasvaa rajattomasti
Taulukko voidaan täyttää missä vain järjestyksessä  | Listaa ei voida alkaa täyttää muualta kuin ensimmäisestä arvosta
Taulukkoon ei voida lisätä arvoja väleihin          | Listalle voi lisätä arvoja väleihin

## Taulukon järjestäminen
Taulukon kaikki alkiot voidaan järjestää kasvavaan järjestykseen seuraavasti:

```java
Arrays.sort(numeroTaulukko);
```

Vertaa listojen järjestäminen:

```java
Collections.sort(numeroLista);
```

## Taulukon tulostaminen

Mitä tapahtuu kun taulukko tulostetaan?
```java
String[] kirjaimet = new String[] { "j", "a", "v", "a" };

Arrays.sort(kirjaimet);

System.out.println(kirjaimet); // Tulostaa hämmentävän merkkijonon: [Ljava.lang.String;@106d69c
```

**Taulukoilla ei ole oletuksena selkeää merkkijonoesitystä.**

`Arrays`-apuluokasta löytyy kuitenkin staattinen metodi `Arrays.toString(taulukko)` merkkijonoesityksen muodostamiseksi. `toString` muodostaa merkkijonon, jonka voimme ottaa talteen muuttujaan tai antaa suoraan esim. `println`-metodille:
```java
import java.util.Arrays; // alkuun tämä
```
```java
String[] kirjaimet = new String[] { "j", "a", "v", "a" };

Arrays.sort(kirjaimet);

String tekstina = Arrays.toString(kirjaimet);

System.out.println(tekstina); // tulostaa [a, a, j, v]
```

## Viittaustyyppiset muuttujat käytännössä

```java
import java.util.Arrays;

public class ViittaustyyppisetMuuttujat {

    public static void main(String[] args) {

        String[] nimet = { "Johan", "Ludvig", "Runeberg" };
        String merkkijono = Arrays.toString(nimet);
        System.out.println(merkkijono);

        String etunimi = nimet[0]; // "Johan"
        String toinenNimi = nimet[1]; // "Ludvig"
        String sukunimi = nimet[2]; // "Runeberg"

        // EI KOPIOI TAULUKKOA, VAAN VIITTAA SAMAAN TAULUKKOON:
        String[] lyhennetty = nimet;

        lyhennetty[0] = etunimi.substring(0, 1); // "J"
        lyhennetty[1] = toinenNimi.substring(0, 1); // "L"

        // Lyhennetty taulukko sisältää muuttuneet merkkijonot
        System.out.println(Arrays.toString(lyhennetty));

        // Myös alkuperäisen muuttujan kautta sisältö on muuttunut
        System.out.println(Arrays.toString(nimet));
    }
}
```

## Main-metodin args-taulukko

Main-metodin otsikossa esiintyvä `String[] args` on merkkijonotaulukko, joka sisältää ohjelmalle annetut komentoriviparametrit. Eclipsessä suoritettaessa ne ovat tyhjät, mutta komentorivisovelluksissa tarvitsemme tätä taulukkoa.

```java
import java.util.Arrays;

public class ArgsTaulukonTulostaminen {

    public static void main(String[] args) {
        // args on merkkijonotaulukko
        System.out.println(args.length);
        System.out.println(Arrays.toString(args));
    }
}
```

## Syventävää tietoa: Taulukon kopioiminen

Taulukkoa ei ole mahdollista lyhentää tai pidentää, mutta siitä voidaan luoda eri pituinen kopio.
* Jos kopio on alkuperäistä taulukkoa lyhyempi, jää arvoja pois. 
* Jos kopio on alkuperäistä pidempi, täytetään loppuosa oletusarvoilla (`null`, 0 jne).

Monet operaatiot, kuten taulukon järjestäminen, muuttavat alkuperäistä taulukkoa pysyvästi. Usein alkuperäinen data halutaan pitää muuttumattomana, jolloin operaatioita tehdään taulukon kopiolle.

```java
String[] kirjaimet = new String[] { "j", "a", "v", "a" };

String[] kopio = Arrays.copyOf(kirjaimet, kirjaimet.length);

String[] alkuosa = Arrays.copyOf(kirjaimet, 2); // [j, a]
```

## Yhteenveto: Arrays-apuluokka

Ote hyödyllisistä apumetodeista taulukoiden käyttöön:

**Arrays.copyOf(original, int newLength)**

> Copies the specified array, truncating or padding (if necessary) so the copy has the specified length.

**Arrays.toString(array)**

> Returns a string representation of the contents of the specified array.

**Arrays.sort(array)**

> Sorts the specified array into ascending order.

Lähde: https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html


---

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA 3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/) -lisenssillä. 