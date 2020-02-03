package viikko3.listat.th;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListanLuominenJaArvojenLisaaminen {

    public static void main(String[] args) {
        // Samaan muuttujaan voidaan laittaa mitä vain listoja:
        List<String> sanat = new ArrayList<>();
        sanat = new LinkedList<>();

        // listalle lisätään arvoja add-metodilla:
        sanat.add("eka"); // toisin kuin merkkijonot, metodit muuttavat listaa

        System.out.println(sanat); // [eka]

        // voidaan lisätä muitakin arvoja:
        sanat.add("toka");
        sanat.add("kolmas");

        System.out.println(sanat); // [eka, toka, kolmas]
    }
}
