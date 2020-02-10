package viikko3.taulukot.th;

import java.util.Arrays;

public class TaulukotPistokoe {

    public static void main(String[] args) {
        int[] luvut = new int[20];
        luvut[0] = 7;

        System.out.println(luvut.length);

        luvut[1] = 8;

        // Taulukko luodaan täynnä "oletusarvoja". Int-taulukon oletus on 0.
        System.out.println(luvut[2]);

        System.out.println(Arrays.toString(luvut));

        // mitä käy luvulle 8, joka asetettiin viimeksi?
        luvut[1] = 10;

        System.out.println(Arrays.toString(luvut));
    }
}
