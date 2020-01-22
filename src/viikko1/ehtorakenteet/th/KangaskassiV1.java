package viikko1.ehtorakenteet.th;

/*
 * "Mustapohjaisen kassin saa tasolla 3 (3 000 pistettä). 
 * Tasolla 4 (6 000 pistettä) kassi on vihreä, tasolla 5 
 * (10 000 pistettä) sininen ja ylimmällä, kuudennella 
 * tasolla saa violetin kassin. Sen kantaja viestii 
 * ympärilleen, että on shoppaillut Stockmannilla yli 
 * 25 000 eurolla."
 * https://www.talouselama.fi/uutiset/stockmannin-arvokkain-kangaskassi-maksaa-25-000-euroa-tulossa-myos-nopeasti-vaihtuvia-etuja-ja-yllatyksia/7cc6e51d-ee3b-4ac0-abf9-af4602d8234a
 */
public class KangaskassiV1 {

    public static void main(String[] args) {
        // tässä versiossa ostosten määrä on kovakoodattu:
        int ostokseni = 3_100;

        // Javassa voidaan tehdä vertailuja vertailuoperaattoreilla:
        // https://github.com/haagahelia/swd4tn032-TH_JJ/blob/master/muistiinpanot/02_ehtolauseet.md#vertailuoperaattorit
        // Vertailu tuottaa aina totuusarvoja (boolean), eli true tai false:
        System.out.println(ostokseni >= 3_000); // true
        System.out.println(ostokseni >= 6_000); // false

        // totuusarvoja voidaan käyttää kuten muitakin arvoja (luvut, merkkijonot)
        boolean tosi = true;
        boolean epatosi = false;

        // lausekkeiden tuloksia voidaan asettaa muuttujiin (kuten esim. int-arvoja)
        boolean yliKolmeTuhatta = ostokseni >= 3_000;

        // totuusarvoja voidaan käyttää hyödyksi ehtolauseilla:
        if (yliKolmeTuhatta) {
            // tämä koodi suoritettan vain, jos if-lauseen ehto oli `true`
            System.out.println("Saat mustapohjaisen kassin");
        }
    }
}
