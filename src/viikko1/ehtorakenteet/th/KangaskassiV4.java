package viikko1.ehtorakenteet.th;

import java.util.Scanner;

/*
 * "Mustapohjaisen kassin saa tasolla 3 (3 000 pistettä). 
 * Tasolla 4 (6 000 pistettä) kassi on vihreä, tasolla 5 
 * (10 000 pistettä) sininen ja ylimmällä, kuudennella 
 * tasolla saa violetin kassin. Sen kantaja viestii 
 * ympärilleen, että on shoppaillut Stockmannilla yli 
 * 25 000 eurolla."
 * https://www.talouselama.fi/uutiset/stockmannin-arvokkain-kangaskassi-maksaa-25-000-euroa-tulossa-myos-nopeasti-vaihtuvia-etuja-ja-yllatyksia/7cc6e51d-ee3b-4ac0-abf9-af4602d8234a
 */
public class KangaskassiV4 {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Anna ostostesi kokonaisarvo: ");
        System.out.print("> ");

        int ostokseni = lukija.nextInt();

        if (ostokseni >= 25_000) {
            System.out.println("Saat violetin kassin");
        } else if (ostokseni >= 10_000) {
            // tämä koodi suoritetaan jos eka ehto oli epätosi ja toinen ehto oli tosi
            System.out.println("Saat sinipohjaisen kassin");
        } else if (ostokseni >= 6_000) {
            System.out.println("Saat vihreäpohjaisen kassin");
        } else if (ostokseni >= 3_000) {
            System.out.println("Saat mustapohjaisen kassin");
        } else {
            // tänne päädytään, jos mikään aikaisemmista ei ollut tosi
            System.out.println("Et saa kassia");
        }

        lukija.close(); // hyvien tapojen mukaista, välttää "muistivuotoja"
    }
}
