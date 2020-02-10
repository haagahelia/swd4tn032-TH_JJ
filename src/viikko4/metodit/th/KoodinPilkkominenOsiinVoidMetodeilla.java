package viikko4.metodit.th;

/*
 * Katso visualizerissa: https://cscircles.cemc.uwaterloo.ca/java_visualize/#code=public+class+EkaOmaMetodi+%7B%0A%0A++++public+static+void+main(String%5B%5D+args)+%7B%0A++++++++//+M%C3%A4%C3%A4ritell%C3%A4%C3%A4n+metodi,+joka+tulostaa+tekstin+ja+laittaa+ymp%C3%A4rille+%22%23%23%22-merkit%0A++++++++tulostaOtsikko(%22Tammikuun+sadem%C3%A4%C3%A4r%C3%A4t%22)%3B%0A%0A++++++++System.out.println(%22Keskiarvo%3A+10%22)%3B%0A++++++++System.out.println(%22Suurin%3A+15%22)%3B%0A++++++++System.out.println(%22Pienin%3A+6%22)%3B%0A%0A++++++++System.out.println()%3B%0A%0A++++++++String+helmikuunOtsikko+%3D+%22Helmikuun+sadem%C3%A4%C3%A4r%C3%A4t%22%3B%0A%0A++++++++//+metodikutussa+voi+olla+ihan+eri+nimiset+muuttujat+kuin+metodin+otsikossa%0A++++++++tulostaOtsikko(helmikuunOtsikko)%3B%0A%0A++++++++System.out.println(%22Keskiarvo%3A+10%22)%3B%0A++++++++System.out.println(%22Suurin%3A+15%22)%3B%0A++++++++System.out.println(%22Pienin%3A+6%22)%3B%0A++++%7D%0A%0A++++private+static+void+tulostaOtsikko(String+otsikko)+%7B%0A++++++++//+T%C3%A4ss%C3%A4+metodissa+ei+ole+edes+p%C3%A4%C3%A4sy%C3%A4+main-metodin+muuttujiin!%0A++++++++System.out.println(%22%23%23+%22+%2B+otsikko+%2B+%22+%23%23%22)%3B%0A++++%7D%0A%7D&mode=display&curInstr=0
 */
public class KoodinPilkkominenOsiinVoidMetodeilla {

    public static void main(String[] args) {
        // Määritellään metodi, joka tulostaa tekstin ja laittaa ympärille "##"-merkit
        tulostaOtsikko("Tammikuun sademäärät");
        tulostaTilasto(10, 15, 6);

        System.out.println();

        // metodikutussa voi olla ihan eri nimiset muuttujat kuin metodin otsikossa
        String helmikuunOtsikko = "Helmikuun sademäärät";
        tulostaOtsikko(helmikuunOtsikko);
        tulostaTilasto(11, 18, 9);
    }

    private static void tulostaOtsikko(String otsikko) {
        // Tässä metodissa ei ole edes pääsyä main-metodin muuttujiin!
        System.out.println("## " + otsikko + " ##");
    }

    // Tälle metodille annetaan aina KOLME parametriarvoa
    private static void tulostaTilasto(int keskiarvo, int suurin, int pienin) {
        System.out.println("Keskiarvo: " + keskiarvo);
        System.out.println("Suurin: " + suurin);
        System.out.println("Pienin: " + pienin);
    }
}
