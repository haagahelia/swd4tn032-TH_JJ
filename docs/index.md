## Yksinkertaisen Java-ohjelman rakenne


Java-ohjelmat koostuvat aina luokista (class). Tyypillisesti kukin luokka tallennetaan samannimiseen .java-päätteiseen tiedostoon esim. *HelloWorld.java*:

```java
public class HelloWorld {

    public static void main(String[] args) {

        // Tulostaa ruudulle tekstin: Hello world!
        System.out.println("Hello world!");

    }
}
```

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

Javassa kokonaisluvut ovat oletuksena tyyppiä `int` (integer). `int` on 32-bittinen kokonaisluku väliltä  -2 147 483 648 – 2 147 483 647.

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

Operaattori | Käyttötarkoitus
------------|----------------
\+          | Yhteenlasku (myös merkkijonojen yhdistäminen)
\-          | Vähennyslasku
\*          | Kertolasku
/           | Jakolasku
%           | Jakojäännös


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

Tehtävä on lainattu [Helsingin yliopiston Agile Education Research -tutkimusryhmän ohjelmointikurssilta](https://2017-ohjelmointi.github.io/part1/#exercise-8-kolmen-luvun-keskiarvo) ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä.

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

---

# Boolean-arvot (totuusarvot)

Javassa on kaksi totuusarvoa:

```java
boolean tosi = true;
boolean epatosi = false;
```

Boolean-tyyppisiä arvoja ja boolean-muuttujia voidaan monella tapaa käyttää kuten numeroita ja merkkijonoja:

```java
System.out.println(true);
System.out.println(false);

boolean totuusarvo = true;
System.out.println(totuusarvo);
```

Boolean arvojen kääntäminen (negaatio):

```java
boolean yes = true;
boolean no = !yes; // --> false
```

## Arvojen vertailu ja loogiset operaatiot

Kun vertailemme Javassa eri arvoja, saamme vertailun tuloksiksi totuusarvoja:

```java
System.out.println(10 > 5);
System.out.println(100 < 3);
```

Edellä esitetyt koodirivit tulostavat ruudulle seuraavat tulokset: 

```
true
false
```

Tulostamisen lisäksi vertailuoperaatioiden arvoja voidaan käyttää kuten muitakin arvoja Javassa. Voimme siis esimerkiksi sijoittaa niitä muuttujiin:

```java
int numero = lukija.nextInt(); // oletetaan että lukija on Scanner-olio

boolean yliKolme = numero > 3;
boolean alleSata = numero < 100;
```


## Vertailuoperaattorit
Javassa löytyy arvojen vertailuun seuraavat operaattorit:

Operaattori | Selitys
------------|-----------
==          | yhtä suuri kuin
!=          | eri suuruinen kuin
&gt;        | suurempi kuin
&gt;=	    | suurempi tai yhtä suuri kuin
&lt;	    | pienempi kuin
&lt;=	    | pienempi tai yhtä suuri kuin
&&	        | ja
\|\|        | tai
!           | negaatio <br />`!false == true`<br /> `!true == false`

https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html


Kaikki seuraavan esimerkin muuttujat saavat arvoikseen `true`, eli vertailujen tulokset ovat tosia:

```java
int luku = 1;

boolean b1 = luku == 1;
boolean b2 = luku > 0;
boolean b3 = luku < 2;
boolean b4 = luku >= 1;
boolean b5 = luku <= 1;
boolean b6 = luku != 0;
```

## Totuustaulut

Totuusarvoja voidaan yhdistellä ja- sekä tai-operaatioilla. Näiden operaatioiden molempien osapuolien on oltava totuusarvoja (tai lausekkeita, joiden tuloksena saadaan totuusarvo).

### Ja (`&&`)

Lausekkeen `a && b` arvoksi tulee `true` vain silloin, kun molemmat arvoista ovat `true`:

| a     | b     | a \&\& b |
|-------|-------|--------  |
| true  | true  | true     |
| True  | false | false    |
| false | true  | false    |
| false | false | false    |


### Tai (`||`)

Lausekkeen `a || b` arvoksi tulee `true` aina, kun vähintään toinen arvoista on `true`:

| a     | b     | a \|\| b |
|-------|-------|----------|
| true  | true  | true     |
| true  | false | true     |
| false | true  | true     |
| false | false | false    |


# If-ehtolause

Totuusarvojen yleinen käyttötarkoitus on koodin suorittaminen vain tietyn ehdon täyttyessä. Tällöin tietyt koodirivit suoritetaan ainoastaan silloin, kun niille asetettu ehto toteutuu.

Tarkastettava ehto kirjoitetaan `if`-avainsanan jälkeen sulkujen sisään: `if (ehto)`. Ehdon toteutuessa suoritettavat koodirivit kirjoitetaan uuteen koodilohkoon `{  }` heti `if`-lauseen jälkeen:

```java
if (ehto) {
    // suoritettava koodi
}
// jos ehto on epätosi, siirtyy suoritus suoraan tänne
```

Ehtona on aina oltava totuusarvo tai totuusarvon saava lauseke, esimerkiksi:

```java
boolean onPaiva = true;

if (onPaiva) {
    // tähän lohkoon kirjoitettu  koodi suoritetaan 
    // vain, jos ehto on tosi
    System.out.println("Hyvää päivää!");
}
```

If-lauseen sulkujen sisällä voi olla myös lauseke, joka evaluoidaan, ja päätös tehdään saadun tuloksen mukaan.

```java
int kello = 16;

if (kello < 18) {
    // tähän lohkoon kirjoitettu koodi suoritetaan, 
    // jos kello-muuttujan arvo on alle 18
    System.out.println("Hyvää päivää!");
}
```

## Vertailu "== true"

Toisinaan ehtolauseen sisään kirjoitetaan kirjoitettavan arvon vertailu `true`-arvoon:

```java
if (ehto == true) { }
```

Tämä on kuitenkin turhaa, koska `ehto == true` saa aina arvokseen saman arvon kuin `ehto`, eli voimme käyttää suoraan `ehto`-muuttujan arvoa:

```java
if (ehto) { }
```

## Loogisten operaattorien käyttäminen

Ehtolauseessa voidaan evaluoida myös monimutkaisempia lausekkeita, joissa tehdään useita eri vertailuja:

```java
int kello = 16;

if (kello >= 10 && kello < 18) {
    // tähän lohkoon kirjoitettu koodi suoritetaan vain,
    // jos kello-muuttujan arvo on suurempi tai 
    // yhtä suuri kuin 10 JA samalla alle 18
    System.out.println("Hyvää päivää!");
}
```

Edellä oleva ehto toteutuu vain, jos arvo on samaan aikaan sekä `>= 10` että `< 18`. Kellonajoista yön voidaan ajatella olevan sekä ensimmäinen että viimeinen vuorokaudenaika, eli yön selvittämisessä riittää että arvo on joko `>= 22` tai `< 7`.

```java
int kello = 16;

if (kello >= 22 || kello < 7) {
    // tähän lohkoon kirjoitettu koodi suoritetaan
    // jos kumpi tahansa ehdoista toteutuu!
    System.out.println("Hyvää yötä!");
}
```

Erilaisia ehtoja voidaan kirjoittaa myös erillisiksi lausekkeiksi, joiden tulos sijoitetaan muuttujaan:

```java
// vertailu suoritetaan ensin ja sen tulos (true tai false) asetetaan muuttujaan
boolean onPaiva = (kello >= 10 && kello < 18);
boolean onYo = (kello >= 22 || kello < 7);
```

## Oikean kellonajan käyttäminen

Kellonajan "kovakoodaaminen", kuten yllä, ei tietenkään ole toiminnallisesti järkevää. Oikeaa kellonaikaa voidaan käyttää esimerkiksi seuraavalla tavalla Javan `LocalTime`-luokan avulla (luokan alkuun "`import java.time.LocalTime;`"):

```java
// luodaan olio ja asetetaan se uuteen muuttujaan:
LocalTime nykyhetki = LocalTime.now();

// kutsutaan getHour-metodia ja otetaan vastaus talteen:
int tunnit = nykyhetki.getHour();

if (tunnit >= 10 && tunnit < 18) {
    // tähän lohkoon kirjoitettu koodi suoritetaan vain,
    // jos tunnit-muuttujan arvo on suurempi tai 
    // yhtä suuri kuin 10, mutta kuitenkin alle 18
    System.out.println("Hyvää päivää!");
}
```

## Else-lohko

Vapaaehtoisessa else-lohkossa oleva koodi suoritetaan, mikäli if-lauseen ehto ei toteutunut:

```java
int kello = 16;

if (kello >= 10 && kello < 18) {
    System.out.println("Hyvää päivää!");
} else {
    // Tässä lohkossa oleva koodi suoritetaan, jos 
    // edellä ollut if-ehto ei toteutunut 
    System.out.println("Tervehdys!");
}
```

Else-avainsana koodilohkoineen kirjoitetaan heti if-lohkon jälkeen.

## if / else if / else

`else if`-lohkossa oleva koodi suoritetaan, jos edeltävien ehtolauseiden ehdot eivät ole toteutuneet ja sen ehto toteutuu:

```java
int kello = 16;

if (kello >= 22) { // Tämä tarkastus tehdään ensin
    System.out.println("Hyvää yötä!");
} else if (kello >= 17) { // tarkastetaan vain, jos ensimmäinen oli epätosi
    System.out.println("Hyvää iltaa!");
} else {
    // Tänne päädytään, jos kaikki edellä olleet ehdot olivat epätosia
    System.out.println("Hyvää päivää!");
}
```

`if-else if-else` -ketjun ehtojen tarkastaminen päättyy aina ensimmäiseen `true`-arvon saaneeseen vertailuun.

## Koodaustehtävä (ks. Viope)
Kirjoita luokka `Tervehdys` ja siihen `main`-metodi, joka tulostaa kellonajasta riippuen erilaisen tervehdyksen.

Aikaväli    | Tervehdys
---------   |----------
7:00-9:59   | Hyvää huomenta!
10:00-16:59 | Hyvää päivää!
17:00-21:59 | Hyvää iltaa!
22:00-6:59  | Hyvää yötä!

## Sisäkkäiset ehtorakenteet

```java
/*
 * Tässä esimerkissä demonstroidaan sisäkkäistä vaihtoehtorakennetta. Käyttäjän
 * ensimmäisestä vastauksesta riippuen häneltä joko kysytään toinen kysymys tai
 * tulostetaan vastaus suoraan. Toisen kysymyksen vastauksesta riippuen
 * suoritetaan jompi kumpi vaihtoehtoisista lohkoista.
 */
public class JunalippujenHinta {

    /*
     * 1. Kysytään ostaako käyttäjä kuukausilipun vai kertalippuja
     * 
     * 2. Jos ostaa kuukausilipun, kerrotaan kuukausihinta
     * 
     * 3. Jos kertalippuja, kysytään kuinka monta, ja kerrotaan tulisiko
     * kuukausilippu halvemmaksi
     */
    public static void main(String[] args) {
        final int kertalipunHinta = 10;
        final int kuukausilipunHinta = 100;

        Scanner lukija = new Scanner(System.in);

        System.out.println("Ostatko kuukausilipun (1) vai kertalippuja (2)?");
        int vastaus = lukija.nextInt();

        if (vastaus == 1) {
            System.out.println("Kuukausilippu maksaa " + kuukausilipunHinta + " €");
        } else {
            System.out.println("Kuinka monta kertalippua käytät kuukaudessa?");
            int kertalippuja = lukija.nextInt();
            int kokonaishinta = kertalippuja * kertalipunHinta;

            if (kokonaishinta > kuukausilipunHinta) {
                System.out.println("Kuukausilippu olisi halvempi");
            } else {
                int saasto = kuukausilipunHinta - kokonaishinta;
                System.out.println("Säästät " + saasto + " € verrattuna kuukausilippuun");
            }
        }

        lukija.close();
    }
}
```

# Kolme eri tapaa vertailla: `!=`, `!` (negaatio) ja `== false`

```java
public class Merkkijonokertaus {

    public static void main(String[] args) {
        String lento = "zz105";

        boolean finnairinLento = lento.startsWith("ay");
        // Kolme eri tapaa tarkastaa sama ehto:

        if (finnairinLento == false) {
            System.out.println("Ei ole finnairin lento");
        }

        if (finnairinLento != true) {
            System.out.println("Ei ole finnairin lento");
        }

        // negaatio: muutta true-arvon falseksi ja toisin päin
        if (!finnairinLento) {
            System.out.println("Ei ole finnairin lento");
        }
    }
}
```

# Syventävää osaamista: switch/case -rakenne 💪
```java
/** By Educative, Inc 
 * https://www.educative.io/edpresso/how-to-use-switch-case-statement-in-java
 * License: Creative Commons -Attribution -ShareAlike 4.0 (CC-BY-SA 4.0)*/
class HelloWorld {
    public static void main( String args[] ) {
      
        int weather = 2;
        //passing variable to the switch
        switch (weather) {
          //comparing value of variable against each case
        case 0:
          System.out.println("It is Sunny today!");
          break;
        case 1:
          System.out.println("It is Raining today!");
          break;
        case 2:
          System.out.println("It is Cloudy today!");
          break;
        //optional
        default:
          System.out.println("Invalid Input!");
        }
    }
}
```

Tutustu `switch-case`-rakenteeseen itsenäisesti esimerkiksi osoitteessa https://www.educative.io/edpresso/how-to-use-switch-case-statement-in-java.

---

# Toistorakenteet

Ehtorakenteiden tavoin toistorakenteilla voidaan vaikuttaa koodin suorituksen etenemiseen. Toistorakenteiden avulla tietyt koodirivit voidaan toistaa eri logiikoilla tai tarvittaessa jopa "ikuisesti".

Opettelemme tänään:

* toistamaan koodia tietyn määrän kertoja
* toistamaan koodia kunnes tietty ehto toteutuu
* käymään läpi olemassa olevia arvoja toiston avulla (iterointi).

## Extra: Vinkkejä Eclipsen käyttöön

* `Ctrl + välilyönti` näyttää ehdotuksia esim. olemassa olevien muuttujien ja luokkien nimistä
* `sysout (Ctrl + välilyönti)` täydentää `System.out.println();`
* `main (Ctrl + välilyönti)` ehdottaa `main`-metodin lisäämistä
* `Ctrl + 1` tarjoaa tapauskohtaisesti mahdollisuuksia mm. muuttujan nimen muuttamiseen, arvon sijoittamiseen muuttujaan yms.
* `Ctrl + shift + f` muotoilee koko tiedoston tai maalattujen rivien sisennykset, rivityksen ja muut muotoilut

## While-toistokäsky

While-lohkossa olevia käskyjä toistetaan, kunnes suluissa oleva ehto saa arvon false. 

```java
while (ehto) {
    // Toistetaan, jos ehto == true ja 
    // lopetetaan, kun ehto == false
}
```

Vertailun vuoksi: `while` ja `if`

```java
while (ehto) {
    // Toistetaan niin kauan
    // kuin ehto on tosi
}
if (ehto) {
    // Suoritetaan kerran, jos
    // ehto on tosi
}
```
### Esimerkki
```java
public static void main(String[] args) {
    int luku = 1;

    while (luku < 6) {
        System.out.println(luku);
        luku++; // sama kuin: luku = luku + 1;
    }
}
```
Yllä oleva esimerkki on lainattu Helsingin Yliopiston ohjelmointikurssilta ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä.

Tutustu ohjelman suorituksen vaiheisiin osoitteessa: https://2017-ohjelmointi.github.io/part2/#section-40-toistolauseen-ehto-toiston-lopettajana

## For-toistokäsky

For on tyypillinen silloin, kun haluttu suoritusten määrä on jo alussa tiedossa.

```java
for (alustus; ehto; kasvatus) {
    // Tähän lohkoon kirjoitettu koodi 
    // Toistetaan, kunnes ehto == false
}
```

### Esimerkki

1. suoritetaan alustus `(int i=0)`
2. tarkastetaan, onko ehto tosi `(i < 10)`
3. jos ehto on tosi, suoritetaan lohkossa oleva koodi
4. jos ehto on epätosi, poistutaan silmukasta
5. lohkon suorittamisen jälkeen tehdään kasvatus (`i++` kasvattaa yhdellä)
6. palataan kohtaan 2

```java
for (int i = 0; i < 10; i++) {
    // tämä lohko toistetaan i:n arvoille
    // 0, 1, 2, 3, 4, 5, 6, 7, 8 ja 9
    System.out.println(i);
}
```

## For- ja while-toistolauseet

Loogisesti samat toistorakenteet on mahdollista toteuttaa sekä while- että for-toistorakenteina. Rakenteeksi kannattaa valita niistä tapauskohtaisesti tarkoitukseen paremmin sopiva.

```java
for (int i = 0; i < 3; i++) {
    System.out.println(i); 
}
```

Sama while-toistokäskyllä:

```java
int i = 0; // toistossa käytettävän muuttujan alustus 

while (i < 3) { // toistoehto 
    System.out.println(i); 
    i++; // muuttujan päivitys
}
```

Tämä esimerkki on lainattu Helsingin yliopiston Agile Education Research -tutkimusryhmän ohjelmointikurssilta ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä. https://2017-ohjelmointi.github.io/part6/#section-35-for-toistolause 

Molemmat oheisista esimerkeistä tulostavat ruudulle luvut 0, 1 ja 2. Ainoa ero on se, että oikeanpuoleisessa esimerkissä muuttuja i on olemassa myös toistolauseen jälkeen.

## Toistolauseesta poistuminen eli (`break`)

Ikuinen toisto ei yleensä ole se mitä halutaan. Usein kuitenkin haluamme suorittaa koodia toistaiseksi kunnes käyttäjä esimerkiksi antaa tietyn syötteen. Tällöin voi olla hyödyllistä tehdä "ikuinen silmukka" eli:

```java
while (true) {
    // "ikuisesti" toistettava koodi
}
```

Toistolauseesta voidaan poistua kesken toistettavan lohkon suorituksen komennolla `break`.

Komento `break` on tyypillisesti toistolauseen lohkon sisällä olevassa ehtolauseessa, jossa tarkastellaan haluaako käyttäjä poistua toistolauseesta.

```java
/* 
 * Tämä esimerkki on lainattu Helsingin yliopiston Agile Education Research -tutkimusryhmän
 * ohjelmointikurssilta ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä. 
 * https://2017-ohjelmointi.github.io/part2/#section-47-toistolauseesta-poistuminen 
 */
Scanner lukija = new Scanner(System.in);

while (true) {
  System.out.println("osaan ohjelmoida!");

  System.out.print("jatketaanko (ei lopettaa)? ");
  String komento = lukija.nextLine();
  if (komento.equals("ei")) {
    break;
  }
}

System.out.println("kiitos ja kuulemiin.");
```

## Kuukauden sademäärien kysyminen toiston avulla

TODO: Kirjoitetaan oppitunnilla ohjelma, joka kysyy päivittäisiä sademääriä ennalta tunnetun määrän yksi kerrallaan ja kerää lukumäärän, summan, minimin, maksimin sekä laskee keskiarvon.

## Ennalta tuntemattoman ajanjakson sademäärien kysyminen

TODO: Muutetaan ohjelmaa niin, että lukumäärä ei ole ennalta tunnettu, vaan tietty käyttäjän syöte lopettaa kysymisen.

## ⭐️ Olemassa olevan sademäärädatan läpikäynti, eli iterointi ⭐️

Edellä käsitellyissä esimerkeissä ohjelman "käyttöliittymä" on ollut oleellinen osa toistorakenteen toimintaa: olemme kysyneet syötteitä ja tehneet tulosteita toiston aikana. Tämä on lopulta melko harvinainen tapa oikeissa ohjelmissa, koska hyvin usein tieto saadaan jostain muualta kuin käyttäjän näppäimistöltä, ja usein on tarve käydä kaikki johonkin tiettyyn asiaan liittyvät tiedot kerralla.

Tietojen läpikäynnistä käytetään termiä **iterointi**. Sademäärien historiatieto on helposti iteroitavissa, koska lähtökohtaisesti menneet sademäärät ovat jo ohjelman alussa käyttäjän tiedossa, eikä ohjelman toiminnan kannalta ole oleellista tai kiinnostavaa, kuinka monta sademäärätietoa ohjelma käsittelee. Käyttäjä voisi siis syöttää kaikki sademäärät kerralla tai tiedot voitaisiin lukea esim. tiedostosta.

Tulemme myöhemmillä viikoilla käsittelemään tietorakenteita, kuten listat ja taulukot, joiden läpikäynti toistorakenteilla on erittäin yleistä. Näiden lisäksi on myös monia muita *iteroitavia* tietotyyppejä, joiden arvoja voidaan käydä läpi yksi kerrallaan. Ensimmäinen meille tuttu iteroitava tietotyyppi on `Scanner`.

Scannerin avulla voimme kysyä sademäärät kerrallaan rajoittamattomalta määrältä päiviä, ja iteroida annetut arvot ilman vuorovaikutusta käyttäjän kanssa:

```
Syötä sademäärät millimetreinä yhdelle riville
> 10,0  0,0  0,0  9,5  23,4  7,1  15,9

Yhteensä: 65.9
Päiviä: 7
Maksimi: 23.4
Minimi: 0.0
Keskiarvo: 9.414285714285715
```

Edellä toteutettua ohjelmaa muutettuna siten, että käyttäjän ei tarvitse syöttää tietoja yksi kerrallaan, vaan ohjelma iteroi tunnettuja arvoja, joita voi olla mikä määrä tahansa:

```java
import java.util.Scanner;

public class SademaaratIteroimalla {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Syötä sademäärät millimetreinä yhdelle riville");
        double eka = lukija.nextDouble();

        double summa = eka;
        double minimi = eka;
        double maksimi = eka;
        int paivia = 1;

        // jatketaan syötettujen lukujen lukemista eli iteroidaan,
        // kunnes luvut loppuvat:
        while (lukija.hasNextDouble()) {
            double maara = lukija.nextDouble();

            summa += maara;
            minimi = Math.min(minimi, maara); // Math.max palauttaa annetuista arvoista suuremman
            maksimi = Math.max(maksimi, maara); // Math.min palauttaa annetuista arvoista pienemmän
            paivia++;
        }

        System.out.println(); // tulostaa tyhjän rivin

        System.out.println("Yhteensä: " + summa);
        System.out.println("Päiviä: " + paivia);
        System.out.println("Maksimi: " + maksimi);
        System.out.println("Minimi: " + minimi);
        System.out.println("Keskiarvo: " + summa / paivia);
    }
}
```
`SademaaratIteroimalla.java`


## Extra: kommentit

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

--- 

# Muuttujien roolit

"Think like a programmer" vs. "Think like a computer"
* ratkaistaan ongelmia hyödyntäen tunnettuja malleja (pattern)
* koodataan ihmisiä ajatellen, ei konetta
* koodataan samoja periaatteita noudattaen kuin mitä yleisesti noudatetaan, teknologia- ja projektikohtaisia käytäntöjä hyödyntäen

Mitä muuttujat oikeastaan ovat?
* tietokoneen näkökulmasta muuttuja on vain muuttuja
* ihmisen näkökulmasta eri muuttujilla on kuitenkin erilaisia **rooleja osana erilaisia ratkaisuja**
* tunnettuja rooleja hyödyntäen kehität suoraviivaisia ja ymmärrettäviä **ratkaisuja**

Tässä esimerkissä (alkuluku) käytämme seuraavia muuttujien rooleja:
* kiintoarvo
* askeltaja
* yksisuuntainen lippu

Aikaisemmin olemme hyödyntäneet mm. seuraavia:
* tuoreimman säilyttäjä (`luku`)
* sopivimman säilyttäjä (`max`, `min`)
* kokooja (`summa`)
* kiintoarvo (`lukija`, `desimaalit`)

Muuttujien roolit: http://www.cs.joensuu.fi/~saja/var_roles/stud_vers/stud_Java_fin.html

## Alkuluku-esimerkki yksisuuntaisen lipun avulla

```java
public class Alkuluku {

    public static void main(String[] args) {
        // kiintoarvo, tätä ei muuteta!
        int luku = 93;

        // "yksisuuntainen lippu"
        boolean onAlkuluku = true;

        // askeltaja: 2, 3, 4, 5, 6, ...., luku - 1
        for (int jakaja = 2; jakaja < luku; jakaja++) {
            // jos jako menee tasan, ei ole alkuluku
            if (luku % jakaja == 0) {
                onAlkuluku = false;
            }
        }

        if (onAlkuluku) {
            System.out.println("Luku " + luku + " on alkuluku");
        } else {
            System.out.println("Luku " + luku + " ei ole alkuluku");
        }
    }
}
```


# Merkkijonot

## String-luokka

Kuten olemme aiemmin todenneet, merkkijonot ovat tyyppiä `String`. String on **luokka** ja yksittäiset merkkijonot ovat **olioita**. Merkkijonot luodaan muista olioista poiketen ilman `new`-avainsanaa, kirjoittamalla merkkijonon sisältö suoraan lainausmerkkeihin: `"esimerkki"`.

Koska merkkijonot ovat olioita, niihin liittyy seuraavat seikat:
* **olioiden vertailu ei toimi odotetusti vertailuoperaattorilla** `==`
* merkkijonoilla on **paljon hyödyllisiä metodeja**, joilla niitä voidaan käsitellä

## Olioiden vertailu

Olioita vertailtaessa yhtäsuuruusoperaatio `==` vertailee, onko kyseessä __sama olio__. Se ei siis vertaile olioiden sisältöä, eli tässä tapauksessa merkkijonon merkkejä. **Samansisältöiset merkkijonot ovat siis samoja ainoastaan silloin, kun vertaillaan tiettyä merkkijono-oliota itseensä.**

Merkkijonoja vertaillaan siksi aina `equals`- ja `equalsIgnoreCase` –metodeilla, jotka vertailevat merkkijonojen sisältöjä. Molemmat vertailumetodit palauttavat aina totuusarvon `true` tai `false`.

```java
String language = "JAVA";

if (language.equals("java")) {
     // tätä lohkoa ei suoriteta, koska kirjainkoko ei täsmää
}

if (language.equalsIgnoreCase("java")) {
     // tämä lohko suoritetaan, koska equalsIgnoreCase-metodi ei huomioi kirjainkokoa
}
```


### Merkkijonojen metodien käyttäminen

Merkkijonojen metodeja voidaan kutsua suoraan merkkijonolle:

```java
int pituus = "Hello world".length();            // --> 11
String iso = "Hello world".toUpperCase();       // --> "HELLO WORLD"
String pieni = "Hello world".toLowerCase();     // --> "hello world"
```

Tai vastaavasti muuttujan kautta:

```java
String text = "  Hello world  ";
text = text.trim();	// trim() poistaa tyhjät merkit alusta ja lopusta: "Hello world"
```

### Muuttumattomuus (immutability)

Merkkijonot ovat muuttumattomia, eli kerran luotua merkkijonoa ei voi muuttaa. `String`-luokan metodit eivät koskaan muuta alkuperäistä merkkijonoa, vaan luovat niistä kopioita. Samaan muuttujaan voidaan toki sijoittaa uusia merkkijonoja:

```java
String text = "hello";
text.toUpperCase();
System.out.println(text);  // "hello" (alkuperäinen merkkijono ei muuttunut)

text = text.toUpperCase();
System.out.println(text);  // "HELLO"
```

### Merkkijonon osajono

Merkkijonosta halutaan usein lukea jokin tietty osa. Tämä onnistuu metodilla `substring`. `substring`-metodia voidaan käyttää kahdella tavalla: 
* yksiparametrisena palauttamaan merkkijonon loppuosa: `"abcd".substring(2)`
* kaksiparametrisena palauttamaan parametrien määrittelemä osajono merkkijonosta: `"abcd".substring(1, 3)`

**Merkkijonojen indeksit alkavat aina nollasta!** Substring-metodin ensimmäinen parametri tarkoittaa ensimmäistä indeksiä joka otetaan mukaan osajoukkoon, kun taas toinen parametri on ensimmäinen osajoukon ulkopuolelle jäävä indeksi. Parametriarvoilla `(5, 10)` saadaan siis merkit indekseistä **5, 6, 7, 8 ja 9**.

Koska substring-metodin paluuarvo on tyyppiä `String`, voidaan metodin paluuarvo ottaa talteen `String`-tyyppiseen muuttujaan.

```java
String kirja = "Kalavale";

System.out.println(kirja.substring(4));     // merkkijonon loppu alkaen indeksistä 4
System.out.println(kirja.substring(2, 6));  // palauttaa merkit indekseistä 2, 3, 4 ja 5

String kirja2 = "8 veljestä";

String loppuosa = kirja2.substring(2);
System.out.println("7 " + loppuosa);        // 7 veljestä
```

Tämä esimerkki on lainattu Helsingin yliopiston Agile Education Research -tutkimusryhmän ohjelmointikurssilta ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä.  https://2017-ohjelmointi.github.io/part5/#section-26-merkkijonon-osajono 

# String-luokan metodeja

Tutustu metodeihin tarkemmin täällä: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html

Tyyppi, nimi ja parametrit        | Kuvaus
----------------------------------| ------------
`char charAt(int index)`          | Returns the char value at the specified index.
`public boolean startsWith(String prefix)`  | Tests if this string starts with the specified prefix.
`public boolean endsWith(String suffix)`    | Tests if this string ends with the specified suffix.
`boolean contains(String s)`      | Returns true if and only if this string contains the specified sequence of char values.
`int indexOf(String str)`         | Returns the index within this string of the first occurrence of the specified substring.
`int length()`                    | Returns the length of this string.
`boolean matches(String regex)`   | Tells whether or not this string matches the given regular expression.
`String replace(CharSequence target, CharSequence replacement)` | Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.
`String[] split(String regex)`    | Splits this string around matches of the given regular expression.
`String substring(int beginIndex)`| Returns a string that is a substring of this string.
`String substring(int beginIndex, int endIndex)` | Returns a string that is a substring of this string.
`String toLowerCase()`            | Converts all of the characters in this String to lower case
`String toUpperCase()`            | Converts all of the characters in this String to upper case
`String trim()`                   | Returns a string whose value is this string, with any leading and trailing whitespace removed.

```java
public class MerkkijonojenMetodit {

    public static void main(String[] args) {
        String address = "https://www.example.com/";
        boolean isSecure = address.startsWith("https://");

        System.out.println(isSecure); // true

        String email = "john.smith@example.com";

        int dotIndex = email.indexOf(".");
        int atIndex = email.indexOf("@");

        String firstName = email.substring(0, dotIndex);
        String lastName = email.substring(dotIndex + 1, atIndex);

        System.out.println(firstName); // john
        System.out.println(lastName); // smith

        String simplifiedEmailRegex = "[^@]+@[^\\.]+\\..+"; // https://www.regextester.com/99632
        boolean emailIsValid = email.matches(simplifiedEmailRegex);
        System.out.println(emailIsValid); // true
    }
}
```

# Yleiset erikoismerkit merkkijonoissa

Kaikkia erikoismerkkejä ei voida esittää sellaisenaan merkkijonoissa. Esimerkiksi lainausmerkkiä ja rivinvaihtoa ei voida lisätä sellaisenaan merkkijonoon. Erikoismerkit täytyykin esittää erityisten kontrollimerkkien avulla.

https://docs.oracle.com/javase/tutorial/java/data/characters.html

Syntaksi       | Kuvaus
---------------| ------
\\t            | Insert a tab in the text at this point.
\\n            | Insert a newline in the text at this point.
\\"            | Insert a double quote character in the text at this point.
\\\\           | Insert a backslash character in the text at this point.

```java
System.out.println("Ensimmäinen rivi\nToinen rivi");
System.out.println("Tekstiä \"lainausmerkeissä\".");
```

```
Ensimmäinen rivi
Toinen rivi
Tekstiä "lainausmerkeissä".
```

# Lukujen poimiminen merkkijonoista

Scannerin avulla on kätevää lukea tekstistä erilaisia lukuja. Todellisuudessa kuitenkin suurin osa sovellusten käyttämästä datasta tulee jostain muualta kuin Scannerilta, joten tarvitaan myös muita tapoja lukea numeroita merkkijonoista. Tätä käsitellään tarkemmin oppitunnilla.

```java
int kokonaisluku = Integer.parseInt("123456");
double liukuluku = Double.parseDouble("12.3456");
```

# MerkistÃ◦t (merkistöt)

Eri kielialueilla on perinteisesti ollut tarve hyvin erilaisille kirjainmerkeille. Siksi niissä on kehitetty erilaisia merkistöjä, joissa tietyllä bittijonolla on eri keskenään eri merkitys. Sovellusohjelmat osaavat jonkin verran arvailla avattavien tiedostojen merkistöjä, mutta et voi luottaa tiedoston olevan tallennettu tiettyä merkistöä käyttäen.

Nykypäivänä suositellaan käytettäväksi UTF-8 -nimistä merkistöä, joka sisältää merkittävän osan maailmalla käytetyistä merkeistä, kuten 請 ja ✌️. UTF-8:n suosio on noussut erittäin voimakkaasti ja myös tämä tiedosto on kirjoitettu UTF-8:lla.

![Share of web pages with different character encoding](https://upload.wikimedia.org/wikipedia/commons/c/c4/Utf8webgrowth.svg)

By Chris55 - Own work, CC BY-SA 4.0, https://commons.wikimedia.org/w/index.php?curid=51421096

## Tietoisku: yksittäiset kirjaimet
Javassa on erillinen `char`-tietotyyppi yksittäisiä merkkejä varten. Yksittäinen merkki aloitetaan ja lopetetaan heittomerkillä, esim. `'a'`. Yksittäiset merkit eivät ole olioita, eli niillä ei ole metodeja.

Merkkijonolta voidaan pyytää yksittäisiä merkkejä niiden indeksin perusteella. Tämä onnistuu metodilla `charAt(int indeksi)`, joka saa parametrina halutun merkin indeksin merkkijonossa. **Merkkijonojen indeksien laskeminen alkaa aina nollasta, eli esimerkiksi neljäs merkki on indeksissä kolme.**

```java
char kirjain = 'a';
System.out.println(kirjain);

String kirja = "Kalavale";

char merkki = kirja.charAt(3);
System.out.println("Neljäs merkki: " + merkki);
System.out.println("Eka merkki: " + kirja.charAt(0));
```

Tämä esimerkki on lainattu Helsingin yliopiston Agile Education Research -tutkimusryhmän ohjelmointikurssilta ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä. https://2017-ohjelmointi.github.io/part5/#section-25-yksittainen-merkki-merkkijonosta 

```
a
Neljäs merkki: a
Eka merkki: K
```

## Edistynyttä sisältöä: säännölliset lausekkeet, regular expressions / regex

> "Säännöllinen lauseke määrittelee joukon merkkijonoja tiiviissä muodossa. Säännöllisiä lausekkeita käytetään muunmuassa merkkijonojen oikeellisuuden tarkistamiseen. Merkkijonojen oikeellisuuden tarkastaminen tapahtuu luomalla säännöllinen lauseke, joka määrittelee merkkijonot, jotka ovat oikein."
>
> "Oikeellisuuden tarkistus säännöllisten lausekkeiden avulla tapahtuu ensin sopivan säännöllisen lausekkeen määrittelyn. Tämän jälkeen käytetään `String`-luokan metodia `matches`, joka tarkistaa vastaako merkkijono parametrina annettua säännöllistä lauseketta. Opiskelijanumeron tapauksessa sopiva säännöllinen lauseke on `01[0-9]{7}`"

*Lähde: Helsingin yliopiston Agile Education Research -tutkimusryhmän ohjelmointikurssi (Creative Commons BY-NC-SA)  https://materiaalit.github.io/ohjelmointi-s17/part10/#section-19-saannolliset-lausekkeet*

#### `"teksti".matches(String regex); // edistynyttä sisältöä`

`matches`-metodi vertaa merkkijonoa annettuun säännölliseen lausekkeeseen ja palauttaa `true` tai `false` riippuen siitä, vastaako merkkijono lauseketta. Säännölliset lausekkeet (regular expression) ovat merkkijonoja, jotka muodostavat "kuvion" (pattern), jota vasten merkkijonoja verrataan.

Valikoituja esimerkkejä selityksineen:

Regex                   | Esimerkki   | Selitys
------------------------| ------------| --------
[0-9]+                  | 1234567890  | 1-n kpl numeroita
[0-9]{7}                | 1234567     | 7 kpl numeroita
[a-zåäö -]{4,10}        | abc-d       | Pieniä kirjaimia a-z, å, ä, ö, väli tai viiva. Yhteensä 4-10 kpl.
[A-Z]{1,3}-[0-9]{1,3}   | ABC-123     | 1-3 isoa kirjainta, viiva ja 1-3 numeroa 

#### Opiskelijanumeron tarkastaminen
Haaga-Helian opiskelijanumeron tapauksessa sopiva säännöllinen lauseke on `"a[0-9]{7}"` (a-kirjain ja 7 numeroa). Käyttäjän syöttämän opiskelijanumeron tarkistaminen käy seuraavasti:

```java
/* Tämä esimerkki on sovellettu Helsingin yliopiston Agile Education Research -tutkimusryhmän
 * ohjelmointikurssilta ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä. 
 * https://materiaalit.github.io/ohjelmointi-s17/part10/#section-19-saannolliset-lausekkeet */

Scanner lukija = new Scanner(System.in);

System.out.print("Anna opiskelijanumero: ");
String numero = lukija.nextLine();

if (numero.matches("a[0-9]{7}")) {
    System.out.println("Muoto on oikea.");
} else {
    System.out.println("Muoto on väärä.");
}
```

#### Regex-sääntöjä

Tutustu regex-sääntöihin osoitteessa: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html

Huom! Kuten [ylempänä on esitetty](#yleiset-erikoismerkit-merkkijonoissa), merkkijonoissa kenoviiva `\` on erikoismerkki, jota ei voida käyttää sellaisenaan. Kenoviiva tulee esittää aina kahtena kenoviivana `\\`. Regex-säännön `\d` eteen tulee siis Javassa laittaa "ylimääräinen" kenoviiva: 

```java
boolean match = "1234".matches("\\d+");
```

---

[![Perl Problems](https://imgs.xkcd.com/comics/perl_problems.png)](https://xkcd.com/1171/)

https://xkcd.com/1171/ This work is licensed under a Creative Commons Attribution-NonCommercial 2.5 License


--- 

# Listat

Listat ovat tietorakenteita, joiden pituus kasvaa joustavasti, kun niihin lisätään uusia arvoja. Listoihin voidaan lisätä arvoja myös aiempien arvojen väliin ja listan väleistä voidaan poistaa arvoja. Listat ovat olioita ja niillä on metodeita, joiden avulla arvoja lisätään, poistetaan, etsitään jne.

Yhdessä listassa voidaan varastoida ainoastaan yhdentyyppisiä arvoja, eikä varastoitavaa tyyppiä voida myöhemmin vaihtaa. Listoissa voidaan varastoida ainoastaan olioita, ei siis alkeistietotyyppejä kuten `boolean`, `int` ja `double`. Alkeistietotyypit voidaan kuitenkin esittää myös olioina kääreluokkien `Boolean`, `Integer` ja `Double` avulla.


## Listatyypit

Javassa on useita eri listatyyppejä. Kaikki listat toimivat ulkoisesti samalla tavalla, vaikka niiden sisäiset toteutustavat vaihtelevat merkittävästi. `ArrayList` on sisäisesti toteutettu taulukon avulla, kun taas `LinkedList` on toteutettu linkittämällä listan alkiot toisiinsa "ketjuksi". Sopivin lista kuhunkin tarkoitukseen vaihtelee listan käyttötavasta riippuen, mutta pääsääntöisesti pärjäät hyvin käyttämällä aina `ArrayList`-listoja.

Voit luoda itsellesi merkkijonotyyppisiä listoja seuraavasti:

```java
ArrayList<String> taulukkoLista = new ArrayList<String>();
LinkedList<String> linkitettyLista = new LinkedList<String>();
```

Listat sijaitsevat `java.util`-paketissa, joten ne otetaan käyttöön esim. seuraavilla `import`-käskyillä:

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
```

### Geneeriset tyypit

Listat ovat geneerisiä, eli niiden sisällön tyyppi voidaan määritellä itse. Edellä määritellyt listat säilyttävät merkkijonoja ja tämä `ArrayList` voi säilyttää kokonaislukuja:

```java
// kulmasuluissa oleva tyypin nimi kertoo, mitä arvoja listalla säilytetään:
ArrayList<Integer> numerot2 = new ArrayList<Integer>();
```

Java osaa päätellä luotavan listan tyypin muuttujan tyypistä, joten voimme määritellä listan luonnissa tyypin tyhjäksi `<>`. Java päättelee tyypiksi `<String>`:

```java
// jälkimmäiset kulmasulut voidaan jättää tyhjiksi:
ArrayList<String> merkkijonot = new ArrayList<>();
```

### Listojen ja listamuuttujien yhteensopivuus

Kaikki listatyypit ovat yhteensopivia `List`-tyypin kanssa, joten **muuttujan tyypiksi voidaan määritellä yleisesti `List`**:

```java
// List<String> -muuttujaan voidaan sijoittaa esim. LinkedList- ja ArrayList-listoja:
List<String> merkkijonoLista = new ArrayList<>();
```

Muista, että tarvitset sekä `List`-tyypille että ArrayList-tyypille import-komennot luokan alkuun:

```java
import java.util.ArrayList;
import java.util.List;
```

Jos muuttujan tyypiksi määriteltäisiin tarkasti `ArrayList<String>`, voisimme asettaa muuttujaan **ainoastaan** `ArrayList`-tyyppisen listan. Tällöin emme voisi käyttää esim. `List.of`-luontitapaa valmiin listan luomiseksi:

```java
// VIRHE: Type mismatch: cannot convert from List<String> to ArrayList<String>
ArrayList<String> lista = List.of("sana", "toinen"); 
```
```java
// Toimii, koska List<String> on yhteensopiva kaikkien merkkijonolistojen kanssa:
List<String> lista = List.of("sana", "toinen"); 
```

## Esimerkki kokonaisuudessaan:

```java
package viikko3.listat.th;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Listaluokat {

    public static void main(String[] args) {
        // Javassa on useita eri listatyyppejä:
        ArrayList<String> taulukkoLista = new ArrayList<String>();
        LinkedList<String> linkitettyLista = new LinkedList<String>();

        // Listat ovat geneerisiä, eli niiden sisällön tyyppi voidaan määritellä itse.
        // Edellä määritellyt listat säilyttävät merkkijonoja ja tämä ArrayList voi
        // säilyttää kokonaislukuja:
        ArrayList<Integer> numerot2 = new ArrayList<Integer>();

        // Java osaa päätellä luotavan listan tyypin muuttujan tyypistä, joten
        // voimme määritellä listan luonnissa tyypin tyhjäksi '<>' -> '<String>'
        ArrayList<String> merkkijonot = new ArrayList<>();

        // Kaikki listatyypit ovat yhteensopivia "List"-tyypin kanssa, joten muuttujan
        // tyypiksi voidaan määritellä yleisesti List:
        List<String> yleinenMerkkijonoLista = new ArrayList<>();

        // Tällä kurssilla tulemme käyttämään lähinnä ArrayList-listoja!
    }
}
```

## Listaoperaatiot

Listoja käytetään aina kutsumalla listan metodeja:

### Listalle lisääminen

`add`-metodi lisää listalle uusia arvoja listan loppuun:

```java
List<String> sanat = new ArrayList<>();

sanat.add("Hello");
sanat.add("World");

System.out.println(sanat); // [Hello, World]
```

### Lisääminen tiettyyn indeksiin

Listalle voidaan lisätä myös arvoja tiettyyn indeksiin. Tällöin `add`-metodille annetaan ensimmäiseksi parametriarvoksi haluttu indeksi. Seuraavien listalla olevien arvojen indeksit kasvavat yhdellä:

```java
List<String> sanat = new ArrayList<>();

// lisätään arvoja listan loppuun:
sanat.add("Hello");
sanat.add("World");

// lisätään arvoja tiettyyn indeksiin:
sanat.add(0, "Terve");
sanat.add(1, "Maailma");

System.out.println(sanat); // [Terve, Maailma, Hello, World]
```

### Listalla olevien arvojen lukumäärä

```java
List<String> sanat = new ArrayList<>();

sanat.add("Hello");
sanat.add("World");

System.out.println(sanat.size()); // 2
```

### Listalta hakeminen

Listalta voidaan hakea yksittäisiä arvoja `get`-metodin avulla. **Huomaa, että listojen indeksit alkavat aina nollasta!**

```java
List<String> sanat = new ArrayList<>();

sanat.add("Hello");
sanat.add("World");

System.out.println(sanat.get(0)); // Hello
System.out.println(sanat.get(1)); // World
```

### Listalta poistaminen

Listalta voidaan poistaa joko tietyn indeksin perusteella tai tiettyjä arvoja `remove`-metodin avulla. **Huomaa, että listojen indeksit alkavat aina nollasta!**


```java
List<String> sanat = new ArrayList<>();

sanat.add("Hello");
sanat.add("World");
sanat.add("!");

// poistetaan indeksin perusteella:
sanat.remove(0);

// poistetaan tietty arvo:
sanat.remove("World");

System.out.println(sanat); // [!]
```

### Contains ja indexOf

Listoilta voidaan etsiä alkioita kahdella metodilla:

* `contains` palauttaa `true`, jos annettu arvo löytyy jostain kohtaa listalta
* `indexOf` palauttaa sen indeksin, josta annettu arvo löytyy
* Huom! Listojen indeksit alkavat aina nollasta
* Huom! Jos annettua arvoa ei löydy, `indexOf` palauttaa luvun `-1`

```java
ArrayList<String> nimet = new ArrayList<>();

nimet.add("Matti");
nimet.add("Maija");

System.out.println(nimet.contains("Matti"));
System.out.println(nimet.indexOf("Maija"));
System.out.println(nimet.indexOf("Maikki"));
```

Tulostaa:

```
true
1
-1
```


### Listan arvojen iterointi (indeksillä)

* Listan sisältö on usein tarpeellista käydä läpi alusta loppuun
* Tämä voidaan toteuttaa toistorakenteella, jossa lähdetään liikkeelle nollasta ja edetään viimeiseen indeksiin `sanat.size() – 1`
* Toistorakenteen sisällä saadaan kulloinkin käsiteltävä arvo pyydettyä listalta käyttäen toistomuuttujaa: `get(i)`


```java
import java.util.ArrayList;
import java.util.List;

public class ListanLapikayntiFor {

    public static void main(String[] args) {
        List<Integer> numerot = new ArrayList<>();
        numerot.add(321);
        numerot.add(456);
        numerot.add(789);

        // käydään kaikki listan arvot läpi:
        for (int i = 0; i < numerot.size(); i++) {
            System.out.println(numerot.get(i));
        }
    }
}
```

### Listan iterointi (for-each)

Katso: https://stackoverflow.com/a/22114571

For-each –silmukalla on mahdollista käydä kätevästi kaikki tietyn listan arvot läpi ilman, että pidämme itse kirjaa indeksistä ja haemme arvoja `get`-metodilla:

```java
import java.util.ArrayList;
import java.util.List;

public class ListanLapikayntiForEach {

    public static void main(String[] args) {
        List<Integer> numerot = new ArrayList<>();
        numerot.add(321);
        numerot.add(456);
        numerot.add(789);

        // käydään kaikki listan arvot läpi:
        for (Integer arvo : numerot) {
            System.out.println(arvo);
        }
    }
}
```

### Listan järjestäminen

Lista on mahdollista järjestää helposti alkioiden "luonnolliseen järjestykseen". `Collections`-apuluokalla on olemassa `sort`-niminen metodi, joka järjestää sille annetun listan:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KaupunkienSorttaus {

    public static void main(String[] args) {
        List<String> kaupungit = new ArrayList<>();
        kaupungit.add("Rauma");
        kaupungit.add("Helsinki");
        kaupungit.add("Espoo");
        kaupungit.add("Vantaa");
        kaupungit.add("Turku");

        // Tulostaa siinä järjestyksessä, kun lisäsimme arvot:
        System.out.println(kaupungit); // [Rauma, Helsinki, Espoo, Vantaa, Turku]

        Collections.sort(kaupungit); // järjestää "luonnolliseen" järjestykseen

        // Lista on nyt eri järjestyksessä:
        System.out.println(kaupungit); // [Espoo, Helsinki, Rauma, Turku, Vantaa]
    }
}
```

**Merkkijonojen luonnollinen järjestys ei toimi odotetusti eri kokoisia kirjaimia vertaillessa.**

### Listan kopioiminen

```java
List<String> lista = new ArrayList<String>();
lista.add("Terve");
lista.add("Maailma");

// Tapa 1: annetaan kopioitava lista parametrina luotaessa uutta ArrayList:iä
List<String> kopio1 = new ArrayList<>(lista);

// Tapa 2: lisätään kaikki alkiot tyhjään listaan kutsumalla addAll-metodia
List<String> kopio2 = new ArrayList<>();
kopio2.addAll(lista);
```

---


# Taulukot

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

**Tämä muunneltu tiivistelmä metodien käyttämisestä ja määrittelemisestä perustuu Helsingin yliopiston Agile Education Research -tutkimusryhmän [MOOC-ohjelmointikurssin materiaaliin](https://materiaalit.github.io/ohjelmointi-18/part2/). Lisenssi: Creative Commons BY-NC-SA.**

# Metodit

## Main-metodi

Olemme kurssilla tähän asti määritellyt lukuisia kertoja main-metodin:

```java
public static void main(String[] args) {
    
}
```

Metodin otsikko koostuu seuraavista avainsanoista:

* `public` – julkinen metodi, jota voidaan kutsua mistä vain
* `static` – staattinen eli luokkametodi, joka ei kuulu millekään yksittäiselle oliolle
* `void` – metodi ei palauta mitään arvoa
* `main` – metodin nimi, main-nimisellä metodilla on erityinen rooli ohjelman käynnistyksessä
* `String[] args` – yksi parametrimuuttuja: merkkijonotaulukko, jonka nimi on args

Metodin otsikon jälkeen kirjoitetaan aina aaltosulut `{   }`, joiden sisään kirjoitetaan metodin runko.

Muistiinpanojen seuraavat osat käsittelevät näiden merkitystä sekä sitä, mitä muita mahdollisia arvoja voimme käyttää näiden lisäksi.


## Mikä on metodi?

Teknisesti ottaen metodi tarkoittaa nimettyä lauseista koostuvaa joukkoa, jota voi kutsua muualta ohjelmakoodista nimen perusteella. Yksi hyvin yleinen käyttämämme metodi on `println`:

```java
System.out.println("Hello world");
```

`println`-metodin toteutus pitää sisällään koodirivit, jotka tarvitaan sille annetun arvon tulostamiseksi. Metodin sisäinen toteutus -- eli joukko suoritettavia lauseita -- on tässä tapauksessa Java-ohjelmointikielen piilottama.


## Metodikutsun vaikutus ohjelman suoritukseen

Metodin suorituksen jälkeen palataan takaisin kohtaan, missä ennen metodikutsua oltiin menossa, ja ohjelman suoritus jatkuu tästä. 

Olemme tottuneet näkemään metodikutsun yhteydessä aina pisteen, esim. `lukija.nextLine()`. Tässä metodin nimi onkin pisteen oikeanpuoleinen osa, eli `nextLine()`. Pisteen vasemmanpuoleinen osa, eli tässä `lukija` kertoo kenen metodista on kyse.

Metodikutsun lopussa on aina sulut. Metodista riippuen sulkujen sisälle laitetaan arvoja tai sulut jätetään tyhjäksi.


## Metodin palauttamat paluuarvot

Olemme nähneet kurssin aikana sekä metodeja, jotka eivät palauta lainkaan arvoja että metodeja, jotka tuottavat tuloksenaan jonkin arvon:

```java
// parseInt palauttaa int-tyyppisen arvon:
int luku = Integer.parseInt("1234");

// println ei palauta arvoa, joten se on void-tyyppinen:
System.out.println("Tämä metodi ei palauta arvoa");
```

Metodin koodista voidaan siis välittää arvoja takaisin metodia kutsuneelle koodille. Tämä tehdään `return`-avainsanalla, johon palaamme myöhemmin.


## Metodille annettavat parametriarvot

Metodit tarvitsevat usein metodia kutsuvalta koodilta arvoja, joiden perusteella ne suorittavat toimintansa. Esimerkiksi `println` tarvitsee tulostettavan datan ja `parseInt` tarvitsee merkkijonon, jonka se tulkitsee numeroksi. Metodille välitettäviä arvoja kutsutaan **parametriarvoiksi**, ja ne kirjoitetaan metodikutsussa metodin nimen jälkeen tuleviin sulkuihin:

```java
// metodille välitetään merkkijono:
System.out.println("Tämä merkkijono välitetään parametrina");

// metodille välitetään kokonaislukuja:
int maksimi = Math.max(10, 20);

// metodille välitetään lista:
Collections.sort(omaLista);
```

Toiset metodit eivät tarvitse lainkaan parametriarvoja, jolloin metodikutsussa sulut jätetään tyhjiksi:

```java
Scanner lukija = new Scanner(System.in);

// monet metodit eivät tarvitse lainkaan parametriarvoja:
int i = lukija.nextInt();
String s = lukija.nextLine();
```

# Omien metodien määrittely

Javan valmiiden metodien käytön lisäksi ohjelmoija voi kirjoittaa itse metodeja joita sovellus kutsuu. 

Kuten käytännössä kaikki koodi, myös metodit kirjoitetaan luokan sisään eli luokan määrittelyssä esiteltyjen aaltosulkujen väliin. Metodeja ei voida määritellä sisäkkäin, eli kaikki metodit ovat luokan sisällä samalla tasolla peräkkäin. Metodien järjestyksellä ei ole Javan kannalta merkitystä.

```java
public class Esimerkki {

    public static void main(String[] args) {
        sayHello();
        sayGoodbye();
    }

    public static void sayHello() {
        System.out.println("Hello!");
    }

    public static void sayGoodbye() {
        System.out.println("Goodbye!");
    }
}
```

## Ensimmäinen oma metodi

Seuraavassa esimerkissä otsikoiden tulostaminen "## Otsikko ##"-syntaksilla on siirretty omaan metodiinsa, jotta samaa koodia ei tarvitse toistaa moneen kertaan ja jotta mahdolliset muutokset otsikon tyyliin voidaan tehdä vain yhteen kohtaan ohjelmassa:

```java
public class KoodinPilkkominenOsiinVoidMetodeilla {

    public static void main(String[] args) {
        // Määritellään metodi, joka tulostaa tekstin ja laittaa ympärille "##"-merkit
        tulostaOtsikko("Tammikuun sademäärät");
        tulostaTilasto(10, 15, 6);

        System.out.println();

        // metodikutussa voi olla ihan eri nimiset muuttujat kuin metodin otsikossa
        String helmikuunOtsikko = "Helmikuun sademäärät";
        tulostaOtsikko(helmikuunOtsikko);
        tulostaTilasto(11, 18, 9);
    }

    private static void tulostaOtsikko(String otsikko) {
        // Tässä metodissa ei ole edes pääsyä main-metodin muuttujiin!
        System.out.println("## " + otsikko + " ##");
    }

    // Tälle metodille annetaan aina KOLME parametriarvoa
    private static void tulostaTilasto(int keskiarvo, int suurin, int pienin) {
        System.out.println("Keskiarvo: " + keskiarvo);
        System.out.println("Suurin: " + suurin);
        System.out.println("Pienin: " + pienin);
    }
}
```
[Tutustu koodin suoritukseen Visualizerissa](https://cscircles.cemc.uwaterloo.ca/java_visualize/#code=public+class+KoodinPilkkominenOsiinVoidMetodeilla+%7B%0A%0A++++public+static+void+main(String%5B%5D+args)+%7B%0A++++++++//+M%C3%A4%C3%A4ritell%C3%A4%C3%A4n+metodi,+joka+tulostaa+tekstin+ja+laittaa+ymp%C3%A4rille+%22%23%23%22-merkit%0A++++++++tulostaOtsikko(%22Tammikuun+sadem%C3%A4%C3%A4r%C3%A4t%22)%3B%0A++++++++tulostaTilasto(10,+15,+6)%3B%0A%0A++++++++System.out.println()%3B%0A%0A++++++++//+metodikutussa+voi+olla+ihan+eri+nimiset+muuttujat+kuin+metodin+otsikossa%0A++++++++String+helmikuunOtsikko+%3D+%22Helmikuun+sadem%C3%A4%C3%A4r%C3%A4t%22%3B%0A++++++++tulostaOtsikko(helmikuunOtsikko)%3B%0A++++++++tulostaTilasto(11,+18,+9)%3B%0A++++%7D%0A%0A++++private+static+void+tulostaOtsikko(String+otsikko)+%7B%0A++++++++//+T%C3%A4ss%C3%A4+metodissa+ei+ole+edes+p%C3%A4%C3%A4sy%C3%A4+main-metodin+muuttujiin!%0A++++++++System.out.println(%22%23%23+%22+%2B+otsikko+%2B+%22+%23%23%22)%3B%0A++++%7D%0A%0A++++//+T%C3%A4lle+metodille+annetaan+aina+KOLME+parametriarvoa%0A++++private+static+void+tulostaTilasto(int+keskiarvo,+int+suurin,+int+pienin)+%7B%0A++++++++System.out.println(%22Keskiarvo%3A+%22+%2B+keskiarvo)%3B%0A++++++++System.out.println(%22Suurin%3A+%22+%2B+suurin)%3B%0A++++++++System.out.println(%22Pienin%3A+%22+%2B+pienin)%3B%0A++++%7D%0A%7D&mode=display&curInstr=0)

## Metodien rakenne

Metodimäärittelyn ensimmäisellä rivillä on metodin nimi. Nimen vasemmalla puolella tässä vaiheessa määreet `public static void`:

```java
public static void sayHello() {
    System.out.println("Hello!");
}
```

Metodin nimen sisältävän rivin alla on aaltosulkeilla `{  }` erotettu koodilohko, jonka sisälle kirjoitetaan metodin koodi, eli ne komennot, jotka metodia kutsuttaessa suoritetaan.

## Metodien kutsuminen

Itsekirjoitetun metodin kutsu on helppoa, kirjoitetaan metodin nimi ja perään sulut ja puolipiste.

Seuraavassa main-metodi eli pääohjelma kutsuu tervehdi-metodia yhteensä neljä kertaa.

```java
public static void main(String[] args) {
    System.out.println("Kokeillaan metodia:");
    tervehdi();

    System.out.println("Toimii! Kokeillaan vielä:");
    tervehdi();
    tervehdi();
    tervehdi();
}

public static void tervehdi() {
    System.out.println("Terveiset metodista!");
}
```

```
Kokeillaan metodia:
Terveiset metodista!
Toimii! Kokeillaan vielä:
Terveiset metodista!
Terveiset metodista!
Terveiset metodista!
```

Katso tämä esimerkki Java Visualizerissa: https://goo.gl/9E1E12 

## Metodien nimeäminen ja sisennykset

Metodit nimetään siten, että ensimmäinen sana kirjoitetaan pienellä ja loput alkavat isolla alkukirjaimella. Tällaisesta kirjoitustavasta käytetään nimitystä **camelCase**. Tämän lisäksi, metodin sisällä koodi on sisennetty taas neljä merkkiä.

Käytännöt metodien nimeämiselle ja sisentämiselle vaihtelevat eri ohjelmointikielten välillä.

```java
// OK:
public static void tamaMetodiSanooMur() { 
    System.out.println("mur"); 
}

// ei ok:
public static void Tama_metodi_sanoo_mur ( ) { 
System.out.println("mur"); 
}
```

## Parametriarvot ja paluuarvot

Metodille suluissa annettua syötettä kutsutaan metodin parametriksi -- metodin parametreilla annetaan metodeille tarkempaa tietoa odotetusta suorituksesta. Esimerkiksi tulostuslauseelle kerrotaan parametrin avulla mitä pitäisi tulostaa.

```java
// Ensin kutsutaan scannerin metodia lukija.nextLine.
// Metodi palauttaa paluuarvonaan käyttäjän syöttämän merkkijonon, joka asetetaan talteen muuttujaan. 
String syote = lukija.nextLine();

// Seuraavaksi kutsutaan metodia Integer.parseInt. Metodikutsun parametrina annetaan
// merkkijono, jonka edellisen metodin kutsu palautti. parseInt-metodin paluuarvo
// puolestaan on annettua merkkijonoa vastaava kokonaisluku. 
// Lopuksi parseInt-metodin palauttama arvo asetetaan talteen uuteen muuttujaan.
int luku = Integer.parseInt(syote);
```

Paluuarvoa voidaan heti käyttää myös parametrina:

```java
// Ensin kutsutaan sisempänä olevaa metodia lukija.nextLine.
// Metodi palauttaa paluuarvonaan käyttäjän syöttämän merkkijonon. 
// Seuraavaksi kutsutaan metodia Integer.parseInt. 
// Metodikutsun parametrina välitetään merkkijono, jonka nextLine-metodin kutsu palautti. 
Metodin paluuarvona on merkkijonoa vastaava kokonaisluku, joka asetetaan talteen uuteen muuttujaan.
int luku = Integer.parseInt(lukija.nextLine());
```

## Parametrimuuttujat ja parametriarvot omissa metodeissa

**Parametrit** ovat siis **metodille annettavia arvoja**, joita käytetään metodin suorituksessa. Metodin **parametrimuuttujat** määritellään metodin ylimmällä rivillä metodin nimen jälkeen olevien sulkujen sisällä.

Kun metodia kutsutaan, sen **parametrimuuttujiin** asetetaan annetut arvot. Metodin sisällä annettu **arvo on käytettävissä parametrimuuttujan kautta**.

```java
public class AgenttiTervehdys {

    public static void main(String[] args) {
        // metodikutsussa on annettava arvot, jotka vastaavat metodiin määriteltyjä parametreja
        tervehdi("James", "Bond");
        tervehdi("Gracie", "Hart");
    }

    // 'etu' ja 'suku' ovat String-muuttujia, joita kutsutaan parametrimuuttujiksi
    public static void tervehdi(String etu, String suku) {
        System.out.println("Nimeni on " + suku +             ", " + etu + " " + suku);
    }
}
```
Katso tämä esimerkki Java Visualizerissa: https://goo.gl/cahGq1

## Metodin paluuarvot ja return-käsky

Jos metodi palauttaa arvon, tulee metodin määrittelyn yhteydessä kertoa palautettavan arvon tyyppi. Muulloin määrittelyssä käytetään avainsanaa `void`. `void` metodit eivät koskaan voi palauttaa arvoja.

Konkreettinen arvon palautus tapahtuu komennolla `return`, jota seuraa palautettava arvo (tai muuttujan tai lauseke, jonka arvo palautetaan).

Jos metodille määritellään paluuarvon tyyppi, on sen **pakko** palauttaa arvo.

```java
public static void main(String[] args) {
    // metodin suorituksen jälkeen sen palauttama arvo voidaan ottaa talteen:
    int luku = palautetaanAinaKymppi();

    System.out.println("metodi palautti: " + luku);
}

public static int palautetaanAinaKymppi() {
    // return-käsky palauttaa sen jälkeen olevan arvon:
    return 10;
}
```

## Monta parametriarvoa ja muuttujat metodin sisällä

Metodille voidaan määritellä useita parametreja. Tällöin metodin kutsussa parametrit annetaan samassa järjestyksessä. Muuttujien määrittely muissa metodeissa tapahtuu aivan kuten main-metodissa. 

Seuraava metodi laskee parametrina saamiensa lukujen keskiarvon. Keskiarvon laskemisessa käytetään apumuuttujia `summa` ja `ka`. Nämä **paikalliset muuttujat**, aivan kuten parametrimuuttujat `luku1`, `luku2` ja `luku3`, ovat voimassa ainoastaan metodin sisällä.

```java
public static double keskiarvo(int luku1, int luku2, int luku3) {

    int summa = luku1 + luku2 + luku3;
    double ka = summa / 3.0;

    return ka;
}
```

**Huomaa että metodin sisäiset muuttujat summa ja ka eivät näy metodin ulkopuolelle. Sama koskee myös parametrimuttujia luku1, luku2 ja luku3.**

Sama metodi voidaan kirjoittaa myös lyhyemmin:

```java
public static double keskiarvo(int luku1, int luku2, int luku3) {
    // lausekkeen arvo lasketaan ensin ja tulos palautetaan metodista:
    return (luku1 + luku2 + luku3) / 3.0;
}
```

## Muuttujien näkyvyys ja nimeäminen

Metodin parametrimuuttujien nimillä ei ole vaikutusta metodin ulkopuolelle. Metodikutsuissa voidaan käyttää aivan eri nimisiä muuttujia, esim:
```java
// metodikutsussa on muuttujat a, b ja c
double kesk = keskiarvo(a, b, c);
```

```java
// annetut arvot ovat metodin sisällä käytössä nimillä luku1, luku2 ja luku3:
public static double keskiarvo(int luku1, int luku2, int luku3) {

    int summa = luku1 + luku2 + luku3;
    double ka = summa / 3.0;

    return ka;
}
```

## Muissa luokissa määriteltyjen metodien kutsuminen

Samassa luokassa olevan metodin kutsuminen oli helppoa: kirjoitetaan vain metodin nimi, sulut ja tarvittaessa parametriarvot.

Toisessa luokassa olevaa metodia kutsutaan **joko luokan tai olion kautta** riippuen siitä, onko kyseessä ns. luokka- vai oliometodi:

```java
String teksti = "Merkkijonot ovat olioita";

// toLowerCase on oliokohtainen, eli sitä kutsutaan esimerkiksi muuttujan kautta:
String pienella = teksti.toLowerCase();

// Math-luokan min-metodi ei kuulu oliolle, eli sitä kutsutaan suoraan luokan nimellä:
int pienin = Math.min(12, 15);
```

### Esimerkki luokkien välisistä metodikutsuista

Ohjelman suoritus käynnistyy `Nimirekisteri`-luokan `main`-metodissa, josta kutsutaan `NimenLyhentaja`-luokan `lyhenna`-metodia:

```java
/*
 * Harjoitellaan toisessa luokassa olevan metodin kutsumista!
 */
public class Nimirekisteri {

    public static void main(String[] args) {
        String keke = NimenLyhentaja.lyhenna("Keijo", "Rosberg");
        System.out.println(keke);

        String kimi = NimenLyhentaja.lyhenna("Kimi", "Räikkönen");
        System.out.println(kimi);

        // paluuarvoa voidaan käyttää myös suoraan seuraavan metodikutsun
        // parametriarvona:
        System.out.println(NimenLyhentaja.lyhenna("Mika", "Häkkinen"));
    }
}
```

```java
public class NimenLyhentaja {

    public static String lyhenna(String etunimi, String sukunimi) {

        // Muuntaa "Keijo" ja "Rosberg" -> "K. Rosberg"
        String lyhennetty = etunimi.substring(0, 1) + ". " + sukunimi;

        return lyhennetty;
    }

}
```

## Metodien näkyvyys, eli mistä metodia voidaan kutsua

Näkyvyys        | Selitys
----------------|-------------
public          | Metodi on käytettävissä kaikkialta
private         | Metodi on käytettävissä ainoastaan saman luokan sisältä
protected       | Metodi on käytettävissä saman luokan ja paketin sisältä, sekä aliluokista
&nbsp;          | (ei määritetty) **Hyvin harvoin käytetty.** Käytettävissä saman luokan ja paketin sisältä. 

```java
public String julkinen() {
    return "käytettävissä missä tahansa";
}

private String yksityinen() {
    return "käytettävissä vain tästä luokasta";
}

protected String suojattu() {
    return "käytettävissä mm. aliluokista";
}
```

## Vilkaisu olio-ohjelmointiin: luokkametodit ja oliometodit

Metodit määritellään aina joko luokkametodeiksi tai oliometodeiksi. **Staattiset eli luokkametodit** ovat käytettävissä sen luokan kautta, johon ne on määritetty.

**Oliometodit ovat käytettävissä olioiden kautta**, eikä niitä voida kutsua ilman olioita.

Toistaiseksi määrittelemme kaikki metodit staattisiksi, vaikka olemmekin hyödyntäneet useita oliometodeja mm. String ja Scanner –luokista.

**Esimerkki.java**

```java
public class Esimerkki {

    public static void staattinenMetodi() {
        System.out.println("staattinen eli luokkametodi");
    }

    // metodin otsikosta puuttuu 'static'
    public void olioMetodi() {
        System.out.println("oliokohtainen metodi");
    }
}
```

**Ohjelma.java**
```java
public class Ohjelma {
    public static void main(String[] args) {
        // Luokkametodia kutsutaan luokan kautta:
        Esimerkki.staattinenMetodi();

        // Oliometodin kutsua varten tarvitaan olio:
        Esimerkki olio = new Esimerkki();
        olio.olioMetodi();
    }
}
```

## Arvojen muuttaminen metodissa

Ns. perustietotyyppien arvot (int, double) kopioituvat metodikutsussa, eikä niiden käsittely metodissa vaikuta koskaan sinne, mistä metodikutsu tehtiin.

**Oliot puolestaan välittyvät viittauksina**, eli niiden muutokset näkyvät myös arvoa muuttavan metodin ulkopuolelle.

```java
public static void tulostaJarjestyksessa(List<Integer> numerot) {
    // Listan järjestäminen metodin sisällä muuttaa 
    // järjestyksen myös siellä, mistä tätä metodia 
    // kutsuttiin, koska listaa ei kopioida metodikutsussa
    Collections.sort(numerot);
    System.out.println(numerot);
}
```

Esimerkki: listan muuttuminen metodissa

```java
public static void main(String[] args) {
    List<Integer> lukuja = Arrays.asList(3, 1, 2);

    // minimi-metodi muuttaa tätä lukuja-listaa ja muutos näkyy myös tässä metodissa
    int minimi = pienin(lukuja);

    System.out.println(lukuja); // [1, 2, 3]
}

public static int pienin(List<Integer> arvot) {
    // collections.sort muuttaa sille annetun listan järjestystä:
    Collections.sort(arvot);

    return arvot.get(0);
}
```

Tutustu interaktiiviseen esimerkkiin arvojen muuttumisesta ja muuttumattomuudesta [Java Visualizer-palvelussa](https://cscircles.cemc.uwaterloo.ca/java_visualize/#code=public+class+PassByValue+%7B%0A+++%0A+++static+void+reset(int+x)+%7B%0A++++++x+%3D+0%3B%0A+++%7D%0A+++%0A+++static+void+reset(int%5B%5D+x)+%7B%0A++++++for+(int+i+%3A+x)+%0A+++++++++i+%3D+0%3B%0A+++%7D%0A+++%0A+++static+void+reallyReset(int%5B%5D+x)+%7B%0A++++++for+(int+i%3D0%3B+i%3Cx.length%3B+i%2B%2B)%0A+++++++++x%5Bi%5D+%3D+0%3B%0A+++%7D%0A+++%0A+++public+static+void+main(String%5B%5D+args)+%7B%0A++++++int+a+%3D+3%3B%0A++++++int%5B%5D+arr+%3D+%7B5,+10,+15%7D%3B%0A++++++%0A++++++reset(a)%3B+//+this+won't+work%0A++++++System.out.println(a)%3B%0A++++++%0A++++++reset(arr)%3B+//+this+won't+work%0A++++++System.out.println(java.util.Arrays.toString(arr))%3B%0A++++++%0A++++++reallyReset(arr)%3B+//+this+works!%0A++++++System.out.println(java.util.Arrays.toString(arr))%3B%0A+++%7D%0A+++%0A%7D&mode=display&curInstr=0)!


**Tämä muunneltu tiivistelmä metodien käyttämisestä ja määrittelemisestä perustuu Helsingin yliopiston Agile Education Research -tutkimusryhmän [MOOC-ohjelmointikurssin materiaaliin](https://materiaalit.github.io/ohjelmointi-18/part2/). Lisenssi: Creative Commons BY-NC-SA.**

---

# Ajan käsittely Javassa

* Nykyaikainen Javan standardikirjasto (Java 8+) käsittelee aikaa luotettavasti ja selkeästi
* Aikaisemmissa versioissa ajan käsittely on ollut sekavaa ja virhealtista
    * Kuukausien numerointi alkoi joskus nollasta, joskus yhdestä
    * Aikaluokat eivät ole tukeneet rinnakkaisuutta 
    * jne...
* **Merkittävä osa nettilähteistä esittelee vanhentuneita tai "epävirallisia" tapoja ajan käsittelyyn**

##  Aikaluokkia

`java.time.LocalDate`

"A date without a time-zone in the ISO-8601 calendar system, such as 2007-12-03."

`java.time.LocalTime`

"A time without a time-zone in the ISO-8601 calendar system, such as 10:15:30."

`java.time.LocalDateTime`

"A date-time without a time-zone in the ISO-8601 calendar system, such as 2007-12-03T10:15:30."

`java.time.ZonedDateTime`

"A date-time with a time-zone in the ISO-8601 calendar system, such as 2007-12-03T10:15:30+01:00 Europe/Paris."

Lähde: https://docs.oracle.com/javase/8/docs/api/java/time/

### Esimerkki

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
```

```java
LocalDate today = LocalDate.now();

LocalDateTime now = LocalDateTime.now();

LocalDate date1 = LocalDate.of(2018, 9, 19);

LocalDate date2 = LocalDate.parse("2018-09-19");
```

### Vuosi, kuukausi ja päivä
```java
// Luodaan LocalDate-olio, joka pitää sisällään nykyisen päivämäärän:
LocalDate today = LocalDate.now();

// Nyt voimme kysyä LocalDate-oliolta yksittäiset arvot:
int year = today.getYear();

int month = today.getMonthValue();

int day = today.getDayOfMonth();
```

### Vuosien käsittely

```java
// Nykyinen vuosi
Year thisYear = Year.now();
int yearNumber = thisYear.getValue();

// Vuosi 2018
Year anotherYear = Year.of(2018);

// Karkausvuoden selvittäminen
boolean leapYear = thisYear.isLeap();
```

### Ajan "laskeminen" ja vertailu

```java
LocalDate nextWeek = LocalDate.now().plusDays(7);
LocalDate yesterday = LocalDate.now().minusDays(1);

if (yesterday.isBefore(nextWeek)) {
    // suoritetaan jos tosi
}

if (yesterday.isAfter(nextWeek)) {
    // suoritetaan jos tosi
}
```

### Ajanjaksot, Period-luokka
```java
import java.time.Period; // luokan alkuun 
```

```java
LocalDate independence = LocalDate.of(1917, 12, 6);
LocalDate today = LocalDate.now();

Period period = Period.between(independence, today);

int years = period.getYears();
int months = period.getMonths();
int days = period.getDays();

System.out.println(years + " v, " + months + " kk, " + days + " pv");
```

### Ajan merkkijonomuutokset

```java
import java.time.format.DateTimeFormatter; // luokan alkuun 
```
```java
DateTimeFormatter formaatti = DateTimeFormatter.ofPattern("d.M.yyyy");

LocalDate tanaan = LocalDate.now();

// Päivämäärän näyttäminen merkkijonona:
String pvm = tanaan.format(formaatti);

// Merkkijonon "parsiminen" LocalDate-olioksi:
LocalDate pvm = LocalDate.parse("6.12.1917", formaatti);
```

### Ajan muotoilumääreitä

Merkit      | Selitys   | Esimerkki
------------|-----------|------------
yyyy        | Vuosi     | 2000
M           | Kuukausi  | 9
d           | Päivä     | 1
H           | Tunti     | 9
m           | Minuutti  | 5
s           | Sekunti   | 45

Samaa merkkiä voidaan toistaa, jolloin esim. päivä (dd), kuukausi (MM), tunti (HH) ja minuutti (mm) saadaan aina kahden numeron pituisena. Tarvittaessa luvun eteen laitetaan tällöin nolla.

## Koodaustehtävä

Kirjoita ohjelma, joka pyytää käyttäjältä päivämäärän muodossa pp.kk.vvvv, ja kertoo kuinka pitkä aika kuluvan päivän ja annetun päivän välillä on.

Tarvitset ainakin nämä:
* Scanner
* LocalDate
* DateTimeFormatter, (d.M.yyyy)
* Period

# Java-ohjelman kääntäminen ja suorittaminen komentoriviltä

Oppitunnilla käytettiin aikaisemmin kirjoitettua esimerkkiohjelmaa `viikko3/listat/th/KaupungitVerkosta.java`, joka käännettiin `javac`-komennolla komentorivillä class-tiedostoksi:

```
$ javac viikko3/listat/th/KaupungitVerkosta.java
```
Edellä käytetty komento kääntää Java-lähdekoodit suoritettavaksi tavukoodiksi `viikko3/listat/th/KaupungitVerkosta.class`-tiedostoon. Tämä tiedosto voidaan suorittaa `java`-komennolla seuraavasti:

```shell
$ java viikko3.listat.th.KaupungitVerkosta
```

Huomaa, että lähdekoodia käännettäessä annetaan tiedoston polku ja tiedostopääte (.java). Vaikka käännettäessä ja suoritettessa molemmissa esiintyy pakettien ja luokan nimet, on eri komennoissa niillä eri merkitys. Ohjelmaa suoritettaessa kyse ei ole enää tiedoston polusta ja nimestä, vaan Java-paketeista ja Java-luokan nimestä. Tämän vuoksi myöskään `java`-komennolle ei anneta tiedostopäätettä.

Edellä esitetyt komennot tulee antaa Java-pakettien juurihakemistossa, eli esimerkkiprojektissa `src`-hakemistossa.

---

# Olio-ohjelmointi (Object-oriented programming)

Olio-ohjelmointi on yleinen ohjelmointiparadigma, jota hyödynnetään lukuisissa ohjelmointikielissä. Myös Java on olio-ohjelmointikieli, vaikka emme toistaiseksi ole omissa ohjelmissamme soveltaneet juurikaan olio-ohjelmointia.

Olio-ohjelmoinnin avulla voimme jäsentää ohjelmamme toiminnallisuuden ja ohjelmassa esiintyvän datan loogisiksi itsenäisiksi kokonaisuuksiksi, joiden avulla pystymme ratkaisemaan ongelmia. **Olio-ohjelmoinnissa on siis samalla kyse tiedon mallintamisesta että ratkaisujen mallintamisesta.** 

Eri luokilla ja olioilla on erilaisia rooleja ratkaistavissa ongelmissa. Osa luokista ja olioista esimerkiksi mallintaa dataa, toiset suorittavat logiikkaa ja muut huolehtivat vuorovaikutuksesta käyttäjän tai toisten järjestelmien kanssa. Siksi ei ole yhtä ainoaa tapaa mallintaa luokkia ja olioita.

Olioiden ja luokkien käyttötapa riippuu monista seikoista. Jos pankkisovelluksessa käytetään olioita tilien mallintamiseen, tehdään tästä luokasta kenties miljoonia olioita. Samassa sovelluksessa voi olla myös luokkia, joista luodaan vain yksi olio, kuten tilinumeroiden oikeellisuuden tarkastaja. Vaikka molemmat käsitteet toteutetaan olio-ohjelmoinnilla, tilit mallintavat dataa ja tilinumeroiden tarkastaja logiikkaa.

Tällä opintojaksolla keskitymme aluksi luokkien ja olioiden hyödyntämiseen datan mallintamisessa, eli teemme luokkia, jotka vastaavat joitain reaalimaailman käsitteitä. Jatkokurssilla olio-ohjelmointia sovelletaan esimerkiksi olioina, joiden tarkoitus on toimia vuorovaikutuksessa tietokannan ja verkkoselainten kanssa.

## Suositeltavaa luettavaa

Johdatus olio-ohjelmointiin: https://ohjelmointi-19.mooc.fi/osa-4/2-johdatus-olio-ohjelmointiin

Luokka ja olio: https://ohjelmointi-19.mooc.fi/osa-4/3-luokka-ja-olio

## Tiedon mallintaminen

Olemme käyttäneet jo monenlaisia olioita omissa ohjelmissamme. Käsitellessämme esim. päivämääriä olemme käyttäneet `LocalDate`-luokkaa emmekä toisistaan irrallisia muuttujia:

```java
// Päivämäärät olioina, kätevää:
LocalDate olio1 = LocalDate.of(2020, 1, 1);
LocalDate olio2 = LocalDate.of(2030, 12, 31);


// Päivämäärät primitiiveinä, epäkäytännöllistä:
int vuosi1 = 2020;
int kuukausi1 = 1;
int paiva1 = 1;

int vuosi2 = 2030;
int kuukausi2 = 12;
int paiva2 = 31;
```

Kun tieto on mallinnettu olioina, voimme hyödyntää olioiden operaatioita, eli **metodeja**, erilaisten operaatioiden suorittamiseksi. `LocalDate`-luokan operaatioita ovat toistaiseksi olleet päivämäärien vertailu sekä päivämäärävälin pituuden laskeminen:

```java
LocalDate olio1 = LocalDate.of(2020, 1, 1);
LocalDate olio2 = LocalDate.of(2030, 12, 31);

// olioilla on metodeja, joiden avulla voimme suorittaa erilaisia operaatioita:
if (olio1.isBefore(olio2)) {
    System.out.println("Päivämäärä 1 on ennen päivämäärää 2!");
}
```

Päivämäärän vertailussa `LocalDate`-luokka piilottaa sisäänsä varsinaisen vertailussa suoritettavan logiikan, jota ei nyt tarvitse toistaa missään `LocalDate`-luokan ulkopuolella. Logiikka on kuitenkin käytettävissä kaikkialta luokan tarjoaman `isBefore`-oliometodin avulla, jolloin emme itse joudu toteuttamaan vastaavaa luokan sisään toteutettua vertailua: 

```java
/* Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved. */
int compareTo0(LocalDate otherDate) {
    int cmp = (year - otherDate.year);
    if (cmp == 0) {
        cmp = (month - otherDate.month);
        if (cmp == 0) {
            cmp = (day - otherDate.day);
        }
    }
    return cmp;
}
```
**Luokan sisäistä toteutusta päivämäärien vertailemiseksi ei siis tarvitse tietää, jotta voimme hyödyntää sitä.**

Vastaavasti, jos haluamme laskea päivämäärän esimerkiksi 31 päivää minkä tahansa päivämäärän jälkeen, joudumme ratkaisussamme käsittelemään eri pituisia kuukausia, karkausvuosia ja vuodenvaihteen yli meneviä aikavälejä. On erittäin loogista, että tällaiset usein tarvittavat operaatiot paketoidaan omaksi kokonaisuudeksi, eli luokaksi, joka tarjoaa yksinkertaisen rajapinnan monimutkaisten operaatioiden suorittamiseksi:

```java
LocalDate uusiOlio = olio1.plusDays(31);
```

Teknisten yksityiskohtien piilottamista ja operaatioiden käsitteellistämistä kutsutaan **abstraktoinniksi**, ja se on yksi olio-ohjelmoinnin peruspilareista.


## Luokka ja olio

`LocalDate`-luokka määrittelee kaikille sen olioille yhteiset ominaisuudet ja yhteiset toiminnallisuudet. Voimme kutsua samoja metodeja mille tahansa päivämääräolioille. Jokainen erillinen päivämäärä on kuitenkin toisistaan riippumaton. Päivämääräluokkia on siis yksi ja siitä voidaan luoda rajoittamattoman määrän päivämääräolioita.

Käyttäessämme olioita omassa koodissamme, **käytämme luokan nimeä muuttujan tyyppinä**. **Muuttujiin asetetaan arvoja, jotka ovat olioita**. Meille tuttu tietotyyppi `String` on luokka ja yksittäiset merkkijonot ovat sen olioita. Kaikilla merkkijonoilla on samat metodit, mutta eri sisältöiset merkkijono-oliot palauttavat metodeja kutsuttaessa eri arvoja. Ne ovat siis oliokohtaisia eli **oliometodeja**:

```java
String olio1 = "Eka merkkijono-olio";
String olio2 = "Toinen merkkijono-olio";

// samat metodit, mutta yksilölliset paluuarvot
int pituus1 = olio1.length();
int pituus2 = olio2.length();
```


## Datan mallintaminen luokalla

Aikaisemmin tällä kurssilla olemme käsitelleet mm. kaupunkien nimiä ja väkilukuja taulukkomuodossa (csv): 

Kaupunki	| Väkiluku 
------------|---------
Helsinki    | 653867
Espoo	    | 289413
Tampere	    | 238245
Vantaa	    | 233290
...         | ...

Kuten päivämäärien kanssa, kaupunkien ja niiden väkilukujen käsitteleminen yksittäisillä muuttujilla olisi hankalaa. 

```java
String nimi1 = "Helsinki";
int vakiluku1 = 653_867;

String nimi2 = "Espoo";
int vakiluku2 = 289_413;

//...
```

Kaupunkien ja väkilukujen esittäminen esimerkiksi listoina olisi myös epäluonnollista, koska nimet ja väkiluvut olisivat toisistaan irrallisia tietoja:

```java
List<String> nimet = List.of("Helsinki", "Espoo");
List<Integer> vakiluvut = List.of(653_867, 289_413);
```

Kun ongelmasta tunnistetaan reaalimaailman käsitteitä, voidaan niitä vastaavia uusia rakenteita luoda myös ohjelmiin. Tässä esimerkissä on selvästi kyse kaupungeista, joten voimme luoda uuden käsitteen "Kaupunki". Tätä käsitettä kutsutaan luokaksi ja kaikkia yksittäisiä kaupunkeja olioiksi:

```java
Kaupunki hki = new Kaupunki("Helsinki", 653_867);
Kaupunki esp = new Kaupunki("Espoo", 289_413);
```

Voimme myös toteuttaa luokkiin operaatioita, jotka abstraktoivat suoritettavia operaatioita:

```java
Kaupunki hki = new Kaupunki("Helsinki", 653867);
Kaupunki esp = new Kaupunki("Espoo", 289413);

if (hki.onSuurempiKuin(esp)) {
    System.out.println("Vertailu tehtiin olion metodilla!");
}
```

## Oman luokan määrittely

Kukin luokka määritellään pääsääntöisesti omaan tiedostoonsa, jonka nimi on sama kuin luokan nimi ja pääte on ".java", aivan kuten tähänkin asti. Luokan nimi kirjoitetaan siten, että kaikki sanat ovat yhdessä ja sanoissa on isot alkukirjaimet (CamelCase). Luokan määrittely alkaa avainsanoilla `public` ja `class`. Kaupunki-luokan tiedosto näyttää aluksi seuraavalta:

```java
// Kaupunki.java
public class Kaupunki {

}
```

Huomaa, että tämän luokan on tarkoitus mallintaa käsitteitä eikä esim. toimia omana ohjelmanaan. **Luokkaan ei siis haluta tehdä esimerkiksi `main`-metodia, joka kuuluisi erilliseen ohjelmaluokkaan.** Ohjelman selkeän rakenteen vuoksi on erittäin tärkeää pilkkoa eri tarkoituksia palvelevat kokonaisuudet eri luokkiin. Main-metodiluokan tarkoitus on tarjota vuorovaikutus käyttäjän ja ohjelman välille, kun taas `Kaupunki`-luokan tarkoitus on esittää yksittäisiä tietoalkioita. Ohjelman pilkkomiseksi on olemassa erilaisia malleja, kuten ["separation of concerns"](https://www.google.com/search?q=separation+of+concerns) ja ["data, context and interaction"](https://www.google.com/search?q=data+context+and+interaction).


### Oliomuuttujat

Edellä olemme todenneet tarpeen tallentaa jokaiselle Kaupunki-oliolle oma nimi ja väkiluku. Näitä varten tarvitaan siis muuttujat. Tähän asti muuttujat on aina määritelty paikallisiksi muuttujiksi, jotka ovat voimassa vain tietyn metodin suorituksen ajan. Nyt haluamme kuitenkin tehdä **oliokohtaisia muuttujia**, eli **oliomuuttujia**, jotka ovat pysyviä, ja joiden **arvot säilyvät myös metodien suoritusten välissä**.

Olioiden pysyvät muuttujat määritellään luokan runkoon metodien ulkopuolelle:

```java
// OmaLuokka.java
public class OmaLuokka {

    String teksti = "Tämä muuttuja säilyy myös metodikutsujen välissä!";
    int numero = 0;

}
```

Haluamme pääsääntöisesti sulkea muuttujat luokan sisään siten, että niitä voidaan käyttää ainoastaan luokan omilla metodeilla. Tätä varten oliomuuttujille määritellään käytännössä aina näkyvyys `private`:

```java
// Kaupunki.java
public class Kaupunki {

    private String nimi;
    private int vakiluku;

}
```

**Keskeisiä seikkoja oliomuuttujista:**

* Oliomuuttujat ovat **yksittäisille olioille kuuluvia muuttujia**.
* Oliomuuttujat **määritellään luokassa kaikkein ylimpänä**, ennen metodeja ja muita osia.
* Kaikilla saman luokan olioilla on **samat muuttujat, mutta omilla arvoillaan**.
* Oliomuuttujien arvot säilyvät olion koko olemassaolon ajan, toisin kuin metodien sisällä käytetyt paikalliset muuttujat.
* Oliomuuttujien näkyvyyttä voidaan rajoittaa aivan kuten metodien. Pääsääntöisesti ne ovat `private`.


### Olioiden luominen

Olioita luodaan `new`-avainsanalla. Joissain tapauksissa olemme luoneet olioita muillakin tavoilla, esim. `LocalDate.now()`, mutta myös näissä tapauksissa varsinainen olion luominen tapahtuu kulissien takana `new`-avainsanalla.

Avainsanan jälkeen kirjoitetaan olion luokan nimi ja sulut. Sulkujen sisään kirjoitamme parametriarvot kuten metodikutsujen kanssa:

```java
Kaupunki uusiOlio = new Kaupunki("Helsinki", 653867);
```

Edellä oleva luontikäsky käsitellään Java-luokassa **konstruktorin** avulla. Konstruktori on ikään kuin metodi, jota kutsutaan automaattisesti olioita luotaessa. Konstruktorin nimi on sama kuin luokan nimi, eli tässä tapauksessa `Kaupunki`. Sen näkyvyys on tyypillisesti `public`. Luotu olio voidaan ottaa talteen muuttujaan esimerkin mukaisesti sijoitusoperaattorilla.

Konstruktorin parametrimuuttujat määritellään kuten metodeissa. Nimet voivat olla samat kuin oliomuuttujien nimet, mutta tällöin vaaditaan erityistä huolellisuutta sen suhteen, mitä arvoja kulloinkin käytetään. **Luokassa voi siis olla samannimisiä paikallisia- ja oliomuuttujia**.

```java
// Kaupunki.java

public class Kaupunki {

    private String nimi;
    private int vakiluku;

    // konstruktori
    public Kaupunki(String nimi, int vakiluku) {
    }
}
```


### Arvojen asettaminen oliomuuttujiin

Oliot voivat käyttää omia muuttujiaan erityisen `this`-viittauksen kautta. Käytettäessä olion omaa `nimi`-muuttujaa, kirjoitamme `this.nimi`. Parametrina annettu paikallinen ja tilapäinen arvo `nimi` voidaan siis asettaa pysyvään talteen olion oliomuuttujaan sijoittamalla se näin: 

```java
this.nimi = nimi;
```

```java
// Kaupunki.java

public class Kaupunki {

    private String nimi;
    private int vakiluku;

    // konstruktori
    public Kaupunki(String nimi, int vakiluku) {
        // nimi on paikallinen muuttuja, this.nimi on oliomuuttuja
        this.nimi = nimi;
        this.vakiluku = vakiluku;

        // tämä ei tee mitään, koska paikallisen muuttujan arvo asetetaan samaan paikalliseen muuttujaan!
        nimi = nimi;
    }
}
```

**`this` viittaa aina siihen olioon, jonka metodia tai konstruktoria ollaan suorittamassa.**

Jos parametrimuuttuja ja oliomuuttuja ovat erinimiset, voidaan `this` jättää kirjoittamatta. Näin usein tehdäänkin, eikä koodissa toisteta välttämättä `this`-viittausta, mikäli sekaannuksen vaaraa ei ole. On kuitenkin oikean lopputuloksen kannalta turvallisempaa käyttää `this`-viittausta aina kuin olla käyttämättä sitä.

* `this`-viittauksen kautta voidaan lukea arvoja oliomuuttujista tai asettaa niihin uusia arvoja
* `this`-viittauksen käyttäminen ei ole aina välttämätöntä, mutta käytämme sitä systemaattisesti selkeyden vuoksi.


**Keskeisiä seikkoja olioiden alustamisesta:**

* Olioiden kaikki muuttujat ovat oletuksena aluksi tyhjiä.
* Niihin voidaan asettaa alkuarvot konstruktorin avulla.
* Konstruktori on ikään kuin metodi, jota kutsutaan automaattisesti olioita luotaessa.
* Konstruktorin nimi on sama kuin luokan nimi ja näkyvyys usein `public`.


### Oliometodit

Olemme kirjoittaneet kurssilla toistaiseksi staattisia metodeja. Staattisten metodien otsikossa esiintyy avainsana `static` ja metodeja kutsutaan luokan nimen avulla, esim: `double suurin = Math.max(1.0, 2.0);`.

**Staattiset metodit eivät ole oliokohtaisia, joten niissä ei voida hyödyntää oliomuuttujia**.

Kun haluamme määritellä oliometodeja, jätämme pois `static`-avainsanan. Tällöin metodia ei voida kutsua luokan nimen kautta, vaan sitä kutsutaan jollekin tietylle oliolle. Esimerkiksi `String`-luokan `length()` on oliokohtainen metodi. Merkkijonoluokalla ei ole yleistä pituutta joka voitaisiin laskea yleisellä tasolla `String.length();`, vaan pituus liittyy aina johonkin tiettyyn merkkijonoon: `etunimi.length();`.

Jos haluaisimme esimerkiksi toteuttaa yllä esitellyn `onSuurempiKuin`-metodin, joka palauttaa `true`, jos se kaupunki jonka metodia kutsutaan on suurempi kuin toinen, voidaan se toteuttaa seuraavasti:

```java
public boolean onSuurempiKuin(Kaupunki toinen) {
    return this.vakiluku > toinen.vakiluku;
}
```

Metodin otsikko on tuttu aikaisemmilta oppitunneilta. Metodi palauttaa totuusarvon (`boolean`) ja se saa parametrinaan `Kaupunki`-olion, jota käytetään `toinen`-muuttujan kautta. Metodin sisällä se olio, jonka kautta metodia kutsuttiin on käytettävissä erityisen `this`-muuttujan kautta: `this.vakiluku`.

Parametrina saadun olion väkiluku saadaan käyttöön `toinen`-muuttujan avulla, eli `toinen.vakiluku`. Itse vertailu on tavallinen "suurempi kuin" vertailuoperaatio, jonka paluuarvo palautetaan metodista.

```java
// Kaupunki.java

public class Kaupunki {

    private String nimi;
    private int vakiluku;

    public Kaupunki(String nimi, int vakiluku) {
        this.nimi = nimi;
        this.vakiluku = vakiluku;

    }

    public boolean onSuurempiKuin(Kaupunki toinen) {
        return this.vakiluku > toinen.vakiluku;
    }

}
```

### toString()-metodi ja sen korvaaminen: @Override

Jokaisella luokalla on olemassa `toString`-niminen metodi, jota kutsutaan **automaattisesti**, kun olioista muodostetaan merkkijonoja esimerkiksi tulostamista varten.

Jos et kirjoita omaan luokkaasi `toString`-metodia, muodostaa Java olioistasi melko vaikeaselkoisen merkkijonon, esim:
`Kaupunki@1db9742`.

Voit kirjoittaa luokallesi oman merkkijonoesityksen ohittamalla Javan valmiin `toString`-metodin (`@Override`). `toString` ei saa ottaa parametreja ja sen täytyy aina palauttaa merkkijono:

```java
@Override
public String toString() {
    return "Olion merkkijonoesitys";
}
```

Kaupunki-luokan `toString`-metodissa voidaan käyttää `this`-viittausta ja muodostaa merkkijono esimerkiksi seuraavasti:

```java
@Override
public String toString() {
    return this.nimi + " (" + this.vakiluku + ")";
}
```

Nyt esim. println-metodi tulostaa `Kaupunki`-olioista `toString`-metodimme mukaisia merkkijonoja:

```java
Kaupunki hki = new Kaupunki("Helsinki", 653867);

// toString-metodia voidaan kutsua itse:
String merkkijono = hki.toString();
System.out.println(merkkijono); // Helsinki (653867)

// println osaa kutsua toString-metodia myös automaattisesti:
System.out.println(hki); // Helsinki (653867)
```


## Koodin jakaminen luokkiin: ohjelmaluokka

Eri luokilla on hyvin erilaiset roolit ohjelmassa. Joidenkin luokkien rooli on mallintaa dataa, kun taas joidenkin tarjota erilaisia operaatioita. Ohjelman eri osien roolien ymmärtämiseksi on tärkeää että emme sekoita yhteen luokkaan ristiriitaisia tai päällekkäisiä rooleja. `Kaupunki`-luokan tarkoitus on mallintaa lopullisessa ohjelmassa olevia satoja tietueita, eikä se liity ohjelman käyttöliittymään tai käynnistämiseen.

Olisikin luokan tarkoituksen näkökulmasta ristiriitaista, että `Kaupunki`-luokkaa käytettäisiin myös ns. pääohjelmana, joka käynnistää käyttöliittymän tai tekee muita suoritukseen liittyviä operaatioita. Tätä varten on hyvä tehdä oma luokkansa, jolla voidaan käyttää `Kaupunki`-olioita esim. seuraavasti:

```java
public class KaupunkiOhjelma {

    public static void main(String[] args) {
        Kaupunki hki = new Kaupunki("Helsinki", 653867);
        Kaupunki esp = new Kaupunki("Espoo", 289413);

        if (hki.onSuurempiKuin(esp)) {
            System.out.println("Eka kaupunki on suurempi");
        }
    }
}
```


## Getterit ja setterit

Koska oliomuuttujat on asetettu yksityisiksi, niitä ei voida suoraan käyttää luokan ulkopuolelta. Mikäli ohjelmassa on tarve käyttää nimeä tai väkilukua luokan ulkopuolelta, luokkaan määritellään näille muuttujille omat "getterit ja setterit", eli metodit, joilla voidaan kysyä nykyinen arvo tai asettaa uusi arvo:

```java
public String getNimi() {
    return this.nimi;
}

public void setNimi(String nimi) {
    this.nimi = nimi;
}

public int getVakiluku() {
    return this.vakiluku;
}

public void setVakiluku(int vakiluku) {
    this.vakiluku = vakiluku;
}
```

Lue lisää gettereistä ja settereistä: https://www.w3schools.com/java/java_encapsulation.asp


## Null-viittaukset

Javassa on erityinen arvo nimeltä `null`, joka on käytännössä tyhjä viittaus. Jos viittaustyyppistä muuttujaa ei ole asetettu viittaamaan mihinkään, siinä on tällöin arvo `null`. `null`-viittausten kanssa tulee olla tarkkana, koska ne saattavat aiheuttaa bugeja ja ohjelman kaatumista:

```java
public class Tili {

    private String tiliNumero; // tiliNumero-muuttujan arvo on alussa null, eli tyhjä viittaus

    public String getTiliNumero() {
        return tiliNumero;
    }

    public void setTiliNumero(String tiliNumero) {
        this.tiliNumero = tiliNumero;
    }
}
```

```java
Tili t = new Tili();
System.out.println(t.getTiliNumero()); // Tulostaa null, koska tilinumeroa ei ole asetettu!
```

### NullPointerException
`NullPointerException` on ajonaikainen poikkeus, joka on seurausta siitä, että tyhjää arvoa (`null`) käytetään kuin se olisi olio. **Aina kun on mahdollista, että jokin arvo on alustamatta, eli `null`, tulee se tarkastaa ennen arvon käyttämistä.**

```java
String numero = t.getTiliNumero();
System.out.println(numero.toUpperCase()); // kaatuu NullPointerException-poikkeukseen, jos tilinumeroa ei ole asetettu
```

**Tämän Tili-esimerkin tapauksessa olisi hyvä idea toteuttaa konstruktori, jonka avulla tilinumero olisi pakko antaa heti oliota luotaessa.**


### Null-arvon tarkastaminen

Yllä oleva ongelma `toUpperCase()`-metodikutsun kutsumisessa `null`-arvolle voidaan välttää esim. seuraavasti:

```java
String numero = t.getTiliNumero();

if (numero == null) {
    System.out.println("Ei tilinumeroa");
} else {
    System.out.println(numero.toUpperCase());
}
```

----

## Synonyymejä

* **Oliot, objektit, ilmentymät, instanssit**

    Luokan ilmentymille on olemassa useita nimiä, jotka kuitenkin tarkoittavat samaa asiaa. 
    
    Kontekstista ja lähteestä riippuen käytetään joskus eri termejä.

* **Oliomuuttujat, instanssimuuttujat, ilmentymämuuttujat, jäsenmuuttujat, kentät, attribuutit**

    Luokassa määritellyille olioiden muuttujille on myös lukuisia nimiä. 

    Kaikki niistä kuitenkin tarkoittavat muuttujaa, joka on yksilöllinen jokaiselle tietyn luokan oliolle.

---

## Esimerkki: yhteystiedot

Kuvitteellisessa sovelluksessa käsitellään yhteystietoja, joihin kuuluvat henkilön nimi, puhelinnumero ja sähköpostiosoite. Tietty nimi, numero ja e-mail liittyvät aina yhteen henkilöön, ja ohjelmassa käsitellään lukuisten henkilöiden yhteystietoja.

JSON-tiedostomuodossa ohjelmamme data voisi olla esimerkiksi tämän esimerkin kaltainen:

```json
[{
  "nimi": "Lindsey",
  "email": "ldrillingcourt0@so-net.ne.jp",
  "puhelin": "132-414-7730"
}, {
  "nimi": "Zilvia",
  "email": "zzamboniari1@dell.com",
  "puhelin": "445-276-2785"
}, {
  "nimi": "Moses",
  "email": null,
  "puhelin": "681-240-4656"
}, {
  "nimi": "Devondra",
  "email": "cyberchimps.com",
  "puhelin": "306-422-3408"
}]
```
JSON esimerkki: https://mockaroo.com/

Data koostuu selvästi keskenään rakenteellisesti samanlaisista tietoalkioista, joilla on yksilölliset arvot, kuten nimi ja email. Huomaa, että henkilölle "Moses" ei ole asetettu sähköpostiosoitetta, mutta sillä on silti olemassa "muuttuja" sähköpostin tallentamiseksi. **Puuttuvaa arvoa ei voida jättää tyhjäksi, vaan siihen on asetettu null-viittaus.**

Tietojen tallentaminen erillisissä muuttujissa olisi hankalaa ja virhealtista. Sen sijaan määritellään luokka `Yhteystieto` ja jokaista henkilöä varten luodaan olio eli ilmentymä tästä luokasta:

```java
String nimi1 = "Matti";
String email1 = "matti@example.com";
String puhelin1 = "04055512345";

String nimi2 = "Maija";
String email2 = "maija@example.com";
String puhelin2 = "05055598765";

Yhteystieto matti = new Yhteystieto("Matti", "matti@example.com", "04055512345");
Yhteystieto maija = new Yhteystieto("Maija", "maija@example.com", "05055598765");
```

### Yhteystieto-luokan toteutus

```java

public class Yhteystieto {
    private String nimi;
    private String email;
    private String puhelin;

    public Yhteystieto(String nimi, String email, String puhelin) {
        // annetut parametriarvot asetetaan konstruktorin sisällä talteen oliomuuttujiin
        this.nimi = nimi;
        this.email = email;
        this.puhelin = puhelin;
    }
}

```

Kun luokkaan on määritetty konstruktori, luokan olioita luotaessa annetaan parametreina samat arvot, kuin konstruktoriin on määritelty:

```java
Yhteystieto matti = new Yhteystieto("Matti Meikäläinen", "matti@example.com", "04055512345");

Yhteystieto maija = new Yhteystieto("Maija Meikäläinen", "maija@example.com", "05055598765");
```

### Oliomuuttujien käyttäminen

```java
public class Yhteystieto {
    private String nimi;
    private String email;
    private String puhelin;

    // ...konstruktori jätetty pois...

    public void tulostaNimi() {
        // lukee oliomuuttujan arvon ja tulostaa sen println-metodilla:
        System.out.println(this.nimi);
    }

    public String kerroEmail() {
        // lukee oliomuuttujan arvon ja palauttaa sen paluuarvona:
        return this.email;
    }

    public void asetaEmail(String uusiEmail) {
        // asettaa oliomuuttujaan uuden parametrina saadun arvon
        this.email = uusiEmail;
    }
}
```

### Oliometodin kutsuminen

Oliometodeita kutsutaan viittauksen, eli esim. muuttujan kautta. Metodi suoritetaan "sille oliolle", jonka kautta sitä kutsutaan. Parametriarvot annetaan kuten staattisia metodeita kutsuttaessa:

```java
Yhteystieto matti = new Yhteystieto(...);

// kysytään email ja laitetaan se talteen
String email = matti.kerroEmail();

// tulostetaan talteen laitettu email
System.out.println(email);

// laitetaan yhteystietoon uusi osoite
matti.asetaEmail("uusi@example.com");

// tulostetaan yhteystiedon nimi metodin sisällä
matti.tulostaNimi();
```

### toString()-metodi ja sen ohittaminen: @Override

Katso kuvaus toString-metodin toteuttamisesta ylempää tästä dokumentista.

```java
class Yhteystieto {

    // muuttujat, konstruktori ja muut metodit...

    @Override
    public String toString() {
        return this.nimi + " (" + this.email + ")";
    }
}
```

---

### Datan kapselointi (encapsulation)

Olioiden attribuuttien muuttamista halutaan hyvin usein rajoittaa:

* `Yhteystieto`-luokan sähköpostiosoitteeksi ei haluta hyväksyä muita kuin valideja sähköpostiosoitteita
* `Tili`-luokan saldon muuttaminen luokan ulkopuolelta halutaan estää

**Ratkaisu:** olion attribuutit merkitään yksityisiksi (private) ja arvoja käytetään vain metodien kautta!

Esim. sähköpostiosoitteen muoto voidaan tällöin tarkastaa metodissa ennen kuin se laitetaan talteen:

```java
class Yhteystieto {
    private String email;

    public boolean asetaEmail(String e) {
        if (e.matches(".+@.+\\..+")) {
            this.email = e;
            return true;
        } else {
            return false;
        }
    }
}
```

Esimerkin säännöllinen lauseke sähköpostin tarkastamiseksi ei ole täydellinen, mutta se on riittävän yksinkertainen tähän esimerkkiin.


## Viittauksen kopioiminen != olion kopioiminen

Olioita ei voi kopioida sijoittamalla niitä uusiin muuttujiin. Tällöin viitataan vain samaan olioon usealla eri muuttujalla:

```java
Yhteystieto y1 = new Yhteystieto("Adam", "050123", "adam@example.com");

// ei kopioi, vaan viittaa samaan olioon:
Yhteystieto y2 = y1;
```

Jos yllä olevassa esimerkissä kutsutaan `asetaEmail`-metodia muuttujan `y1` kautta, muuttuu sähköpostiosoite myös `y2`:ssa. Tämä johtuu siitä, että **olemme luoneet vain yhden olion, johon viitataan kahdella muuttujalla**.


--- 


# Olioiden vertailu

Kuten merkkijonoja käsiteltäessä huomasimme, merkkijonojen vertailu `==`-operaattorilla vertailee olioviittauksia eikä merkkijonojen sisältöä:

```java
public class OlioidenVertailu {

    public static void main(String[] args) {
        String hauki1 = new String("Hauki");
        String hauki2 = new String("Hauki");

        // vertailee olioviittauksia eikä merkkijonojen sisältöä:
        System.out.println(hauki1 == hauki2); // tulostaa false

        // equals-metodi vertailee merkkijonojen sisältöä:
        System.out.println(hauki1.equals(hauki2)); // tulostaa true
    }
}
```

Merkkijonoja vertaillaankin aina joko `equals`- tai `equalsIgnoreCase`-metodilla. Jos haluamme vertailla esim. omaa luokkaa `Tuote`, tuotteita vertailtaessa törmäämme samaan ongelmaan `==`-operaation kanssa:

```java
public class Tuote {
    private String nimi;

    public Tuote(String nimi) {
        this.nimi = nimi;
    }
}
```

```java
Tuote maito1 = new Tuote("Maito");
Tuote maito2 = new Tuote("Maito");

// vertailee ovatko oliot samat:
System.out.println(maito1 == maito2); // false

// käyttää Javan valmista equals-metodia:
System.out.println(maito1.equals(maito2)); // false
```

**Miksi yllä oleva koodi tulostaa kahdesti `false`?**

* `maito1 == maito2`-vertailu ei toimi, koska operaatio vertailee **ovatko oliot samat**, eikä huomioi olioiden sisältöä lainkaan
* `maito1.equals(maito2)` ei toimi, koska emme ole vielä toteuttaneet `equals`-metodia `Tuote`-olioiden vertailemiseksi. 

Yllä kutsumamme `equals`-metodi on siis **Javan oletusmetodi, joka ei huomioi lainkaan oman luokkamme ominaisuuksia**.

### Oman `equals`-metodin toteuttaminen

Edellä esitetty `maito1.equals(maito2)`-vertailu ei toimi, koska `equals`-metodi vertailee oletuksena olioita samalla tavalla kuin `==`. Voimme kuitenkin määritellä aivan oman tapamme vertailla `Tuote`-olioita määrittelemällä oman `equals`-metodin:

```java
public class Tuote {
    private String nimi;

    public Tuote(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public boolean equals(Object toinen) {
        // Vertaillaan olioiden merkkijonoesityksiä. Jos ovat samat, myös oliot tulkitaan samoiksi:
        return this.toString().equals(toinen.toString());
    }

    @Override
    public String toString() {
        return "Tuote [nimi=" + nimi + "]";
    }
}
```

Huomaa, että metodi ylikirjoittaa Javan standardikirjaston metodin, minkä vuoksi sen otsikon on oltava täsmälleen samanlainen kuin standardikirjastossa: `public boolean equals(Object toinen)`. Metodin on siis oltava julkinen oliometodi (ei static), joka palauttaa totuusarvon ja saa parametrinaan minkä tahansa toisen olion.

Metodeja korvattaessa on hyvä käytäntö lisätä metodin ylle `@Override`-**annotaatio**, joka toimii sekä dokumentaationa metodin korvaamisesta että Java-kääntäjän ohjeena varmistaa että metodi korvattiin oikein.

Yllä olevassa esimerkkikoodissa `equals`-metodi on toteutettu siten, että siellä vertaillaan Tuote-olion ja annetun toisen olion merkkijonoesityksiä. Jos merkkijonot ovat samat, myös oliot tulkitaan samoiksi:

```java
@Override
public boolean equals(Object toinen) {
    // Vertaillaan olioiden merkkijonoesityksiä. Jos ovat samat, myös oliot tulkitaan samoiksi:
    return this.toString().equals(toinen.toString());
}
```

Nyt vertailu `equals`-metodilla tuottaa odotetun tuloksen:

```java
Tuote maito1 = new Tuote("Maito");
Tuote maito2 = new Tuote("Maito");

System.out.println(maito1.equals(maito2)); // true
```

**Huom!** Olioiden vertailu vertailemalla niiden merkkijonoesityksiä ei ole paras mahdollinen tapa vertailla olioiden samankaltaisuutta. Paremmat vertailut edellyttäisivät, että tutkisimme mitä tyyppiä metodin parametrina saama arvo `toinen` on:

```java
public boolean equals(Object toinen) {
    // onko vertailtava toinen-olio myös Tuote vai jotain muuta tyyppiä?
}
```

Tällä kurssilla emme kuitenkaan perehdy perintään ja tyyppimuunnoksiin, joiden ymmärtäminen olisi tarpeellista, mikäli haluaisimme selvittää toisen olion oikean tyypin ja käsitellä sitä `Tuote`-oliona.


### `equals`, `contains` ja `indexOf`

`equals`-metodilla on Javan standardikirjastossa paljon muutakin käyttöä kuin kahden arvon vertailu. Sitä hyödynnetään mm. etsiessä olioita listoilta:

```java
List<Tuote> tuotteet = List.of(new Tuote("Maito"), new Tuote("Piimä"), new Tuote("Leipä"));
boolean sisaltaaLeivan = tuotteet.contains(new Tuote("Leipä"));

System.out.println(sisaltaaLeivan); // true
```

`contains`-metodi kutsuu sisäisesti jokaisen listalla olevan olion `equals`-metodia selvittääkseen, onko annettu arvo listalla. Toteuttamamme `equals`-metodi toimii nyt yhdessä `contains`-metodin kanssa ja tuote `new Tuote("Leipä")` löytyy listalta.

Lue sivu ["Olioiden samankaltaisuus"](https://ohjelmointi-19.mooc.fi/osa-6/3-olioiden-samankaltaisuus) saadaksesi lisätietoa olioiden vertailusta ja `equals`-metodin toteuttamisesta.

```java
public class TuoteOhjelma {

    public static void main(String[] args) {
        Tuote maito1 = new Tuote("Maito");
        Tuote maito2 = new Tuote("Maito");

        System.out.println(maito1);
        System.out.println(maito2);

        System.out.println("Vertailuoperaattori: " + (maito1 == maito2)); // false, koska maito1 on eri olio kuin maito2
        System.out.println("equals: " + maito1.equals(maito2)); // palauttaa nyt true, koska toteutimme equals-metodin

        // MUITA HYÖTYJÄ EQUALS-METODISTA:

        List<Tuote> tuotteet = List.of(maito1, new Tuote("Leipä"), new Tuote("Piimä"));

        // Listoilta hakeminen käyttää taustalla equals-metodia:
        boolean onLeipa = tuotteet.contains(new Tuote("Leipä"));

        // Indeksin etsiminen käyttää taustalla equals-metodia:
        int piimaIndeksi = tuotteet.indexOf(new Tuote("Piimä"));

        System.out.println("contains: " + onLeipa); // Toimii! => true
        System.out.println("indexOf: " + piimaIndeksi); // Toimii => 2
    }
}
```

## Järjestäminen ja Collections.sort

Oletetaan, että meillä on lista, jossa on neljä nimeä sekajärjestyksessä:

```java
List<String> nimet = Arrays.asList("Maija", "Matti", "Arja", "Aatami");
```

Tiedämme listojen yhteydestä, että Javassa on valmiina tapa vertailla ja järjestellä olioita:

```java
Collections.sort(nimet);

// Nimet ovat nyt aakkosjärjestyksessä:
System.out.println(nimet); // [Aatami, Arja, Maija, Matti]
```

Nimet oli helppoa laittaa järjestykseen `Collections.sort`-metodin avulla!


## Miten Java järjesti oliot? 

`Collections.sort` osasi järjestää merkkijonot kasvavaan järjestykseen, koska `String`-luokka on yhteensopiva `Comparable`-tyypin kanssa. Kaikki `Comparable`-oliot osaavat vertailla omaa järjestystään suhteessa toiseen saman luokan olioon. Tämä johtaa siihen, että `Collections.sort` osaa asetella merkkijonot oikeaan järjestykseen.


### `compareTo`-metodi

Kaikkiin `Comparable`-luokkiin on tehty valmiiksi `compareTo`-niminen metodi, jonka avulla voidaan vertailla kahden olion keskenäistä järjestystä. `Collections.sort` kutsuu sisäisesti jokaisen merkkijonon  `compareTo`-metodia ja järjestää arvot vertailujen tulosten mukaan.

Voimme halutessamme myös itse kutsua `compareTo`-metodia ja tutkia sen tuloksia:

```java
String eka = "Maija";
String toka = "Aatami";

// Kutsutaan String-luokan compareTo-metodia:
int tulos = eka.compareTo(toka);

System.out.println(tulos); // tulostaa 12
```

`compareTo` palauttaa aina kokonaisluvun, josta päätellään, kumpi arvoista tulee järjestyksessä ensin:

* Jos se olio, jonka metodia kutsuttiin on järjestyksessä ensin, `compareTo` palauttaa **negatiivisen luvun**.
* Jos parametrina annettu olio on järjestyksessä ensin, `compareTo` palauttaa **positiivisen luvun**.
* Muussa tapauksessa **palautetaan 0**.

Edellä oleva rivi `"Maija".compareTo("Aatami")` palauttaa arvon **12**, eli `"Maija"` on aakkosissa `"Aatami"`:n jälkeen. Seuraavat esimerkit näyttävät kaikki kolme erilaista tulosta:

```java
System.out.println("a".compareTo("x")); // -23 on negatiivinen, eli a tulee ennen x:ää
System.out.println("w".compareTo("b")); // 21 on positiivinen, eli w tulee b:n jälkeen
System.out.println("t".compareTo("t")); // tulos on nolla, eli merkkijonot ovat "yhtäsuuret"
```

Vertailun tulosta voidaan käyttää kuin mitä tahansa arvoa:

```java
String eka = "Maija";
String toka = "Aatami";

int tulos = eka.compareTo(toka);

if (tulos < 0) {
    System.out.println(eka + " < " + toka);
} else if (0 < tulos) {
    System.out.println(eka + " > " + toka);
} else {
    System.out.println(eka + " == " + toka);
}
```

Edellä esitetyillä arvoilla yllä oleva koodi tulostaa `Maija > Aatami`.


## Omien olioiden järjestäminen

Jos yritämme järjestää oman `Contact`-luokan oliot `Collections.sort`-metodin avulla, saamme seuraavan virheilmoituksen:

> The method sort(List&lt;T&gt;) in the type Collections is not applicable for the arguments (List&lt;Contact&gt;)

Tämä johtuu siitä, että **luokkamme ei ole yhteensopiva `Comparable`-tyypin kanssa**. `Collections.sort`-metodi ei siis pysty vertailemaan olioitamme keskenään.

Onneksi on myös muita helppoja tapoja vertailla ja järjestää olioita kuin `Comparable` ja `compareTo`.


## Vaihtoehtoiset vertailuoperaatiot `Collections.sort`-metodilla

Merkkijonojen vertailu `compareTo`-metodilla ei huomioi luonnostaan oikein eri kirjainkokoja tai eri kielissä olevia paikallisia merkkejä (ä, ö, å):

```java
List<String> nesteet = Arrays.asList("maito", "Vesi", "ketsuppi", "bensa", "Limu");
Collections.sort(nesteet);

System.out.println(nesteet); // Väärin: [Limu, Vesi, bensa, ketsuppi, maito]
```

Onneksi `String`-luokasta löytyy tähän tarkoitukseen sopiva valmis `compareToIgnoreCase`-metodi. Kun haluamme käyttää tätä metodia oletusmetodin sijasta, voimme määritellä vertailussa käytettävän metodin `Collections.sort`-kutsun toisena parametrina:

```java
// kerrotaan, että vertailussa halutaan käyttää String-luokan compareToIgnoreCase-metodia:
Collections.sort(nesteet, String::compareToIgnoreCase);

System.out.println(nesteet); // oikea aakkosjärjestys: [bensa, ketsuppi, Limu, maito, Vesi]
```

Yllä `Collections.sort`-metodille annetaan toisena parametrina `String::compareToIgnoreCase`, joka on ns. **metodiviittaus**. Metodiviittauksessa esiintyy ensin luokan nimi, sitten kaksi kaksoispistettä `::` ja lopuksi metodin nimi. Huomaa, että metodia **ei suoriteta** omassa koodissa, vaan se annetaan parametrina. **Siksi metodin nimen jälkeen ei kirjoiteta sulkuja** `()`.

Metodiviittauksen avulla `sort` käyttää vertailemiseen antamaamme metodia oletuksena olevaa `compareTo`-metodia. Lue lisää osoitteesta: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html


## Listan järjesteleminen omilla luokilla (edistynyttä sisältöä 🌶️)

Vaikka oma `Contact`-luokkamme ei ollut sellaisenaan yhteensopiva `Collections.sort`-metodin kanssa, voimme ohittaa tämän ongelman antamalla listan lisäksi vertailuoperaation.

Tutustu Javan `Comparator.comparing`-metodiin, jonka avulla voit määritellä vertailijan kutsumaan mitä tahansa oman luokkasi metodia olioiden järjestämiseksi: https://www.baeldung.com/java-8-comparator-comparing. Tällä kurssilla sinun kannattaa lukea artikkelista kohta [3.1. Key Selector Variant](https://www.baeldung.com/java-8-comparator-comparing#1-key-selector-variant) ja sitä aikaisemmat, mutta ei välttämättä tätä kohtaa pidemmälle.

`Comparator.comparing`-metodille voidaan antaa metodiviittaus mihin tahansa metodiin, jolloin `sort` käyttää vertailussa juuri tuon metodin palauttamia arvoja. Voisimme sen avulla esimerkiksi järjestää merkkijonot pituusjärjestykseen vertailemalla merkkijonojen pituuksia, jotka selviävät `length()`-metodin avulla: `Comparator.comparing(String::length)`.

`Collections.sort` siis käyttää järjestämisessä `Comparator`-oliota, joka vertaa merkkijonojen pituuksia toisiinsa:

```java
// tehdään järjestely merkkijonojen length-metodin mukaan:
Collections.sort(nesteet, Comparator.comparing(String::length));

System.out.println(nesteet); // kasvava pituusjärjestys: [Limu, Vesi, bensa, maito, ketsuppi]
```

### Contact-olioiden järjesteleminen nimen mukaan (edistynyttä sisältöä 🌶️)

Toteuta nyt kurssin esimerkkiprojektiin `Contact`-olioiden järjestäminen aakkosjärjestykseen nimen mukaan siten, että `Comparator.comparing`-metodi saa parametrinaan metodiviittauksen `Contact`-luokan `getName`-metodiin. Älä turhaan huolehdi nimien kirjainkoosta, niiden huomioiminen tekee tehtävästä astetta haastavamman.


## Esimerkki kokonaisuudessaan

```java
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OlioidenJarjestaminen {

    public static void main(String[] args) {
        // Nimet epäjärjestyksessä:
        List<String> nimet = Arrays.asList("Marja-Liisa Kirvesniemi", "Kaisa Mäkäräinen", "Krista Pärmäkoski");

        Collections.sort(nimet); // järjestää nimet compareTo-metodin avulla
        System.out.println(nimet); // tulostaa [Kaisa Mäkäräinen, Krista Pärmäkoski, Marja-Liisa Kirvesniemi]

        List<Tuote> tuotteet = Arrays.asList(new Tuote("Maito"), new Tuote("Leipä"), new Tuote("Piimä"));
        // Collections.sort ei toimi Tuote-olioiden kanssa, koska Tuote ei ole yhteensopiva Comparable-tyypin kanssa!
        // Collections.sort(tuotteet); // => KÄÄNNÖSVIRHE


        // Merkkijonot puolestaan ovat yhteensopivia "Comparable"-tyypin kanssa ja niillä on compareTo-metodi:
        int tulos = "Marja-Liisa".compareTo("Kaisa Mäkäräinen");

        System.out.println(tulos); // tulostaa 2. Positiivinen luku tarkoittaa, että 'this' tulee toisen jälkeen.
        System.out.println("a".compareTo("b")); // -1, eli 'this' on ennen toista merkkijonoa
        System.out.println("x".compareTo("x")); // 0, eli ovat samassa kohdassa

        // Kokeillaan järjestellä lista eri kokoisia kirjaimia:
        List<String> kirjaimet = Arrays.asList("b", "A", "X", "w");

        Collections.sort(kirjaimet); // Järjestää compareTo-metodilla
        System.out.println(kirjaimet); // Kirjainkoko aiheuttaa bugeja: [A, X, b, w] => VÄÄRÄ JÄRJESTYS

        // Miten vertailut toimivat yllä?
        System.out.println("X".compareTo("b")); // -10, negatiivinen eli iso X tulee ennen pientä b:tä (virhe)
        System.out.println("X".compareToIgnoreCase("b")); // 22, positiivinen eli compareToIgnoreCase toimii!

        // Kerrotaan Collections.sort-metodille, että käytä compareToIgnoreCase:a
        Collections.sort(kirjaimet, String::compareToIgnoreCase); // String::compareToIgnoreCase on metodiviittaus

        // Nyt vertailu tehtiin kirjainkosta riippumatta:
        System.out.println(kirjaimet); // [A, b, w, X], eli vertailu toimi!

        // Miten järjestellään nimen pituuden mukaan?
        // Kerrotaan Comparator-oliolle, että vertailee length-metodin tulosten mukaan!
        Collections.sort(nimet, Comparator.comparing(String::length)); // String::length on metodiviittaus

        // Nimet on nyt järjestetty merkkijonon pituuden mukaan:
        System.out.println(nimet); // Kaisa Mäkäräinen, Krista Pärmäkoski, Marja-Liisa Kirvesniemi
    }
}
```

---

# Poikkeukset (exceptions)

Poikkeukset ovat ohjelman suorituksen aikana tapahtuvia tapahtumia, jotka aiheuttavat poikkeamia ohjelman normaaliin suoritusjärjestykseen. *Java-kääntäjän havaitsemat virheet ja varoitukset ovat aivan toinen asia.*

Olette törmänneet tällä kurssilla poikkeuksiin mm. seuraavanlaisissa tilanteissa:

* Käyttäjä syöttää väärin muotoillun luvun
* Taulukosta, listasta tai merkkijonosta haetaan arvoa virheellisellä indeksillä
* Metodia kutsutaan null-viittauksen kautta

Muita tyypillisiä tilanteita poikkeuksille ovat mm:

* Luettavaa tiedostoa ei löydy levyltä
* Kirjoitettavaan tiedostoon ei ole kirjoitusoikeutta
* Tietoliikenneyhteyden muodostaminen epäonnistuu


Ilman poikkeustenkäsittelyä ohjelma tyypillisesti "kaatuu", kun ohjelmassa tapahtuu jotain normaalista suorituksesta poikkeavaa, kuten yritetään käyttää listan olematonta indeksiä. Poikkeuksiin voidaan varautua, jolloin niiden sattuessa voidaan esimerkiksi yrittää uudelleen tai tulostaa virheilmoitus kaatamatta koko ohjelmaa.

https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html

## Esimerkki poikkeuksen aiheuttamasta virheilmoituksesta

```
Exception in thread "main" java.util.InputMismatchException
at java.util.Scanner.throwFor(Unknown Source)
at java.util.Scanner.next(Unknown Source)
at java.util.Scanner.nextInt(Unknown Source)
at java.util.Scanner.nextInt(Unknown Source)
at week1.ScannerExample.main(Example.java:11)
```

## Poikkeuksiin varautuminen

Poikkeuksiin voidaan varautua kirjoittamalla poikkeuksia aiheuttava koodi `try`-lohkon sisään. `try`-lohkon jälkeen kirjoitetaan `catch`-lohko, jonka sisällä oleva koodi suoritetaan, mikäli `try`-lohkon suorituksessa törmättiin poikkeukseen. 

Try/catch-rakenteen perusmuoto on siis seuraava:

```java
try {
  // Koodi, jossa mahdollisesti tapahtuu virhe
} catch (Exception e) {
  // Koodi, joka suoritetaan, mikäli virhe tapahtui
}
```

Mikäli haluamme koodissamme varautua tilanteeseen, jossa kokonaisluvun sijasta käyttäjä on syöttänyt muita merkkejä, voisimme tehdä seuraavan try/catch-rakenteen:

```java
try {
  int number = Integer.parseInt(syote);
  // ...
} catch (NumberFormatException e) {
  System.out.println("Syöte ei ole kokonaisluku!");
}
```

`catch`-lohkoja voi olla myös useita, jolloin ne käsittelevät eri tyyppisiä poikkeuksia.

## Eri tyyppisiin poikkeuksiin varautuminen

Virheen sattuessa `try`-lohkon sisällä lohkon suoritus keskeytyy välittömästi. Suoritus siirtyy sen `catch`-lohkon alkuun, joka on määritetty käsittelemään tämä poikkeustyyppi. Jos `try`-lohkossa sattuu poikkeus, jota vastaavaa `catch`-lohkoa ei ole, poikkeusta ei käsitellä lainkaan.

**Kysymys:** Millä syötteillä päädyt viereisessä esimerkkikoodissa oleviin catch-lohkoihin?

```java
String[] paivat = "ma ti ke to pe la su".split(" ");
Scanner lukija = new Scanner(System.in);

try {
    System.out.println("Valitse taulukon indeksi:");
    int valinta = lukija.nextInt();
    System.out.println(paivat[valinta]);

} catch (InputMismatchException e) {
    System.err.println("Epäkelpo kokonaisluku :(");

} catch (ArrayIndexOutOfBoundsException e) {
    System.err.println("Taulukossa ei ole vastaavaa arvoa :(");
}

lukija.close();
```

**Vastaukset:**

`InputMismatchException` syntyy silloin, kun `nextInt` lukee tietovirrasta jonkin muun arvon kuin kokonaisluvun.

`ArrayIndexOutOfBoundsException` syntyy silloin, kun annettu kokonaisluku on taulukon indeksien ulkopuolella.


## Try, throw ja catch

```java
try {
    numero = Integer.parseInt(text);
    // ...

} catch (NumberFormatException e) { // Nappaa vain NumberFormatException -poikkeukset!
    System.err.println("Epäkelpo kokonaisluku"); // Tulostaa tekstin virhe-streamiin: System.err

}
```

`Integer.parseInt` heittää `NumberFormatException`-poikkeuksen, mikäli se ei pysty lukemaan annetusta merkkijonosta numeroa. Kukin `catch`-lohko suoritetaan vain, jos `try`-lohkossa sattunut poikkeus on yhteensopiva kyseisessä `catch`-lohkossa olevan poikkeuksen kanssa.


## System.err

`System.err`:iä voidaan käyttää tulostamiseen kuten `System.out`:ia, mutta sitä käytetään ainoastaan virheiden tulostamiseen. Eclipsessä `System.err`-tietovirran tulosteet näytetään punaisella.

```java
// System.err
System.err.println("System.err tulostetaan punaisella");

// System.out
System.out.println("System.out tulostetaan mustalla");
```

Edistyneemmissä ohjelmissa eri tietovirrat voidaan myös ohjata eri sijainteihin, esimerkiksi `System.err` voidaan kirjoittaa tiedostoon myöhempää tutkimista varten ja `System.out` tulostaa ruudulle.


## Poikkeusolion käyttäminen

Poikkeukset ovat olioita, joilla on oliometodeja. Poikkeuksiin liittyy aina tiedot mm. siitä, minkälainen virhe on sattunut ja missä. Tapahtunut poikkeus on aina saatavilla `catch`-lohkon sisällä paikallisena muuttujana:

```java
Usein nimetty lyhyesti "e"
try {
    int number = Integer.parseInt(syote);
    // ...

} catch (NumberFormatException poikkeus) { // Catch-lohkon 'poikkeus' on muuttuja!

    // poikkeus.getMessage() palauttaa selkokielisen virheilmoituksen.
    System.err.println(poikkeus.getMessage()); 

}
```

## Finally-lohko

Try-catch –rakenteen lopuksi on mahdollista lisätä myös `finally`-lohko. `finally`-lohko suoritetaan aina lopuksi riippumatta siitä, tapahtuiko poikkeus vai ei. Koska `finally` lohko suoritetaan aina, se on hyvä paikka sijoittaa esimerkiksi resurssien sulkemisesta huolehtivat koodirivit:

```java
Scanner input = new Scanner(System.in);

try {
    System.out.println("Syötä kokonaisluku:");
    Integer.parseInt(input.nextLine());
    System.out.println("Kiitos");

} catch (NumberFormatException e) {
    System.err.println("Virheellinen luku");

} finally {
    // Tämä koodi suoritetaan aina, riippumatta siitä, tapahtuiko virheitä
    input.close();
}
```

## Koodaustehtävä

Kirjoita luokka `KysyUudestaan` ja lisää siihen main-metodi. Main-metodissa sinun tulee kysyä käyttäjältä kokonaislukutyyppistä syötettä. Jos käyttäjä antaa syötteen, joka ei ole kelvollinen kokonaisluku, ohjelmasi tulee kysyä syötettä uudelleen esimerkkisuorituksen mukaisesti. Kun käyttäjä syöttää kelvollisen kokonaisluvun, ohjelmasi tulee tulostaa annettu luku esimerkkisuorituksen mukaisesti.

```
Syötä kokonaisluku: sata
Virheellinen luku!

Syötä kokonaisluku: 100
Syötit luvun 100.
```

## Virheiden paikantaminen

### Suorituspino (stack)

Tietokoneen muistissa olevia aktiivisia metodikutsuja pidetään ns. pinossa. Ohjelmointiterminologiassa pino tarkoittaa tietorakennetta, johon uusin alkio lisätään aina ylimmäksi ja josta voidaan poistaa vain ylin alkio.

Kun metodista kutsutaan toista metodia, lisätään pinoon "kehys" kutsutun metodin suoritusta varten ja ohjelman suoritus siirtyy ylempään kehykseen. Kukin kehys pitää sisällään sitä vastaavan metodin paikalliset muuttujat ja tiedon siitä, millä rivillä kyseisen metodin suoritus on.

Kun metodi on suoritettu, poistetaan sitä varten luotu kehys ja suoritus palaa taas pinossa alaspäin siihen metodiin, josta suoritettua metodia kutsuttiin. Alempana pinossa olevat keskeneräiset metodien suoritukset odottavat, kunnes ylemmät pinokehykset on suoritettu.

### Pinon lukeminen (stack trace, pinovedos)
```
Exception in thread "main" java.util.InputMismatchException
at java.util.Scanner.throwFor(Unknown Source)
at java.util.Scanner.next(Unknown Source)
at java.util.Scanner.nextInt(Unknown Source)
at java.util.Scanner.nextInt(Unknown Source)
at week1.ScannerExample.main(Example.java:11)
```

Pinovedosta luetaan aina alhaalta ylöspäin. Yllä olevasta pinovedoksesta näet, että metodikutsut lähtivät liikkeelle alimmasta kehyksestä eli Example.java-tiedoston riviltä 11. Sieltä edettiin Javan Scanner-luokkaan, joka kutsui itse muutamaa omaa metodiaan. Lopulta aiheutui virhe `InputMismatchException`, joka näkyy pinovedoksessa ylimpänä.


## Pinon tulostaminen

Jos poikkeus päätyy pois omasta ohjelmastasi niin, ettei sitä napata missään ja ohjelma "kaatuu", tulostaa Java automaattisesti virheilmoituksen ja pinovedoksen (stack trace). Jos haluat oman ohjelmasi sisällä käsitellessäsi poikkeusta tulostaa suorituspinon, voit tehdä sen kutsumalla itse poikkeuksen `printStackTrace​()`-metodia:

```java
} catch (Exception poikkeus) {
    poikkeus.printStackTrace();
}
```

## Poikkeustyypit

### Virheet / Errors

Ohjelman suoritusta estävät ulkoiset virhetilanteet, esim. muistin loppuminen. Error-tyyppiset virheet ovat varsin harvinaisia.

### Ajonaikaiset virheet / Runtime exceptions

Ajonaikaiset virheet ovat tyypillisesti ohjelmointivirheistä aiheutuvia virhetilanteita, jotka usein voitaisiin välttää ilman varsinaista poikkeustenhallintaa.

Esimerkkejä ajonaikaisista virheistä ovat `NullPointerException` ja `ArrayIndexOutOfBoundsException`, jotka molemmat olisi vältettävissä tekemällä tarkastuksia ennen metodikutsuja. Virhe voidaan siis välttää tarkastamalla ensin, onko arvo `null` tai onko taulukon pituus riittävä

https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html

### Tarkastetut poikkeukset / checked exceptions

Virheet, joihin ohjelmassa tulee varautua ja joista tulee selvitä. Java-kääntäjä varmistaa, että kaikkiin tarkistettuihin poikkeuksiin on varauduttu. Tarkastettuja poikkeuksia käytetään esimerkiksi tiedostojen käsittelyssä, jossa virheet ovat erittäin tyypillisiä.

Jos metodi heittää tarkastetun poikkeuksen, täytyy sen otsikkoon lisätä `throws`-määre, esim:

```java
// https://docs.oracle.com/javase/10/docs/api/java/nio/file/Files.html
public static List<String> readAllLines​(Path path) throws IOException {
  // ...
}
```

Tällaista metodia kutsuvaan metodiin on aina pakko kirjoittaa joko try/catch –lohko tai kutsuvan metodin otsikkoon on myös lisättävä tieto samasta poikkeuksesta. Jos metodi ei käsittele poikkeusta, vaan päästää sen kutsuketjussa ylöspäin, kutsutaan sitä "kuplimiseksi". Poikkeus siis "kuplii" metodista toiseen.

### Poikkeusten dokumentoiminen

Jos metodi heittää ajonaikaisen poikkeuksen, `throws`-määre voidaan lisätä, mutta se ei ole pakollinen. Vaikka `throws` ei ole pakollinen, se toimii hyvänä dokumentaationa metodin toiminnasta, esim. `Integer`-luokassa:

```java
public static int parseInt​(String s) throws NumberFormatException {
    // ...
}
```

`NumberFormatException` ei ole tarkastettu poikkeus, joten sitä varten ei ole pakko lisätä poikkeuksenkäsittelyä, vaikka poikkeus onkin määritetty metodin otsikkoon.

## Poikkeusten "heittäminen"

Poikkeuksia voidaan heittää `throw`-käskyllä. Poikkeukset ovat olioita, joten heitettävä poikkeus täytyy luoda `new`-avainsanalla kuten muutkin oliot.

Kun poikkeus heitetään, siirtyy ohjelman suoritus välittömästi joko saman rakenteen `catch`-lohkoon tai suorituspinossa edelliseen metodiin.

```java
public void setNimi(String nimi) {

    // onko annettu nimi kelvollinen?
    if (nimi == null || nimi.isEmpty()) {
        // luodaan IllegalArgumentException-olio. Parametrina annetaan selkokielinen virheilmoitus:
        throw new IllegalArgumentException("Nimi ei saa olla tyhjä");
    }

    this.nimi = nimi; // tämä rivi suoritetaan vain, jos poikkeusta ei heitetty
}
```

Sijoitusoperaatiota `this.nimi = nimi` olisi voitu kirjoittaa `else`-lohkoon, mutta se olisi ollut turhaa, koska tälle riville ei koskaan päädytä jos `if`-ehto on tosi.

## Koodaustehtävä

Kirjoita ohjelma `ArvonTarkastus`, joka kysyy käyttäjältä yhden luvun. Ohjelmasi tulee luvun kysymisen jälkeen tarkastaa, että luku on vähintään 0 ja korkeintaan 23. Mikäli annettu luku X on sallittu, tulee ohjelmasi tulostaa teksti "Luku X on sallittu." ja ohjelman suorituksen pitää päättyä. 

Mikäli luku ei ole sallittu, tulee ohjelmasi heittää Javan valmis `IllegalArgumentException`-poikkeus, minkä jälkeen ohjelmasi "kaatuu". Voit antaa poikkeukselle konstruktoriparametrina minkä tahansa virheilmoituksen tai jättää merkkijonon antamatta. 

Huom: koska `IllegalArgumentException` sijaitsee `java.lang`-paketissa, sitä ei tarvitse erikseen ottaa käyttöön import-käskyllä. 

```
Syötä luku väliltä 0-23: -1
Exception in thread "main" java.lang.IllegalArgumentException
```

## Omat poikkeusluokat (edistynyttä sisältöä)

Voit luoda omia poikkeusluokkia aivan kuten muitakin luokkia. Jotta luokkasi toimii poikkeusluokkana, sen täytyy "periä" jokin Javan poikkeusluokka:

* `java.lang.Exception` tarkastettu poikkeus
* `java.lang.RuntimeException` ajonaikainen poikkeus

```java
public class InvalidEmailException extends RuntimeException {

    // Oman poikkeusluokan konstruktori:
    public InvalidEmailException(String email) {

        // Kutsutaan perityn luokan konstruktoria:
        super(email + " is not a valid email address!");
    }
}
```

### Edistynyttä sisältöä: Oman poikkeuksen heittäminen

`InvalidEmailException` heitetään, jos yhteystietoon ollaan asettamassa sähköpostiosoitteeksi tyhjää arvoa. Oikeassa sovelluksessa sähköpostiosoitteen muoto tarkastettaisiin esim. säännöllisellä lausekkeella.

```java
public class Yhteystieto {

    private String nimi;
    private String email;
    
    public void setEmail(String email) {
        if (email == null || "".equals(email)) {
            throw new InvalidEmailException(email);
        }
        this.email = email;
    }
}
```

---


# Tiedostojen lukeminen ja kirjoittaminen

Suurten tiedostojen käsittely ohjelmallisesti saattaa aiheuttaa merkittäviä suorituskykyhaasteita:

* kirjoittaessa tiedostoon yksittäiset kirjoitus- ja lukuoperaatiot ovat hitaita
* luettaessa tiedostosta koko sisällön lukeminen kerralla voi viedä paljon muistia.

Suorituskykyhaasteiden vuoksi tiedostoja käsitellään usein erilaisten puskurien avulla:

* puskuriin voidaan kirjoittaa dataa pienissäkin palasissa, mutta puskurin sisältö tallennetaan levylle isommissa erissä
* tiedostoa luetaan kerralla isompi erä puskuriin, josta siitä hyödynnetään esim. rivi kerrallaan.

Vastaavia haasteita ja ratkaisuja hyödynnetään myös mm. tietoliikenneyhteyksissä.


## java.nio.file.Files

Jos kirjoitettavaa tai luettavaa on kohtuullinen määrä, ei puskureita ole välttämätöntä käyttää. Tiedosto voidaan kirjoittaa kerralla esimerkiksi listasta merkkijonoja tai tiedosto voidaan lukea listaksi merkkijonoja. Yksinkertainen standardikirjaston luokka tiedostojen lukemiseen ja kirjoittamiseen on [java.nio.file.Files](https://docs.oracle.com/javase/9/docs/api/java/nio/file/Files.html).

Files-luokan käyttämiseksi tarvitset tyypillisesti seuraavat `import`-komennot:

```java
import java.nio.file.Files; // luokka tiedostojen käsittelyyn
import java.nio.file.Paths; // luokka tiedostojen polkujen määrittelemiseksi
import java.io.IOException; // poikkeusluokka virhetilanteita varten
import java.nio.charset.StandardCharsets; // merkistöluokka, jossa yleisimmät merkistöt
```

## Tiedoston lukeminen

Tiedostoja käsiteltäessä on aina mahdollisuus siihen, että lukeminen epäonnistuu. Tiedostonkäsittelyssä yleinen `IOException`-poikkeus on sen vuoksi ns. tarkastettu poikkeus, eli siihen täytyy aina varautua try/catch-rakenteella:

```java
Path tiedostonPolku = Paths.get("luettava_tiedosto.txt");

try {
    // readAllLines palauttaa kaikki rivit List<String>-listana. Tiedoston polun
    // lisäksi metodille kannattaa määritellä tiedoston merkistökoodaus (UTF-8):
    List<String> rivit = Files.readAllLines(tiedostonPolku, StandardCharsets.UTF_8);

    System.out.println("Tiedostosta luettiin rivit:");
    for (String rivi : rivit) {
        System.out.println(rivi);
    }

} catch (IOException e) {
    System.out.println(e);
}
```

## Tiedostojen kirjoittaminen

```java
Path tiedostonPolku = Paths.get("kirjoitettava_tiedosto.txt");

try {
    // Tiedostoon kirjoitetaan listalla olevat rivit:
    List<String> rivit = Arrays.asList("Rivi 1", "Rivi 2");

    // Files.write kirjoittaa listan sisällön riveittäin annettuun tiedostoon
    Files.write(tiedostonPolku, rivit, StandardCharsets.UTF_8); // muista merkistökoodaus!

    System.out.println("Tiedosto kirjoitettiin onnistuneesti!");

} catch (IOException e) {
    System.out.println(e);
}
```

Yllä olevan koodin suorituksen jälkeen tiedostojärjestelmässä on uusi tiedosto *"kirjoitettava_tiedosto.txt"* seuraavalla sisällöllä:

```
Rivi 1
Rivi 2
```

## CSV-tiedostot (comma-separated values))

Taulukkomuotoisen tiedon tallentamiseen yksinkertaisina tekstitiedostoina käytetään usein CSV-tiedostoja. 

> CSV on toteutukseltaan tekstitiedosto, jonka taulukkorakenteen eri kentät on eroteltu toisistaan pilkuilla ja rivinvaihdoilla. Jos jokin kenttä sisältää erikoismerkkejä, kyseinen kenttä ympäröidään pystysuorilla lainausmerkeillä ("). Ensimmäisellä rivillä voi olla kenttien selitykset samassa muodossa kuin mitä itse tiedot ovat.
>
> Wikipedia, https://fi.wikipedia.org/wiki/CSV

[Wikipedian esimerkissä](https://fi.wikipedia.org/wiki/CSV) autojen tiedot on esitetty tallennettuna seuraavassa CSV-muodossa:

```
Vuosi,Merkki,Malli,Pituus
1997,Ford,E350,"2,34"
2000,Mercury,Cougar,"2,38"
```

[Sama data](https://fi.wikipedia.org/wiki/CSV) on esitettävissä myös taulukkomuodossa:

Vuosi	| Merkki	| Malli     | Pituus
--------|-----------|-----------|-------
1997	| Ford      | E350      | 2,34
2000	| Mercury   | Cougar    | 2,38

Koska CSV-tiedostot on helposti koneluettavia ja -kirjoitettavia, hyvin monet ohjelmat tukevat niitä tiedon tallennusmuotonaan.

## Esimerkki CSV-tiedoston lukemisesta

Tämä `CarCsvReader`-luokka käyttää Javan `Files`-luokka yllä esitetyn csv-tiedoston lukemiseksi ja sen tietojen muuttamiseksi Java-olioiksi:

```java
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarCsvReader {

    public static void main(String[] args) {
        // Määritellään muuttuja try-lohkon ulkopuolella, jotta sitä voidaan käyttää
        // try-lohkon jälkeen:
        List<String> lines;

        try {
            Path csvPath = Paths.get("cars.csv");
            lines = Files.readAllLines(csvPath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Ensimmäisellä rivillä on tiedoston otsikot:
        String[] headers = lines.get(0).split(","); // "Vuosi", "Merkki" ja "Malli"

        // Muutetaan taulukko listaksi, jotta voimme käyttää 'indexOf'-metodia:
        List<String> headerList = Arrays.asList(headers);

        // Selvitetään sarakkeiden indeksit. Indeksejä ei kannata kovakoodata, koska
        // tiedoston rakenne saattaa vaihdella:
        int yearIndex = headerList.indexOf("Vuosi");
        int makeIndex = headerList.indexOf("Merkki");
        int modelIndex = headerList.indexOf("Malli");

        // Kerätään rivit Car-olioina tälle listalle:
        List<Car> cars = new ArrayList<>();

        // Hypätään otsikkorivi (0) yli ja aloitetaan riviltä 1:
        for (int i = 1; i < lines.size(); i++) {
            // Pilkotaan kukin rivi vuorollaan pilkkujen kohdista:
            String[] row = lines.get(i).split(",");

            // Luetaan riviltä halutut tiedot:
            String year = row[yearIndex];
            String make = row[makeIndex];
            String model = row[modelIndex];

            // Luodaan uusi Car-olio ja laitetaan talteen listalle:
            cars.add(new Car(year, make, model));
        }

        /*
         * Vaihtoehtoinen tapa listan läpikäyntiin ja arvojen tulostamiseen:
         * 
         * Listan forEach-metodille voidaan antaa operaatio, joka suoritetaan listan
         * jokaiselle arvolle. Tässä suoritettavaksi operaatioksi annetaan
         * metodiviittaus println-metodiin:
         */
        cars.forEach(System.out::println);
    }
}
```

Yllä oleva koodiesimerkki käyttää tätä `Car`-luokkaa auton tietojen mallintamiseen:

```java
public class Car {

    private String year;
    private String make;
    private String model;

    public Car(String year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car [year=" + year + ", make=" + make + ", model=" + model + "]";
    }
}
```

Suoritettaessa yllä oleva ohjelma tekee seuraavat tulosteet:

```
Car [year=1997, make=Ford, model=E350]
Car [year=2000, make=Mercury, model=Cougar]
```

## MerkistÃ◦t (merkistöt)

Eri kielialueilla on perinteisesti ollut tarve hyvin erilaisille kirjainmerkeille. Siksi niissä on kehitetty erilaisia merkistöjä, joissa tietyllä bittijonolla on keskenään eri merkitykset. Suosittelen vahvasti käyttämään tiedostojen tallentamisessa UTF-8 -nimistä merkistöä, joka sisältää merkittävän osan maailmalla käytetyistä merkeistä, kuten 請 ja ✌️. UTF-8:n suosio on noussut erittäin voimakkaasti ja myös tämä tiedosto on kirjoitettu UTF-8:lla:

![Share of web pages with different character encoding](https://upload.wikimedia.org/wikipedia/commons/c/c4/Utf8webgrowth.svg)

*By Chris55 - Own work, CC BY-SA 4.0, https://commons.wikimedia.org/w/index.php?curid=51421096*

Jotta ohjelmasi toimisi luotettavasti eri suoritusympäristöissä, kannattaa aina tiedostoja luettaessa ja kirjoitettaessa määritellä käytettävä merkistökoodaus:

```java
// Lukeminen:
Files.readAllLines(tiedostonPolku, StandardCharsets.UTF_8);

// Kirjoittaminen:
Files.write(tiedostonPolku, rivit, StandardCharsets.UTF_8);
```

### Koodaustehtävä

Kirjoita ohjelma `WordCount`, joka kysyy käyttäjältä tiedoston nimeä ja tulostaa kyseisessä tiedostossa olevien rivien, sanojen ja merkkien määrän. **Luettavan tiedoston on oltava Java-projektin juuressa.**

Riveksi lasketaan myös tyhjät rivit ja merkeiksi myös esimerkiksi välilyönnit. Sanojen laskemiseksi voit käyttää `String`-luokan `split`-metodia, jolla pilkot kunkin rivin välilyöntien kohdalta. Huomaa kuitenkin, että tyhjällä rivillä ei saa laskea yhtään sanaa, vaikka `split`-metodi palauttaakin yhden pituisen taulukon.

```
Anna tiedoston nimi: loremipsum.txt

Tiedostossa on:
2 riviä
8 sanaa
55 merkkiä
esimerkkisuoritus
```

Yllä olevassa esimerkkisuorituksessa luettiin seuraava tekstitiedosto *loremipsum.txt*:

```
Lorem ipsum dolor sit amet,
consectetur adipiscing elit.
```
*loremipsum.txt*


---

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/) -lisenssillä. 