package viikko8.harjoituskoe.th;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LintuOhjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        List<Lintu> linnut = new ArrayList<>();

        while (true) {
            System.out.println("1 = Lisää uusi merkintä");
            System.out.println("2 = Näytä kaikki merkinnät");
            System.out.println("0 = Lopeta");

            System.out.print("Anna valintasi (0-2): ");
            int valinta = Integer.parseInt(lukija.nextLine());

            if (valinta == 0) {
                break;
            } else if (valinta == 1) {
                System.out.print("Anna laji: ");
                String laji = lukija.nextLine();
                boolean loytyi = false;

                // Tarkastetaan, löytyykö kyseinen laji jo listalta:
                for (Lintu lintu : linnut) {
                    if (laji.equals(lintu.getLaji())) {
                        // Löytyi! Kasvatetaan määrää:
                        lintu.lisaaHavainto();
                        loytyi = true;
                    }
                }

                if (loytyi == false) {
                    // Jos ei löytynyt yllä, luodaan uusi Lintu-olio:
                    Lintu havainto = new Lintu(laji);
                    linnut.add(havainto);
                }

            } else if (valinta == 2) {
                for (Lintu lintu : linnut) {
                    System.out.println("Laji: " + lintu.getLaji());
                    System.out.println("Maara: " + lintu.getMaara());
                    System.out.println();
                }
            }
            System.out.println(); // tulostaa tyhjän rivin
        }
    }
}

class Lintu {
    private String laji;
    private int maara;

    public Lintu(String laji) {
        this.laji = laji;
        this.maara = 1;
    }

    public String getLaji() {
        return this.laji;
    }

    public int getMaara() {
        return this.maara;
    }

    // metodi, jolla kasvatetaan havaintojen määrää
    public void lisaaHavainto() {
        this.maara = this.maara + 1;
    }

    @Override
    public String toString() {
        return this.laji + " (" + this.maara + ")";
    }
}