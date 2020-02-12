package viikko4.metodit.th;

import java.util.List;

public class Numerot {

    public static int summa(List<Integer> arvot) {
        int summa = 0;
        for (int luku : arvot) {
            summa += luku; // sama kuin: summa = summa + luku;
        }
        return summa; // palauttaa numeron metodin kutsujalle
    }
}
