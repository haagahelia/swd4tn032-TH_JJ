package viikko3.listat.th;

public class Merkkijonokertaus {

    public static void main(String[] args) {
        String lento = "zz105";

        boolean finnairinLento = lento.startsWith("ay");
        // Kolme eri tapaa tarkastaa sama ehto:

        if (finnairinLento == false) {
            System.out.println("Ei ole finnairin lento");
        }

        if (finnairinLento != true) {
            System.out.println("Ei ole finnairin lento");
        }

        // negaatio: muutta true-arvon falseksi ja toisin päin
        if (!finnairinLento) {
            System.out.println("Ei ole finnairin lento");
        }
    }
}
