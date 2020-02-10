package viikko4.metodit.th;

/*
 *Harjoitellaan toisessa luokassa olevan metodin kutsumista!
 */
public class Nimirekisteri {

    public static void main(String[] args) {
        String keke = NimenLyhentaja.lyhenna("Keijo", "Rosberg");
        System.out.println(keke);

        String kimi = NimenLyhentaja.lyhenna("Kimi", "Räikkönen");
        System.out.println(kimi);

        // paluuarvoa voidaan käyttää myös suoraan seuraavan metodikutsun
        // parametriarvona:
        System.out.println(NimenLyhentaja.lyhenna("Mika", "Häkkinen"));
    }
}
