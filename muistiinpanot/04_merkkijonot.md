# Merkkijonot

## String-luokka

Kuten olemme aiemmin todenneet, merkkijonot ovat tyyppiä `String`. String on **luokka** ja yksittäiset merkkijonot ovat **olioita**. Vrt. esim Scanner ja DecimalFormat ovat luokkia, joista luomme olioita.

Merkkijonot luodaan muista olioista poiketen ilman `new`-avainsanaa, kirjoittamalla merkkijonon sisältö suoraan lainausmerkkeihin: "esimerkki"

Koska merkkijonot ovat "olioita", niihin liittyy seuraavat seikat:
* olioiden vertailu ei toimi odotetusti vertailuoperaattorilla `==`
* merkkijonoilla on paljon hyödyllisiä metodeja, joilla niitä voidaan käsitellä

## Olioiden vertailu

Olioita vertailtaessa yhtäsuuruusoperaatio == vertailee, onko kyseessä sama olio. Se ei siis vertaile olioiden sisältöä.
Samansisältöiset merkkijonot ovat siis samoja ainoastaan silloin, kun vertaillaan tiettyä merkkijono-oliota itseensä
Merkkijonoja vertaillaan siksi aina equals- ja equalsIgnoreCase –metodeilla, jotka vertailevat merkkijonojen sisältöjä
Molemmat vertailumetodit palauttavat aina totuusarvon (`true` tai `false`).

```java
String language = "JAVA";

if (language.equals("java")) {
     // tätä lohkoa ei suoriteta, koska
     // kirjainkoko ei täsmää
}

if (language.equalsIgnoreCase("java")) {
     // tämä lohko suoritetaan, koska 
     // equalsIgnoreCase-metodi 
     // ei välitä kirjainkoosta
}
```

## Yksittäiset kirjaimet
Javassa on erillinen `char`-tietotyyppi yksittäisiä merkkejä varten. Yksittäinen merkki aloitetaan ja lopetetaan heittomerkillä, esim. `'a'`. 

Merkkijonolta voidaan pyytää yksittäisiä merkkejä niiden indeksin perusteella. Tämä onnistuu metodilla charAt(int indeksi), joka saa parametrina halutun merkin indeksin merkkijonossa
Merkkijonojen indeksien laskeminen alkaa aina nollasta, eli esimerkiksi neljäs merkki on indeksissä kolme

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
```java

### Muuttumattomuus (immutability)

Merkkijonot ovat muuttumattomia, eli kerran luotua merkkijonoa ei voi muuttaa `String`-luokan metodit eivät koskaan muuta alkuperäistä merkkijonoa, vaan luovat siitä kopioita. Samaan muuttujaan voidaan toki sijoittaa uusi merkkijono:

```java
String text = "hello";
text.toUpperCase();
System.out.println(text);  // "hello" (ei muuttunut)

text = text.toUpperCase();
System.out.println(text);  // "HELLO"
```

### Merkkijonon osajono

Merkkijonosta halutaan usein lukea jokin tietty osa. Tämä onnistuu metodilla `substring`. `substring`-metodia voidaan käyttää kahdella tavalla: 
* yksiparametrisena palauttamaan merkkijonon loppuosa 
* kaksiparametrisena palauttamaan parametrien määrittelemä osajono merkkijonosta (muista, että indeksit alkavat aina 0:sta)

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

https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
Type                            | Description
--------------------------------| ------------
char charAt(int index)          | Returns the char value at the specified index.
boolean contains(String s)      | Returns true if and only if this string contains the specified sequence of char values.
int indexOf(String str)         | Returns the index within this string of the first occurrence of the specified substring.
int length()                    | Returns the length of this string.
boolean matches(String regex)   | Tells whether or not this string matches the given regular expression.
String replace(CharSequence target, CharSequence replacement) | Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.
String[] split(String regex)    | Splits this string around matches of the given regular expression.
String substring(int beginIndex)| Returns a string that is a substring of this string.
String substring(int beginIndex, int endIndex)| Returns a string that is a substring of this string.
String toLowerCase()            | Converts all of the characters in this String to lower case
String toUpperCase()            | Converts all of the characters in this String to upper case
String trim()                   | Returns a string whose value is this string, with any leading and trailing whitespace removed.

# Yleiset erikoismerkit merkkijonoissa

Kaikkia erikoismerkkejä ei voida esittää sellaisenaan merkkijonoissa. Esimerkiksi lainausmerkkiä ja rivinvaihtoa ei voida lisätä sellaisenaan merkkijonoon. Erikoismerkit täytyykin esittää erityisten kontrollimerkkien avulla.

https://docs.oracle.com/javase/tutorial/java/data/characters.html

Syntaksi        | Kuvaus
----------------| ------
\\t              | Insert a tab in the text at this point.
\\n              | Insert a newline in the text at this point.
\\"              | Insert a double quote character in the text at this point.
\\\\              | Insert a backslash character in the text at this point.

```java
System.out.println("Ensimmäinen rivi\nToinen rivi");
System.out.println("Tekstiä \"lainausmerkeissä\".");
```

```
Ensimmäinen rivi
Toinen rivi
Tekstiä "lainausmerkeissä".
```

# MerkistÃ◦t (merkistöt)

![Share of web pages with different character encoding](https://upload.wikimedia.org/wikipedia/commons/c/c4/Utf8webgrowth.svg)

By Chris55 - Own work, CC BY-SA 4.0, https://commons.wikimedia.org/w/index.php?curid=51421096

## Edistynyttä sisältöä: säännölliset lausekkeet, regular expressions / regex

Säännöllinen lauseke määrittelee joukon merkkijonoja tiiviissä muodossa. Säännöllisiä lausekkeita käytetään muun muassa merkkijonojen oikeellisuuden tarkistamiseen. Merkkijonojen oikeellisuuden tarkastaminen tapahtuu luomalla säännöllinen lauseke, joka määrittelee merkkijonot, jotka ovat oikein.

Oikeellisuuden tarkistus säännöllisten lausekkeiden avulla tapahtuu ensin sopivan säännöllisen lausekkeen määrittelyn. Tämän jälkeen käytetään `String`-luokan metodia `matches`, joka tarkistaa vastaako merkkijono parametrina annettua säännöllistä lauseketta.

Tämä esimerkki on lainattu Helsingin yliopiston Agile Education Research -tutkimusryhmän ohjelmointikurssilta ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä.  https://materiaalit.github.io/ohjelmointi-s17/part10/#section-19-saannolliset-lausekkeet 

#### `"teksti".matches(String regex); // edistynyttä sisältöä`

`matches`-metodi vertaa merkkijonoa annettuun säännölliseen lausekkeeseen ja palauttaa `true` tai `false` riippuen siitä, vastaako merkkijono lauseketta. Säännölliset lausekkeet (regular expression) ovat merkkijonoja, jotka muodostavat "kuvion" (pattern), jota vasten merkkijonoja verrataan:

Regex                   | Esimerkki   | Selitys
------------------------| ------------| --------
[0-9]+                  | 1234567890  | 1-n kpl numeroita
[0-9]{7}                | 1234567     | 7 kpl numeroita
[a-zåäö -]{4,10}        | abc-d       | Pieniä kirjaimia a-z, å, ä, ö, väli tai viiva. Yhteensä 4-10 kpl.
[A-Z]{1,3}-[0-9]{1,3}   | ABC-123     | 1-3 isoa kirjainta, viiva ja 1-3 numeroa 

#### Opiskelijanumeron tarkastaminen
Haaga-Helian opiskelijanumeron tapauksessa sopiva säännöllinen lauseke on `"a[0-9]{7}"` (a-kirjain ja 7 numeroa). Käyttäjän syöttämän opiskelijanumeron tarkistaminen käy seuraavasti:

```java
Scanner lukija = new Scanner(System.in);

System.out.print("Anna opiskelijanumero: ");
String numero = lukija.nextLine();

if (numero.matches("a[0-9]{7}")) {
    System.out.println("Muoto on oikea.");
} else {
    System.out.println("Muoto on väärä.");
}
```
Tämä esimerkki on sovellettu Helsingin yliopiston Agile Education Research -tutkimusryhmän ohjelmointikurssilta ja se on lisensoitu Creative Commons BY-NC-SA-lisenssillä. https://materiaalit.github.io/ohjelmointi-s17/part10/#section-19-saannolliset-lausekkeet 

#### Regex-sääntöjä

Katso: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html

Huom! Merkkijonoissa kenoviiva `\` on erikoismerkki, joten numerokuvion `\d` eteen tulee laittaa kontrollimerkiksi toinen kenoviiva: 
```java
"1234".matches("\\d+");
```

---

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA 3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/) -lisenssillä. 