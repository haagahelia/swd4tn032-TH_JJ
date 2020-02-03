package viikko3.listat.th;

import java.util.ArrayList;
import java.util.List;

public class ListanKokoJaRajat {

    public static void main(String[] args) {
        List<Integer> numerot = new ArrayList<>();
        numerot.add(1000);
        numerot.add(700);

        System.out.println(numerot); // [1000, 700]

        int koko = numerot.size();
        System.out.println(koko);

        // Virhe: IndexOutOfBoundsException "Index 10 out of bounds for length 2"
        int olematon = numerot.get(10); // kaataa ohjelman
    }
}
