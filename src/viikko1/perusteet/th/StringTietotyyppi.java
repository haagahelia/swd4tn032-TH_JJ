package viikko1.perusteet.th;

public class StringTietotyyppi {

    public static void main(String[] args) {
        System.out.println("Tämä on merkkijono");

        String teksti = "Tämä on myös merkkijono";
        teksti = "Tämä merkkijono korvaa aikaisemman arvon.";

        System.out.println(teksti);

        String s1 = "Merkkijonoja voidaan yhdistellä";
        String s2 = "+ merkillä";

        // merkkijonot tulostuvat kiinni toisissaan
        System.out.println(s1 + s2);

        // merkkijonojen välissä on välilyönti omana merkkijonona
        System.out.println(s1 + " " + s2);

        // merkkijonoon voidaan yhdistää kokonaisluku
        System.out.println("Pinta-ala on: " + 2 * 6);
        // (laskusäännöissä * tulee ennen +:aa)

        System.out.println("Summa on " + 2 + 6); // Summa on 26

        System.out.println("Voimme käyttää sulkuja: " + (2 + 6));
    }
}
