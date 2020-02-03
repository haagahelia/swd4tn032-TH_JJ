package viikko2.merkkijonot.th;

import java.util.Scanner;

public class NextIntNextLine {

    public static void main(String[] args) {
        String syote = "1234\nPorsche\n    423000,00  \nPunainen\n";
        Scanner lukija = new Scanner(syote);

        // lukee tietovirrasta numeron 1234
        int tuotenumero = lukija.nextInt();
        System.out.println(tuotenumero); // tulostaa 1234

        // Tietovirrassa on jäljellä:
        // "\nPorsche\n 423000,00 \nPunainen\n"

        // kun luemme seuraavan rivin, saamme TYHJÄN merkkijonon,
        // koska tietovirran seuraava merkki on rivinvaihto
        String nimi = lukija.nextLine();
        System.out.println(nimi); // tyhjä!

        // Tietovirrassa on jäljellä:
        // "Porsche\n 423000,00 \nPunainen"
        nimi = lukija.nextLine(); // Vasta nyt luetaan "Porsche\n"
        System.out.println(nimi);

        // Tietovirrassa on jäljellä:
        // "423000,00 \nPunainen"

        // Seuraavaksi luetaan desimaaliluku.
        // Vältetään ongelma lukemalla koko rivi, niin että \n ei jää seuraavaksi
        // merkiksi:
        String rivi = lukija.nextLine(); // "423000,00 "
        rivi = rivi.replace(",", ".");
        double hinta = Double.parseDouble(rivi);

        // Tietovirrassa on jäljellä:
        // "Punainen\n"
    }
}
