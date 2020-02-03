package viikko3.listat.th;

import java.util.ArrayList;
import java.util.List;

public class ListanLapikayntiForEach {

    public static void main(String[] args) {
        List<Integer> numerot = new ArrayList<>();
        numerot.add(321);
        numerot.add(456);
        numerot.add(789);

        // käydään kaikki listan arvot läpi:
        for (Integer arvo : numerot) {
            System.out.println(arvo);
        }
    }
}
