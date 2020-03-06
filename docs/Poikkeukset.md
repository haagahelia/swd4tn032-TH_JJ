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

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/) -lisenssillä. 