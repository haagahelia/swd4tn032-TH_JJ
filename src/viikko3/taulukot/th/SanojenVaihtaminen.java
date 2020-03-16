package viikko3.taulukot.th;

import java.util.Arrays;

public class SanojenVaihtaminen {

    public static void main(String[] args) {
        // tämä pitäisi kysyä Scannerilla:
        String syote = "Parempi pyy pivossa kuin kymmenen oksalla";

        // pilkotaan taulukoksi
        String[] sanat = syote.split(" ");

        // nämä pitäisi kysyä käyttäjältä:
        // vaihdettavat indeksit:
        int vaihda1 = 2;
        int vaihda2 = 5;

        String[] kopio = Arrays.copyOf(sanat, sanat.length);

        // asetetaan ekan sanan paikalle X ja tokan paikalle Y:
        kopio[vaihda1] = sanat[vaihda2]; // sana indeksistä vaihda2
        kopio[vaihda2] = sanat[vaihda1]; // sana indeksistä vaihda1

        String lopputulos = String.join(" ", kopio);
        System.out.println(lopputulos);
    }
}
