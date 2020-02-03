package viikko3.listat.th;

import java.util.ArrayList;
import java.util.List;

public class ListanLapikayntiFor {

    public static void main(String[] args) {
        List<Integer> numerot = new ArrayList<>();
        numerot.add(321);
        numerot.add(456);
        numerot.add(789);

        // käydään kaikki listan arvot läpi:
        for (int i = 0; i < numerot.size(); i++) {
            System.out.println(numerot.get(i));
        }
    }
}
