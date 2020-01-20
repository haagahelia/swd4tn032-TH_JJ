# Vinkkejä Viope-virhetilanteisiin

## Could not find or load main class

> Error: Could not find or load main class TerveMaailma
> Caused by: java.lang.NoClassDefFoundError: viikko1/perusteet/th/TerveMaailma (wrong name: TerveMaailma)

Viope ei löydä ratkaisusi luokkaa (`class`). Tarkasta, että olet poistantu `package`-rivin ohjelmasi alusta Viopessa.

## "Virhe tulostuksessa"

> Virhe tulostuksessa: ohjelmasi tulosti "maailma", vaikka tulostuksen olisi pitänyt olla "maailma!"

Vertaile merkki kerrallaan oman ohjelmasi tulostetta esimerkkitulosteeseen. Onko välimerkeissä tai numeroissa eroja? Entä kirjoitusvirheitä?

## Virhe: ohjelmasi ei kääntynyt
Avaa Viopessa näkyville Java-kääntäjän antama virhe klikkaamalla "Kääntäjän viesti"-painiketta:

![](assets/viope_ohjelmasi_ei_kaantynyt.png)

Kääntäjän viesti kertoo missä kohdassa koodiasi virhe on.

