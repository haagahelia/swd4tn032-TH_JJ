package viikko4.metodit.th;

import java.util.ArrayList;
import java.util.List;

public class OpintopisteidenSummaaja {

    public static void main(String[] args) {
        List<Integer> opintopisteet = new ArrayList<Integer>();
        opintopisteet.add(5);
        opintopisteet.add(5);
        opintopisteet.add(5);
        opintopisteet.add(5);
        opintopisteet.add(10);

        int pisteitaYhteensa = Numerot.summa(opintopisteet);
        System.out.println(pisteitaYhteensa);
    }
}
