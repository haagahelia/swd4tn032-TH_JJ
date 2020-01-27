package viikko2.toisto.th;

//https://en.wikipedia.org/wiki/Fizz_buzz
public class FizzBuzzCondition {
    public static void main(String[] args) {
        int luku = 27;

        // jos luku jaollinen kolmella, tulosta "Fizz", muuten tulosta luku
        if (luku % 3 == 0) {
            System.out.println("Fizz");
        } else {
            System.out.println(luku);
        }
    }
}
