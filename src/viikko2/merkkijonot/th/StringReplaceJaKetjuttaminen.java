package viikko2.merkkijonot.th;

public class StringReplaceJaKetjuttaminen {

    public static void main(String[] args) {
        // seuraava replace kutsutaan aina edellisen palauttamalle tulokselle
        // (ketjuttaminen)
        String numerot = "1 2 3 4".replace("1", "one").replace("2", "two").replace("3", "three").replace("4", "four");

        System.out.println(numerot);
    }
}
