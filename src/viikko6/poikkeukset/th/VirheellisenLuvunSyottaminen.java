package viikko6.poikkeukset.th;

import java.util.Scanner;

public class VirheellisenLuvunSyottaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int luku = 0;
        boolean syoteOk = false;

        while (syoteOk == false) {
            System.out.print("Syötä kokonaisluku: ");

            try {
                String syote = lukija.nextLine(); // lukee rivin kokonaan sisällöstä riippumatta
                luku = Integer.parseInt(syote);

                // tänne päästään ainoastaan, jos syötetty luku ei aiheuttanut poikkeusta
                syoteOk = true;
            } catch (NumberFormatException poikkeus) {
                System.out.println("Virheellinen luku!");
            }
            System.out.println();
        }

        System.out.println("Syötit luvun " + luku + ".");
    }
}
