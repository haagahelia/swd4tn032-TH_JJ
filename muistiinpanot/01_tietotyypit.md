Tämä sivu on siirretty Wikiin: https://github.com/haagahelia/swd4tn032-TH_JJ/wiki

# Ohjelman suorittaminen, muuttujat, syötteen lukeminen ja ehtolauseet

Kurssin aloitus:

* Kurssille hyväksyminen ja läsnäololista
* Minkälainen on taustasi ohjelmoinnissa?
* Minkälaiset odotukset sinulla on tästä kurssista?
* Oletko käynyt tietokantakurssia tai onko se sinulla parhaillaan käynnissä?


## Yksinkertainen Java-ohjelma

Main-metodi, tekstin tulostaminen (`HelloWorld.java`)
```java
public class HelloWorld {

    public static void main(String[] args) {

        // Tulostaa ruudulle tekstin: Hello world!
        System.out.println("Hello world!");

    }
}
```

Java-ohjelmat koostuvat aina luokista (class). Tyypillisesti kukin luokka tallennetaan samannimiseen .java-päätteiseen tiedostoon (HelloWorld.java)

Ohjelman käskyt kirjoitetaan metodeihin. Main-metodilla on erityinen rooli: ohjelman suoritus alkaa main-metodista. Toistaiseksi emme keskity muihin main-metodin yksityiskohtiin.

Metodit koostuvat käskyistä, jotka kirjoitetaan omille riveilleen ja rivit päätetään puolipisteellä.

`System.out.println()`-metodikutsu tulostaa annetun tekstin ruudulle.

**Tulostettava teksti on kirjoitettu lainausmerkkeihin, koska se ei ole suoritettavaa koodia, vaan tekstidataa.** Tekstimuotoista dataa kutsutaan ohjelmoinnin yhteydessä merkkijonoiksi (string).


# Java-kielisen ohjelman suorittaminen

Java on käännettävä ohjelmointikieli:
* Ohjelmoija kirjoittaa lähdekoodin .java-tiedostoon
* Kirjoitettu lähdekoodi käännetään tavukoodiksi (.class–tiedostoja)
* Käännetty ohjelma voidaan suorittaa Javan virtuaalikoneella eri alustoilla (Windows, OS X, Linux, Android...)
* Kääntäjä (compiler) tarkastaa koodin oikeellisuuden: syntaksivirheet havaitaan jo ennen koodin suorittamista

Eclipse automatisoi lähdekoodin kääntämisen ja tekee ohjelman suorituksesta helppoa.
* Lähdekoodi käännetään aina kun tiedosto tallennetaan
* Ohjelma voidaan suorittaa yhtä nappia painamalla

Eclipsen käyttö, tehdään yhdessä:
1. Avatkaa koneiltanne Eclipse-sovelluskehitin
2. Eclipse pyytää aluksi valitsemaan työtilan (workspace), eli hakemiston tiedostojen tallennusta varten
3. Luokaa työtila M-asemalle 
4. Luokaa itsellenne uusi Java-projekti: `File 🡪 New 🡪 Java project`
5. Lisätkää projektiin uusi Java-luokka nimeltä TerveMaailma (TerveMaailma.java)
6. Lisätkää luokkaan main-metodi, jonka sisällä tulostakaa teksti "Terve maailma!"
7. Suorittakaa kirjoittamanne koodi (Eclipsen run-painike)
8. Eclipsen konsoliin pitäisi nyt tulostua toivottu teksti

## Viopen tyypillisiä virhetilanteita

* package-lause luokan alussa
* Käännösvirhe
* Virheellinen luokan nimi
* ...

## Tulostaminen

Javassa on erilaisia metodeita ja tietovirtoja, joilla voidaan tulostaa esim. tekstiä ja lukuja ruudulle.

`System.out` on oletustietovirta, johon voidaan tulostaa seuraavasti:

```java
System.out.println(tuloste);
```

Tulostaa annetun arvon ja lopuksi aina rivinvaihdon, eli seuraava tuloste tulostuu eri riville.

```java
System.out.print(tuloste);
```

Tulostaa annetun arvon, mutta ei tee rivinvaihtoa. Tällöin seuraava tuloste tulee jatkoksi samalle riville. 


### Pidempi esimerkki

```java
// tiedosto Tulostaja.java
public class Tulostaja {
    public static void main(String[] args) {
        // koodin yhteyteen voidaan kirjoittaa myös kommentteja
        System.out.println(1 + 2);
        System.out.println(4 - 1);
        System.out.println(2 * 4);
        System.out.println(9 / 2); // huomaa tämän operaation tulos!! (4)
    }
}
```

Luvuille voidaan Javassa suorittaa tavanomaiset laskuoperaatiot: yhteen-, vähennys-, kerto- ja jakolaskut.

Saman metodin sisään voidaan luonnollisesti kirjoittaa lukuisia käskyjä, eli suoritettavia lausekkeita. 

Huomaa, että koodin luettavuuden parantamiseksi koodilohkot sisennetään aina syvemmälle kuin niitä ympäröivät lohkot.

## Muuttujat

Ohjelmissa käytettäviä arvoja, esimerkiksi numeroita (int) tai merkkijonoja (String), voidaan pitää tallessa muuttujissa. 

Javassa muuttujilla on aina ennalta määritettävä tyyppi, joka määrää sen, minkä tyyppisiä arvoja kyseiseen muuttujaan voidaan asettaa.

Muuttujiin asetetaan arvoja sijoitusoperaattorilla (yhtäsuuruusmerkki eli =).

Muuttujia voidaan käyttää myöhemmin esimerkiksi laskutoimituksissa kirjoittamalla luvun tilalle muuttujan nimi.

```java
int leveys = 2;
int korkeus = 3;
int ala = leveys * korkeus;

System.out.println(ala);

// asetetaan uusia arvoja:
leveys = 4;
korkeus = 6;

// mikä luku tulostuu viimeisenä?
System.out.println(ala);
```

Muuttujaa luotaessa määritellään sen tyyppi (esim. `int`) sekä nimi (`leveys`). Samalla asetamme siihen arvon `2`. Muuttujia voidaan käyttää mm. laskuoperaatioissa.

### String-muuttuja

Vastaavasti merkkijonoja voidaan asettaa muuttujiin, kun muuttujan tyypiksi määritellään `String`, eli merkkijono.

Merkkijonoja voidaan yhdistää toisiinsa, eli konkatenoida, plus-merkillä (`+`)

```java
String etunimi = "Matti";
String sukunimi = "Meikäläinen";
String kokonimi = etunimi + " " + sukunimi;

// Tulostaa tekstin: Matti Meikäläinen
System.out.println(kokonimi);
```

Näiden muuttujien tyyppi on String, eli niihin voidaan asettaa merkkijonoja

### Vakiot

Muuttuja voidaan myös määritellä ”vakioksi”, jolloin siihen asetettavaa arvoa ei voida enää korvata toisella arvolla. Tämä tehdään lisäämällä sana `final` muuttujan määrittelyn alkuun:

```java
// Final-avainsanalla voidaan merkitä arvoja, jotka eivät saa muuttua.
// Desimaalilukuja varten Javassa on double-tyyppi:
final double PI = 3.141592;
```

Vakiot nimetään usein isoilla kirjaimilla, käyttäen tarvittaessa alaviivaa välilyönnin tilalla.


### Muuttujien nimeäminen

* Muuttujien nimissä voi olla kirjaimia, numeroita, $ ja _
* $ ja _ -merkkien tai "ääkkösten" käyttöä ei kuitenkaan suositella
* Muuttujan nimi ei saa alkaa numerolla
* Usean sanan pituiset muuttujan nimet kirjoitetaan yhteen, jälkimmäiset sanat isoilla alkukirjaimilla (camelCase):

```java
String nykyinenKuukausi = "tammikuu";
int paivia = 31;
```

```java
// EI NÄIN:
String nykyinen kuukausi = "tammikuu";
int päiviä = 31;
```

### Tyyppien tarkistus
Java-kääntäjä varmistaa, että muuttujiin ei aseteta väärän tyyppisiä arvoja
Esim. int-tyyppisessä muuttujassa voidaan varastoida ainoastaan kokonaislukuja:

```java
int numero = 1;

// Aiheutuu virhe "Type mismatch: cannot convert from String to int"
numero = "kaksi";
```

### Javan tietotyyppejä: kokonaisluvut (int ja long)

Javassa kokonaisluvut ovat oletuksena tyyppiä `int` (integer). `int` on 32-bittinen kokonaisluku väliltä  -2 147 483 648 – 2 147 483 647.

Kun tarvitaan suurempia (tai pienempiä negatiivisia) lukuja, voidaan käyttää long-tyyppisiä lukuja.

long on 64-bittinen kokonaisluku väliltä -9 223 372 036 854 775 808 – 9 223 372 036 854 775 807

Luku määritellään long-tyyppisenä kirjoittamalla sen perään L-kirjain: 987_654_321_098_765_432**L**

```java
// Normaali kokonaisluku (int)
int ika = 20;

// Hyvin iso kokonaisluku (long)
long ihmisia = 7_644_362_948L;
```

(Lisäksi on olemassa pienemmät lukutyypit `byte` ja `short`, joita tarvitaan harvemmin)

### Kokonaislukujen "ylivuoto"

Jos laskutoimituksen tulos on suurempi kuin mitä kyseinen lukutyyppi pystyy esittämään, tapahtuu ns. ylivuoto, eli numero "pyörähtää ympäri"

Kokeile suorittaa seuraavat rivit. Mitä tuloksia saat ja miksi?

```java
// int-luvun ylivuoto:
System.out.println(2_147_483_647);
System.out.println(2_147_483_647 + 1);

// Sama long-tyyppisellä luvulla
System.out.println(2_147_483_647L + 1);
```

**Huom!*** Kokonaislukujen ylivuoto ei niinkään liity Javaan, vaan yleisesti siihen, miten luvut esitetään tietokoneen muistissa.

### Javan tietotyyppejä: liukuluvut (double)

Tietojenkäsittelyssä desimaalilukuja käsitellään tyypillisesti liukulukuina. 
Liukuluku-termi tulee siitä, että luvussa kokonais- ja desimaaliosille ei ole varattu kiinteää määrää bittejä, vaan pisteen paikka "liukuu" sen mukaan, kuinka suuresta tai pienestä luvusta on kyse.

Liukulukujen toteutuksesta johtuen niillä laskettaessa esiintyy usein pieniä laskuvirheitä, minkä vuoksi niitä ei tule käyttää täydellistä tarkkuutta vaativissa tarkoituksissa.

Javan oletustietotyyppi liukuluvuille on nimeltään `double`. Doublen tarkkuus on 10-kantaisessa järjestelmässä noin 15 numeroa, esimerkiksi `1234567.89012345`.

Esim. piin likiarvo on double-tyyppisenä 3.141592653589793.

(On olemassa myös epätarkempi float (32-bittinen), jota tarvitaan harvemmin.)

### Laskuvirheet liukuluvuilla

Laskutoimitukset liukuluvuilla ovat nopeita. Tietokoneet käsittelevät mm. pelien grafiikkaa ja muuta matematiikkaa liukuluvuilla. Esim. Javascript ei muuta käytäkään.

Liukulukujen toteutuksesta johtuen niillä laskettaessa esiintyy usein pieniä tarkkuusvirheitä, minkä vuoksi niitä ei tule käyttää täydellistä tarkkuutta vaativissa tarkoituksissa.

Kokeile suorittaa seuraava yhteenlasku. Minkä tuloksen saat?

```java
System.out.println(0.1 + 0.2); 
```

Liukulukujen laskuvirhe ei niinkään liity Javaan, vaan yleisesti siihen, miten liukuluvut esitetään tietokoneen muistissa.

### Aritmeettiset operaatiot

```
Operaattori | Käyttötarkoitus
------------|----------------
+           | Yhteenlasku (myös merkkijonojen yhdistäminen)
-           | Vähennyslasku
*           | Kertolasku
/           | Jakolasku
%           | Jakojäännös
```

Lähde: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html

#### Laskuoperaatiot Javassa

```java
1 + 2 = 3
4 - 1 = 3
2 * 4 = 8
8 / 2 = 4

// % -operaattorilla saadaan laskettua jakolaskun jakojäännös:
9 % 2 = 1

9.0 / 2 = 4.5

// Huom! Kokonaislukujen jakolasku on katkaiseva, eli 
// tulosta ei pyöristetä ja desimaaliosa "katkeaa" pois:
9 / 2 = 4

// Jos a ja b ovat kokonaislukuja, saadaan jakolaskun tulokseksi
// liukuluku (c) kertomalla ensin esim. jaettava luku liukuluvulla:
(1.0 * a) / b = c
```

Jos vähintään toinen luvuista on liukuluku, tulee myös tuloksesta liukuluku, jolloin katkaisua ei tapahdu. Kokonaisluvusta saadaan liukuluku helposti esim. kertomalla se luvulla 1.0.

## Lukujen pyöristäminen sekä ceil ja floor

Javan `Math`-luokasta löytyy lisäksi lukuisia erilaisia metodeja, joiden avulla voidaan pyöristää ylös, alas tai lähimpään kokonaislukuun:

```java
// Pyöristys aina alaspäin: 6.0
double a = Math.floor(6.8);

// Pyöristys aina ylöspäin: 7.0
double b = Math.ceil(6.1); 

// Pyöristys aina lähimpään tasalukuun: 6.0
double c = Math.round(5.6); 
```

Math.ceil:
> Returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer. 
>
> https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Math.html#ceil(double)

Math.floor:
> Returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer.
>
> https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Math.html#floor(double)

Math.round:
> Returns the closest int to the argument, with ties rounding to positive infinity.
>
> https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Math.html#round(double)

### Liukuluvun muuttaminen kokonaisluvuksi

Liukuluvulle voidaan tehdä **tyyppimuunos** kokonaisluvuksi kirjoittamalla sen eteen suluissa `(int)`:

```java
int a = (int) Math.round(5.6); 
```

### Yksittäisten arvojen operaatiot

Operaattori | Kuvaus
------------|---------
++          | Kasvattaa arvoa yhdellä
--          | Vähentää arvoa yhdellä
!           | Kääntää totuusarvon päinvastaiseksi

https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html

```java
int luku = 10;
luku++;
System.out.println(luku); // 11
luku--;
System.out.println(luku); // 10

boolean ok = true;

// ! kääntää totuusarvon vastakkaiseksi:
System.out.println(!ok); // false
```

**Luvun kasvattaminen, vähentäminen tai kertominen**

```java
int numero = 6;
numero += 5; 		//   numero = numero + 5
numero *= 3; 		//   numero = numero * 3
numero /= 7; 		//   numero = numero / 7

// Mikä luku tulostuu lopulta? Miksi?
System.out.println(numero);

// Tulos on 4, koska: (6 + 5) * 3 / 7 = 4.714,
// josta desimaaliosa leikkautuu pois!
```

## Koodausharjoitus
Alla esitetyssä luokassa on kolme muuttujaa, joiden arvot tulostetaan ruudulle. Muokkaa ohjelmaa siten, että ohjelma laskee ja tulostaa myös muuttujien keskiarvon (7.333333333333333). 

Keskiarvoa ei saa pyöristää tai muulla tavoin muotoilla. 

**Huom!** Jos muuttujien arvoja muutetaan, tulee myös tulostuksen muuttua.


```java
public class LukujenKeskiarvo {

    public static void main(String[] args) {
        int eka = 9;
        int toka = 7;
        int kolmas = 6;

        System.out.println("eka: " + eka);
        System.out.println("toka: " + toka);
        System.out.println("kolmas: " + kolmas);

        // täydennä tänne keskiarvon laskeminen
        System.out.println("keskiarvo: ");
    }
}
```

Tehtävä on lainattu [Helsingin yliopiston Agile Education Research -tutkimusryhmän ohjelmointikurssilta](https://2017-ohjelmointi.github.io/part1/#exercise-8-kolmen-luvun-keskiarvo) ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä.

## Syötteen lukeminen näppäimistöltä

Javassa on erilaisia tietovirtoja, kuten:

Tietovirta  | Tarkoitus
------------|------------------
`System.in` | syötteiden lukeminen käyttäjältä (konsolista)
`System.out`| tulostaminen konsoliin
`System.err`| virheilmoitusten tulostaminen (punainen teksti)

Tiedon lukemiseksi `System.in`-tietovirrasta kannattaa käyttää `Scanner`-luokkaa, joka tarjoaa käteviä metodeja eri tyyppisten syötteiden lukemiseksi.

### Scanner-luokka

Kun Java-ohjelmia suoritetaan komentoriviltä, voidaan ohjelmalle antaa näppäimistöä käyttäen mm. tekstiä ja lukuja.

Kun käyttäjä kirjoittaa tekstiä ja painaa enter-painiketta, kirjoitetut merkit päätyvät Javan `System.in` -tietovirtaan.

Kirjoitettu teksti ja numerot voidaan lukea tietovirrasta merkkijonoiksi ja numeroiksi `Scanner`-luokan avulla. `Scanner`-luokka sijaitse `java.util`-nimisessä "paketissa", josta se täytyy ottaa käyttöön omaan Java-luokkaan import-komennolla:

    import java.util.Scanner;

### Käyttäjän syötteen lukeminen
Kun Scanner on otettu käyttöön import-käskyllä, voidaan ohjelmaan luoda uusi syötteitä lukeva Scanner-olio. 

Oliot luodaan aina new-avainsanalla. `Scanner`-luokan tapauksessa oliota luotaessa pitää lisäksi määritellä, mistä tietovirrasta syötteet luetaan:

Kun luemme syötteet näppäimistöltä, tietovirta on `System.in`.

Meidän täytyy myös laittaa luomamme `Scanner`-olio talteen myöhempää käyttöä varten, minkä vuoksi luomme `Scanner`-tyyppisen muuttujan:

```java
Scanner lukija = new Scanner(System.in);
```

Kun Scanner-olio on luotu ja se on tallessa muuttujassa, voidaan sen avulla lukea mm. tekstiä ja numeroita.  Jos käyttäjä on jo kirjoittanut dataa tietovirtaan, lukee Scanner valmiiksi syötettyä dataa.

Jos tietovirrassa ei ole valmiiksi dataa, jää ohjelma odottamaan, että käyttäjä kirjoittaa syötteen ja painaa enter-painiketta.

Kokonainen rivi tekstiä voidaan lukea nextLine-nimisellä metodilla:

```java
Scanner lukija = new Scanner(System.in);
System.out.println("Kirjoita tekstiä: ");

String teksti = lukija.nextLine();
```

Annettu teksti otetaan talteen esimerkiksi sijoittamalla se `String`-tyyppiseen muuttujaan, kuten yllä.

`nextLine()`–metodi lukee tietovirrasta tekstiä seuraavaan rivinvaihtoon asti. Vastaavasti tietovirrasta voidaan lukea yksittäisiä sanoja tai eri tyyppisiä lukuja:


* `nextInt()` lukee tietovirrasta seuraavan kokonaisluvun
* `nextDouble()` lukee tietovirrasta seuraavan liukuluvun
* `next()` lukee tietovirrasta merkit seuraavaan tyhjään merkkiin asti

```java
Scanner lukija = new Scanner(System.in);

System.out.println("Kirjoita sana:");
String sana = lukija.next();

System.out.println("Kirjoita kokonaisluku:");
int luku = lukija.nextInt();

System.out.println("Kirjoita liukuluku:");
double liukuluku = lukija.nextDouble();
```

**Huom!** Jos tietovirrassa on odottamassa esim. kirjaimia, ja sieltä yritetään lukea numeroa, ohjelma kaatuu ajonaikaiseen poikkeukseen.

### Koodausharjoitus
Kirjoita luokka `HeiEtunimi`. Toteuta luokkaan `main`-metodi, jossa kysytään ensin käyttäjän etunimi, ja sen jälkeen tervehditään käyttäjää nimeltä. 

Tarvitset tehtävässä `Scanner`-luokkaa syötteen lukemiseksi.

Esimerkki ohjelman suorituksesta:

```
Syötä etunimi: Teppo
Hei Teppo!
```

# Liukulukujen tulostaminen

## `DecimalFormat`-luokka

Liukulukuja tulostettaessa tulostettavien desimaalien määrä vaihtelee ja desimaalierottimena käytetään oletuksena pistettä. Tulostettavien desimaalien määrään ja käytettävään desimaalierottimeen voidaan vaikuttaa muotoilemalla desimaaliluvut Javan `DecimalFormat`-luokan avulla.

**Tulet tarvitsemaan DecimalFormat-luokkaa Viope-tehtävien ratkaisemisessa.**

`DecimalFormat`-luokka otetaan käyttöön kirjoittamalla luokan alkuun import-komento:

```java
import java.text.DecimalFormat;
```

Sen jälkeen luodaan uusi `DecimalFormat`-olio, jolle kerrotaan, missä muodossa luvut halutaan tulostaa. `"0.00"` muotoilee luvun kahden desimaalin tarkkuudella käyttäen käyttöjärjestelmän desimaalierotinta (pilkku).

DecimalFormat-oliolla on `format`-metodi, joka muotoilee liukuluvun merkkijonoksi. Esimerkiksi:

```java
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

// annetaan muotoiltava luku format-metodille, saadaan takaisin muotoiltu merkkijono
String muotoiltu = kaksiDesimaalia.format(liukuluku);

// tulostetaan lopulta muotoiltu merkkijono
System.out.println(muotoiltu); // 123,46 <-- pyöristetty kahteen desimaaliin, erottimena pilkku
```

# Kommentit

Javassa on kolme eri kommenttityyliä:

```java
/**
 * Luokan ja julkisten metodien "viralliset" dokumentaatiokommentit kirjoitetaan
 * /** -alulla.
 */
public class Kommentit {

    public static void main(String[] args) {
        /*
         * Koodinpätkille voidaan kirjoittaa monirivisiä kommentteja /* -merkkien
         * avulla.
         */
        int luku = 1;

        // Yksirivisille kommenteille laitetaan vain kaksi kauttaviivaa
        System.out.println(luku);
    }
}
```


# Viope-harjoitukset

Rekisteröitykää viimeistään nyt Viopeen ja liittykää kurssille. Harjoitukset lähtevät käyntiin heti, ensimmäisiä tehtäviä tehtiin jo tällä tunnilla.

Kun kohtaatte ongelmia tehtävissä, pyytäkää apua ja vinkkejä kurssin Teams-työtilan keskustelualueella!

Muistathan, että teknisistä syistä johtuen Viopeen palautettavista ratkaistuista täytyy poistaa mahdolliset package -lauseet luokan yläpuolelta

---

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA 3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/) -lisenssillä. 