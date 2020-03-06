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