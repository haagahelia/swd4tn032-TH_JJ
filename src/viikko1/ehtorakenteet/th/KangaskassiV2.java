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
public class KangaskassiV2 {

    public static void main(String[] args) {
        // tässä versiossa ostosten määrä on kovakoodattu:
        int ostokseni = 2_999;

        // ehtolauseissa voidaan myös evaluoida lausekkeita:
        if (ostokseni >= 3_000) {
            // tämä koodi suoritetaan vain, jos if-lauseen ehto oli `true`
            System.out.println("Saat mustapohjaisen kassin");
        } else {
            // tämä koodi suoritetaan, mikäli ehdon tulos oli `false`
            System.out.println("Et saa kassia");
        }
    }
}
