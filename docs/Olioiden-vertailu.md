## Olioiden vertaileminen

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

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/) -lisenssillä. 