package viikko7.tiedostot.th;

public class MerkitJaTavut {

    public static void main(String[] args) {
        // a-kirjain vie yhden tavun, ja merkkijonon pituus on yksi
        System.out.println("a".getBytes().length); // 1
        System.out.println("a".length()); // 1

        System.out.println("---");

        // ä-kirjain vie kaksi tavua, vaikka merkkijonon pituus on yksi:
        System.out.println("ä".getBytes().length); // 2
        System.out.println("ä".length()); // 1
    }
}
