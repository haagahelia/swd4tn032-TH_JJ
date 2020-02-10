package viikko3.taulukot.th;

import java.util.ArrayList;
import java.util.List;

public class TaulukotPistokoeListoina {

    public static void main(String[] args) {
        List<Integer> luvut = new ArrayList<Integer>();
        luvut.add(7);

        System.out.println(luvut.size());

        luvut.add(8);

        System.out.println(luvut);

        // mitä käy luvulle 8, joka asetettiin viimeksi?
        luvut.add(1, 10);
        luvut.add(1, 10);

        System.out.println(luvut);
    }
}
