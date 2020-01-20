package viikko1.perusteet.th;

public class TerveMaailmaPrint {

    public static void main(String[] args) {
        // println tekee rivinvaihdon aina tulosteen loppuun:
        System.out.println("Terve");
        System.out.println("maailma!");

        // print ei tee rivinvaihtoa:
        System.out.print("Terve ");
        System.out.print("maailma!");
    }
}
