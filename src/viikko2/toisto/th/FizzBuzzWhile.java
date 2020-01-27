package viikko2.toisto.th;

// https://en.wikipedia.org/wiki/Fizz_buzz
public class FizzBuzzWhile {

    public static void main(String[] args) {

        // alustus
        int luku = 1;

        // ehto
        while (luku <= 100) {
            // TODO: lisää logiikka Buzz ja FizzBuzz -tulosteille
            if (luku % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(luku);
            }

            // kasvatus
            luku = luku + 1; // sama kuin luku++;
        }

        // muuttujaan jää ensimmäinen arvo, joka EI TOTEUTA ehtoa
        System.out.println("Luku lopussa: " + luku);
    }
}
