package viikko1.perusteet.th;

/**
 * Luku halutaan pyöristää ylöspäin, mutta jostain syystä se pyöristyy alaspäin:
 * 
 * int aikuiset = 40; double pullot = Math.ceil(aikuiset / 7); // tulos oli 5,
 * vaikka piti olla 6
 */
public class JakolaskunCeil {

    public static void main(String[] args) {
        int aikuiset = 40;

        // aikuiset / 7 lasketaan ensin, josta saadaan tulokseksi kokonaisluku
        // tuloksen desimaaliosa katkeaa pois, ennen kun se annetaan Math.ceil-metodille
        int pullot = (int) Math.ceil(aikuiset / 7);
        System.out.println(pullot);

        System.out.println("Versio 2:");
        int jakolasku = aikuiset / 7;
        System.out.println("Jakolaskun tulos: " + jakolasku);
        pullot = (int) Math.ceil(jakolasku);
        System.out.println(pullot);

        // kun operaation toinen osapuoli on double, tulee tuloksesta myös double
        double pyoristamaton = aikuiset / 7.0;
        System.out.println("Pyöristämätön: " + pyoristamaton);
        pullot = (int) Math.ceil(pyoristamaton);
        System.out.println(pullot);
    }
}
