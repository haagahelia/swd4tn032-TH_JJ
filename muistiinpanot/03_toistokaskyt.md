# Toistokäskyt

## Vinkkejä Eclipsen käyttöön

* `Ctrl + välilyönti` näyttää ehdotuksia esim. olemassa olevien muuttujien ja luokkien nimistä
* `sysout (Ctrl + välilyönti)` täydentää `System.out.println();`
* `main (Ctrl + välilyönti)` ehdottaa `main`-metodin lisäämistä
* `Ctrl + 1` tarjoaa tapauskohtaisesti mahdollisuuksia mm. muuttujan nimen muuttamiseen, arvon sijoittamiseen muuttujaan yms.
* `Ctrl + shift + f` muotoilee koko tiedoston tai maalattujen rivien sisennykset, rivityksen ja muut muotoilut

## Tämän kerran aiheet

* Toistokäskyt
    * while
    * for


## Toistolauseet

Ehtolauseiden tavoin toistolauseilla voidaan vaikuttaa koodin suorituksen etenemiseen.
Toistolauseiden avulla tietyt koodirivit voidaan toistaa niin kauan kuin ehto toteutuu tai tarvittaessa "ikuisesti".

### While-toistokäsky

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

### For- ja while-toistolauseet

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

Tämä esimerkki on lainattu Helsingin Yliopiston ohjelmointikurssilta ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä. 
https://2017-ohjelmointi.github.io/part6/#section-35-for-toistolause 

Molemmat oheisista esimerkeistä tulostavat ruudulle luvut 0, 1 ja 2. Ainoa ero on se, että oikeanpuoleisessa esimerkissä muuttuja i on olemassa myös toistolauseen jälkeen.

## Toistolauseesta poistuminen eli `break`

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

---

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA 3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/) -lisenssillä. 