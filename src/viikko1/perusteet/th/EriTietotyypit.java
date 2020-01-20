package viikko1.perusteet.th;

import java.util.Scanner;

public class EriTietotyypit {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Syötä tekstiä:");
        String teksti = lukija.nextLine();
        System.out.println(teksti);

        // int on väliltä -2 147 483 648 – 2 147 483 647
        System.out.println("Syötä kokonaisluku:");
        int luku = lukija.nextInt();
        System.out.println(luku);

        System.out.println("Syötä tosi iso kokonaisluku:");
        long isoLuku = lukija.nextLong();
        System.out.println(isoLuku);

        System.out.println("Syötä liukuluku (desimaaliluku):");
        // kirjoita luku desimaalipilkulla (123,456)
        double liukuluku = lukija.nextDouble();
        // luku tulostuu pisteellä (123.456)
        System.out.println(liukuluku);

    }
}
