package viikko3.listat.th; // Poista tämä rivi Viopessa!

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ohjelmaan on toteutettu valmiina pohja, joka lukee käyttäjältä lukuja
 * listalle. Syötteiden lukeminen päätetään kun käyttäjä syöttää luvun -1.
 * 
 * Lisää ohjelmaan toiminnallisuus, joka lukujen lukemisen jälkeen kysyy
 * käyttäjältä alkuindeksiä ja loppuindeksiä. Tämän jälkeen ohjelman tulostaa
 * listalla olevat luvut käyttäjän syöttämien indeksien välillä. Voit olettaa,
 * että käyttäjä syöttää indeksit, jotka löytyvät listalta.
 * 
 * Tämän tehtävän on laatinut Helsingin yliopiston Agile Education Research
 * -tutkimusryhmä. Tehtävä on lisensoitu on lisensoitu Creative Commons BY-NC-SA
 * 4.0 -lisenssillä ja se on julkaistu kurssilla https://ohjelmointi-19.mooc.fi.
 */
public class LuvutRajatullaAlueella {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        List<Integer> luvut = new ArrayList<Integer>();

        System.out.println("Syötä kokonaislukuja listalle (-1 lopettaa):");

        while (true) {
            int syote = lukija.nextInt();

            if (syote == -1) {
                break;
            } else {
                luvut.add(syote);
            }
        }

        System.out.println(); // Tyhjä rivi tulosteeseen

        System.out.print("Mistä? ");
        int mista = lukija.nextInt();

        System.out.print("Mihin? ");
        int mihin = lukija.nextInt();

        List<Integer> tulostettavat = luvut.subList(mista, mihin + 1);

        for (int luku : tulostettavat) {
            System.out.println(luku);
        }
    }
}
