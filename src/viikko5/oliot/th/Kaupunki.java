package viikko5.oliot.th;

public class Kaupunki {

    // Jokaiselle oliolle yksilölliset *oliomuuttujat*. Oliomuuttujien arvot
    // säilyvät metodikutsujen välissä, toisin kuin paikallisten muuttujien arvot.
    private String nimi;
    private int vakiluku;

    // Konstruktori. Konstruktoria kutsutaan aina uutta oliota luotaessa!
    public Kaupunki(String nimi, int vakiluku) {

        // oliomuuttujia käytetään luokan sisällä `this`-viittauksen kautta:
        this.nimi = nimi;
        this.vakiluku = vakiluku;
    }
}
