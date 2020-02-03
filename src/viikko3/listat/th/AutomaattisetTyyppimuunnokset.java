package viikko3.listat.th;

import java.util.ArrayList;
import java.util.List;

public class AutomaattisetTyyppimuunnokset {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();

        // Listalla lisätään aina Integer-arvoja:
        lista.add(Integer.valueOf(10));

        // Jos lisäät int-arvon, Java tekee muunnoksen automaattisesti:
        lista.add(10);

        // Listan oikea tyyppi on "Integer":
        Integer a = lista.get(0);

        // Listalta voidaan hakea myös "int"-tyyppisiä arvoja, tällöin Java
        // tekee automaattisen tyyppimuunnoksen:
        int b = lista.get(0);
    }
}
