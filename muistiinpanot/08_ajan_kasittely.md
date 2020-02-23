Tämä sivu on siirretty Wikiin: https://github.com/haagahelia/swd4tn032-TH_JJ/wiki

#  Ajan käsittely Javassa

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

---

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA 3.0](https://creativecommons.org/licenses/by-nc-sa/3.0/) -lisenssillä. 