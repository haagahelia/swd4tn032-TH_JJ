package viikko2.toisto.th;

public class Alkuluku {

    public static void main(String[] args) {
        // kiintoarvo, tätä ei muuteta!
        int luku = 93;

        // "yksisuuntainen lippu"
        boolean onAlkuluku = true;

        // askeltaja: 2, 3, 4, 5, 6, ...., luku - 1
        for (int jakaja = 2; jakaja < luku; jakaja++) {
            // jos jako menee tasan, ei ole alkuluku
            if (luku % jakaja == 0) {
                onAlkuluku = false;
            }
        }

        if (onAlkuluku) {
            System.out.println("Luku " + luku + " on alkuluku");
        } else {
            System.out.println("Luku " + luku + " ei ole alkuluku");
        }
    }
}
