
# Kokoelmat

**Kokoelma on yksinkertaisesti olio, joka kokoaa alkioita yhteen.**

Olemme toistaiseksi käyttäneet listoja tai taulukoita, kun olemme halunneet käsitellä useita saman typpisiä asioita. Javassa on myös muita tietorakenteita tiedon varastointiin ja käsittelyyn. Javan Collections Framework sisältää mm:
* List *(esim. ArrayList)*
* Set
* Map
* Queue *(ei käsitellä)*
* Stack *(ei käsitellä)*

> "A collection — sometimes called a container — is simply an object that groups multiple elements into a single unit" 
>
> https://docs.oracle.com/javase/tutorial/collections/intro/index.html

**Tietorakenne** on tietojenkäsittelyssä esiintyvä termi, joka tarkoittaa tapaa tallentaa tietokoneen käsittelemää dataa siten, että datan käyttö olisi mahdollisimman tehokasta. --https://fi.wikipedia.org/wiki/Tietorakenne


## Set eli joukko


Toisin kuin listoilla:
* Joukko ei sisällä mitään alkiota kahdesti, eli kukin arvo voi olla setissä ainoastaan kerran
* Arvoilla ei ole indeksejä 
* Arvojen järjestys ei ole aina taattu

Set sisältää `add`, `contains`, `remove` ja `size` –metodit aivan kuten listatkin.

Kuten listoista, myös seteistä on useita toteutuksia (luokkia):
* `HashSet` Hajautustauluun perustuva Set, jossa alkioiden järjestys saattaa olla mikä tahansa
* `TreeSet` Puuhun perustuva Set, jossa alkiot ovat sisäisesti aina luonnollisessa järjestyksessä

Kokoelmien sisäisessä toteutuksessa on eroja, mutta ne niitä käytetään täysin samalla tavalla!


## Setin käyttö

```java
// Joukon tyyppi määritellään aivan kuten listankin:
Set<String> words = new HashSet<>();

// Joukkoon lisätään arvoja kuten listalle:
words.add("Foo");
words.add("Bar");

words.add("Bar"); // Samaa arvoa ei lisätä toista kertaa

// Size-metodi toimii aivan kuten listoillakin:
System.out.println(words.size()); // 2

// Arvojen läpikäynti aivan kuten listoilla:
for (String w : words) {
    System.out.println(w);
}
```

## Map eli hajautustaulu

Map mahdollistaa datan tallentamisen avainten ja arvojen pareina. Katso esim. JSON-tiedostomuotoa:

```json
{
  "etunimi": "Lindsey",
  "sukunimi": "Drillingcourt",
  "email": "ldrillingcourt0@so-net.ne.jp",
  "puhelin": "132-414-7730"
}
```

Usein tallennamme myös lukuisia samanlaisia kokoelmia avain-arvo-pareista listoiksi:

```json
[{
  "etunimi": "Lindsey",
  "sukunimi": "Drillingcourt",
  "email": "ldrillingcourt0@so-net.ne.jp",
  "puhelin": "132-414-7730"
}, {
  "etunimi": "Zilvia",
  "sukunimi": "Zamboniari",
  "email": "zzamboniari1@dell.com",
  "puhelin": "445-276-2785"
}, {
  "etunimi": "Moses",
  "sukunimi": "Fairhead",
  "email": null,
  "puhelin": "681-240-4656"
}, {
  "etunimi": "Devondra",
  "sukunimi": "Bridywater",
  "email": "cyberchimps.com",
  "puhelin": "306-422-3408"
}]
```
JSON-esimerkki generoitu työkalulla: https://mockaroo.com/

## Map-tietorakenteet

Map on eräs ohjelmoinnissa paljon käytetyistä tietorakenteista. Map:ia käytetään kun halutaan käsitellä tietoa avain-arvo –pareina. Avaimen perusteella voidaan lisätä, hakea ja poistaa avaimeen liittyvä arvo.

Siis toisin kuin listoissa, arvoja **ei käsitellä numeeristen indeksien avulla**, vaan **voimme määritellä avaimiksi esimerkiksi merkkijonoja**.

```java
import java.util.HashMap; // luokan alkuun
import java.util.Map; // luokan alkuun
```

```java
Hash<String, String> postinumerot = new HashMap<String, String>();

postinumerot.put("00710", "Helsinki");
postinumerot.put("90014", "Oulu");
postinumerot.put("33720", "Tampere");
postinumerot.put("33014", "Tampere"); // sama arvo voi olla useilla eri avaimilla!
```

Yllä oleva koodi muodostaa seuraavanlaisen tietorakenteen:

Avain       | Arvo
------------|-------
`00710`     | `Helsinki`
`90014`     | `Oulu`
`33720`     | `Tampere`
`33014`     | `Tampere`

Tämän esimerkki on lainattu Helsingin yliopiston Agile Education Research –tutkimusryhmän oppimateriaalista, joka on lisensoitu Creative Commons BY-NC-SA-lisenssillä. https://2017-ohjelmointi.github.io/part8/ 

## Mapin tyypin määrittely

Hajautustaulua luodessa tarvitaan kaksi tyyppiparametria:
1. avainmuuttujan tyyppi
2. lisättävän arvon tyyppi

Tyyppiparametrit määritellään kulmasulkeisiin pilkulla eroteltuna, esim: `<String, String>`.

```java
Map<String, String> tietovarasto = new HashMap<String, String>();

tietovarasto.put("avain", "arvo");

String merkkijono = tietovarasto.get("avain");

System.out.println(merkkijono); // tulostaa: arvo
```

Tämä esimerkki on lainattu Helsingin yliopiston Agile Education Research –tutkimusryhmän oppimateriaalista, joka on lisensoitu Creative Commons BY-NC-SA-lisenssillä. https://2017-ohjelmointi.github.io/part8/ 

Muuttujan tyyppinä voidaan käyttää joko yleisesti Map tai tarkemmin HashMap.

Kulmasuluissa ensimmäinen tyyppi on avaimen tyyppi, toinen tallennettavien arvojen tyyppi.

Avainten ja arvojen hakeminen Map:ista
```java
Map<String, Integer> opintopisteet = new HashMap<String, Integer>();

// Lisätään arvoja tietyille avaimille:
opintopisteet.put("swd4tn032", 5);
opintopisteet.put("swd4tn033", 5);

// Haetaan yksi arvo:
int pisteet = opintopisteet.get("swd4tn032");
System.out.println(pisteet); // 5

// Haetaan kaikki avaimet:
Set<String> avaimet = opintopisteet.keySet();
System.out.println(avaimet); // [swd4tn032, swd4tn033]
```

**Huom!** Samoin kuin listoilla ja set:eillä, Map:eihin voidaan tallentaa ainoastaan viittaustyyppisiä arvoja. Siksi `int`-tyypin sijaan käytetään `Integer`-tyyppiä.

## Mitä jos lisäämme arvon olemassa olevalle avaimelle? Entä jos haemme arvoa avaimella, jota Mapista ei löydy?

### Uuden arvon asettaminen
Hajautustaulussa on jokaista avainta kohden korkeintaan yksi arvo. Jos hajautustauluun lisätään uusi avain-arvo -pari, missä avain on jo aiemmin liittynyt toiseen hajautustauluun tallennettuun arvoon, vanha arvo katoaa hajautustaulusta.

```java
Map<String, String> numerot = new HashMap<>();
numerot.put("Uno", "Yksi");
numerot.put("Dos", "Zwei");
numerot.put("Uno", "Ein");

String kaannos = numerot.get("Uno");

System.out.println(kaannos);
```

Tämä esimerkki on lainattu Helsingin yliopiston Agile Education Research –tutkimusryhmän oppimateriaalista, joka on lisensoitu Creative Commons BY-NC-SA-lisenssillä. https://2017-ohjelmointi.github.io/part8/ 

### Arvojen poistaminen tai tarkastaminen (remove ja containsKey)

```java
HashMap<String, String> countries = new HashMap<>();

countries.put("Suomi", "Finland");
countries.put("Ruotsi", "Sweden");
countries.put("Norja", "Norway");

countries.containsKey("Ruotsi"); // true

countries.remove("Ruotsi");

countries.containsKey("Ruotsi"); // false
```

### Null-viittaukset mapilta

Jos mapista haetaan arvoa avaimella, jota ei löydy, palautuu tuloksena `null`-arvo. Mikäli `null`-arvon sijasta halutaan käyttää jotain toista arvoa oletusarvona, voidaan käyttää `getOrDefault`-metodia. Oheisessa esimerkissä ohjelma kaatuisi, mikäli oletusarvoa ei olisi annettu, koska `null`-arvoa ei voida sijoittaa `int`-tyyppiseen muuttujaan!

```java
Map<String, Integer> pistelaskuri = new HashMap<>();
pistelaskuri.put("Matti", 10);

// Muuttuja matti saa arvon 10:
int matti = pistelaskuri.getOrDefault("Matti", 0);

// Muuttuja teppo saa oletusarvon 0, avaimella ei arvoa:
int teppo = pistelaskuri.getOrDefault("Teppo", 0);

// Kaija-avaimelle ei löydy arvoa:
int kaija = pistelaskuri.get("Kaija"); // Palauttaa null-arvon, jota ei voida sijoittaa alkeistyyppiseen int-muuttujaan: ohjelma kaatuu
```

## Kokoelmat ja viittaukset

Katso opetusvideo https://video.haaga-helia.fi/media/HashMap%2C+useiden+arvojen+tallentaminen+samalle+avaimelle/0_1xnwercr 

## Syventävää tietoa: usean arvon tallentaminen samalle avaimelle

Map:issa voidaan säilyttää vain yhtä arvoa kutakin avainta kohden. **Säilytettävät arvot voivat kuitenkin olla muita kokoelmia.**

Kokoelmat ovat olioita siinä missä muutkin oliot. Map:issa voidaan siis säilyttää samalla avaimella useita arvoja, kun käsittelemmä Mapin sisällä listoja tai muita kokoelmia.


```java
Map<String, List<String>> maat = new HashMap<>();

List<String> fi = new ArrayList<String>();
fi.add("Helsinki");
fi.add("Espoo");
fi.add("Vantaa");

List<String> sv = new ArrayList<String>();
sv.add("Tukholma");
sv.add("Visby");

maat.put("Suomi", fi);
maat.put("Ruotsi", sv);

System.out.println(maat); // {Suomi=[Helsinki, Espoo, Vantaa], Ruotsi=[Tukholma, Visby]}

List<String> kaupungit = maat.get("Suomi");
```

## Syventävää tietoa: Map:in koko sisällön läpikäynti

Mapin sisältö voidaan käydä helposti läpi joko avainten, arvojen tai avain-arvo –parien osalta:
* `keySet()` palauttaa kaikki mapin avaimet
* `values()` palauttaa kaikki mapin arvot
* `entrySet()` palauttaa avaimet ja arvot pareina

Jokaisella `Entry`-oliolla on yksi avain ja arvo

```java
Set<String> avaimet = data.keySet();
Collection<Integer> arvot = data.values();
Set<Entry<String, Integer>> parit = data.entrySet();

// Käydään läpi kaikki avaimet:
for (String avain : avaimet) {
    System.out.println(avain);
}

// Käydään läpi kaikki arvot:
for (Integer arvo : arvot) {
    System.out.println(arvo);
}

// Käydään läpi kaikki avain-arvo -parit:
for (Entry<String, Integer> pari : parit) {
    System.out.println("Avain: " + pari.getKey());
    System.out.println("Arvo: " + pari.getValue());
}
```
