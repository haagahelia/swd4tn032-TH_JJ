Tämä sivu on siirretty Wikiin: https://github.com/haagahelia/swd4tn032-TH_JJ/wiki

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

Kaikki listatyypit ovat yhteensopivia "List"-tyypin kanssa, joten muuttujan tyypiksi voidaan määritellä yleisesti `List`:

```java
// List<String> -muuttujaan voidaan sijoittaa niin LinkedList- kuin ArrayList-listoja:
List<String> yleinenMerkkijonoLista = new ArrayList<>();
```

Esimerkki kokonaisuudessaan:

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

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA 3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/) -lisenssillä. 