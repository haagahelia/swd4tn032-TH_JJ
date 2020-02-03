package viikko3.listat.th;

import java.util.ArrayList;
import java.util.List;

public class ListaltaHakeminenJaPoistaminen {

    public static void main(String[] args) {
        List<String> sanat = new ArrayList<>();
        sanat.add("Hello");
        sanat.add("World");
        sanat.add("!");

        // indeksit alkavat aina nollasta!
        String eka = sanat.get(0); // "Hello"
        String toka = sanat.get(1); // "World"
        String kolmas = sanat.get(2); // "!"

        // tulosta ensimmäinen
        System.out.println(eka);
        System.out.println(toka);
        System.out.println(kolmas);

        sanat.remove(0);
        sanat.remove("World");
        System.out.println(sanat);
    }
}
