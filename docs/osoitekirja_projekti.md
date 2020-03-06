# AddressBook ja Contact -esimerkkiohjelma

https://github.com/haagahelia/swd4tn032-TH_JJ/tree/master/src/viikko5/oliot/addressbook/th

## Data

**Contact**

* name (`String`)
* email (`String`)
* phone (`String`)

## Ominaisuudet

**AddressBook**

* search(String keyword)
* add(Contact newContact)
* remove(String keyword)
* list() // palauttaa merkkijonon koko sisällöstä
* (load)
* (save)

## Lisäominaisuudet 2.3.2020

* Osoitekirjan muodostaminen *järkeväksi* merkkijonoksi
* Osoitekirjan tulostaminen nimien mukaisessa aakkosjärjestyksessä
* Yhteystietojen vertailu (`Contact.equals`)
* Osoitekirjaan lisääminen vain, jos sama yhteystieto ei ole vielä osoitekirjassa (`List.contains`)


