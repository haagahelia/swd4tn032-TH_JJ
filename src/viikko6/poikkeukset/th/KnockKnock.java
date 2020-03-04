package viikko6.poikkeukset.th;

public class KnockKnock {

    public static void main(String[] args) {
        // System.out ja System.err ovat tietovirtoja, joiden tulostusten
        // ajoitus ei riipu toisistaan. Siksi seuraavat rivit tulostetaan
        // ajoittain väärässä järjestyksessä.
        //
        // https://en.wikipedia.org/wiki/Race_condition

        System.out.println("Knock knock");

        System.err.println("Who's there");

        System.out.println("Race condition");
    }
}
