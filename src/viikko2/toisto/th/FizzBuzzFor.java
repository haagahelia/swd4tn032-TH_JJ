package viikko2.toisto.th;

public class FizzBuzzFor {

    public static void main(String[] args) {
        // for (alustus; ehto; kasvatus)
        for (int luku = 1; luku <= 100; luku++) {
            if (luku % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(luku);
            }
        }
    }
}
