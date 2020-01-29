package viikko2.merkkijonot.th;

public class MerkkijonojenMuuttumattomuus {

    public static void main(String[] args) {
        String hello = "Hello";

        hello.toUpperCase(); // merkkijonojen metodit eivät koskaan muuta itse merkkijonoa

        System.out.println(hello); // tulostuu alkuperäisessä kirjainkoossa

        hello = hello.toUpperCase(); // metodit palauttavat aina uusia merkkijonoja!

        System.out.println(hello); // tulostaa muutetun "kopion" alkuperäisestä

        System.out.println(hello.toLowerCase()); // tulostaa tekstin pienellä, muuttuja ei päivity

        System.out.println(hello); // muuttujassa on edelleen teksti isolla
    }
}
