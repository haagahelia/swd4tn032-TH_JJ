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


Operaattori | Käyttötarkoitus
------------|----------------
+           | Yhteenlasku (myös merkkijonojen yhdistäminen)
-           | Vähennyslasku
*           | Kertolasku
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


(1.0 * 9) / 2 = 4.5
```

Jos vähintään toinen luvuista on liukuluku, tulee myös tuloksesta liukuluku, jolloin katkaisua ei tapahdu. Kokonaisluvusta saadaan liukuluku helposti esim. kertomalla se luvulla 1.0.

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

Tehtävä on lainattu [Helsingin Yliopiston ohjelmointikurssilta](https://2017-ohjelmointi.github.io/part1/#exercise-8-kolmen-luvun-keskiarvo) ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä.

## Syötteen lukeminen näppäimistöltä

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

System.out.println("Kirjoita sana: ");
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

    Syötä etunimi: Teppo
    Hei Teppo!


# Totuusarvot ja ehtolauseet

## If-ehtolause sekä boolean-arvot true ja false

Koodia voidaan suorittaa ehdollisesti, kun tietty ehto toteutuu:
Tarkastettava ehto kirjoitetaan if-avainsanan jälkeen sulkujen sisään

```java
boolean onPaiva = true;

if (onPaiva) {
    // tähän lohkoon kirjoitettu  koodi suoritetaan 
    // vain, jos ehto on tosi
    System.out.println("Hyvää päivää!");
}

// jos ehto oli epätosi, siirtyy suoritus suoraan tänne
```

If-lauseen sulkujen sisällä voi olla myös lauseke, joka evaluoidaan, ja päätös tehdään saadun tuloksen mukaan. Kun tämä lauseke evaluoidaan, saadaan tulokseksi arvo `true`:

```java
int kello = 16;

if (kello < 18) {
    // tähän lohkoon kirjoitettu koodi suoritetaan, 
    // jos kello-muuttujan arvo on alle 18
    System.out.println("Hyvää päivää!");
}
```


Arvojen vertailu ja loogiset operaatiot:
* == 	yhtä suuri kuin
* != 	eri suuruinen kuin
* &gt; 	suurempi kuin
* &gt;=	suurempi tai yhtä suuri kuin
* &lt;	pienempi kuin
* &lt;=	pienempi tai yhtä suuri kuin


* &&	ja
* ||	tai
* !	negaatio (kääntää totuusarvon) 
  * `!false == true`
  * `!true == false`

https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html

## Totuustaulut

### Ja (`&&`)
```
| a     | b     | && b   |
|-------|-------|--------|
| true  | true  | true   |
| True  | false | false  |
| false | true  | false  |
| false | false | false  |
```

### Tai (`||`)
```
| a     | b     | a || b   |
|-------|-------|----------|
| true  | true  | true     |
| true  | false | true     |
| false | true  | true     |
| false | false | false    |
```

## Loogisten operaatioiden käyttäminen

Ehtolauseessa voidaan evaluoida myös monimutkaisempia lausekkeita:

```java
int kello = 16;

if (kello >= 10 && kello < 18) {
    // tähän lohkoon kirjoitettu koodi suoritetaan vain,
    // jos kello-muuttujan arvo on suurempi tai 
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
    System.out.println("Hyvää yötä!");
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

## Koodaustehtävä
Tee ohjelma `Ylinopeus.java`, joka kysyy käyttäjältä kokonaisluvun ja tulostaa merkkijonon "Ylinopeussakko!" jos luku on suurempi kuin 120.

Jos annettu luku on 120 tai vähemmän, ohjelmasi ei tule tulostaa mitään.

Tehtävä on lainattu Helsingin Yliopiston ohjelmointikurssilta osoitteesta https://2017-ohjelmointi.github.io/part1/#exercise-16-ylinopeussakko  ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä.

    Kerro nopeus: 135 
    Ylinopeussakko!

## Koodaustehtävä
Kirjoita luokka `Tervehdys` ja siihen `main`-metodi, joka tulostaa kellonajasta riippuen erilaisen tervehdyksen.

Palauta lopuksi kirjoittamasi koodi Viopeen (kappale 2, tehtävä 2)


Aikaväli    | Tervehdys
---------   |----------
7:00-9:59   | Hyvää huomenta!
10:00-16:59 | Hyvää päivää!
17:00-21:59 | Hyvää iltaa!
22:00-6:59  | Hyvää yötä!

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
DecimalFormat kaksiDesimaalia = new DecimalFormat("0.00");

String tulos = kaksiDesimaalia.format(123.456789);

System.out.println(tulos);
```

1. Määritellään toivottu muoto
2. Laitetaan luotu olio talteen uuteen muuttujaan
3. Format-metodi muotoilee annetun liukuluvun
4. Otetaan muotoiltu luku talteen uuteen muuttujaan
5. Ruudulle tulostetaan lopulta luku 123,46

# Viope-harjoitukset

Rekisteröitykää viimeistään nyt Viopeen ja liittykää kurssille. Harjoitukset lähtevät käyntiin heti, ensimmäisiä tehtäviä tehtiin jo tällä tunnilla.

Kun kohtaatte ongelmia tehtävissä, pyytäkää apua ja vinkkejä kurssin Teams-työtilan keskustelualueella!

Muistathan, että teknisistä syistä johtuen Viopeen palautettavista ratkaistuista täytyy poistaa mahdolliset package -lauseet luokan yläpuolelta
