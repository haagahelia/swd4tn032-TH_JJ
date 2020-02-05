package viikko3.taulukot.th;

public class MerkkijononSplit {

    public static void main(String[] args) {
        // merkkijonon "split" palauttaa taulukon:
        String nimi = "Johan Ludvig Runeberg";

        // split-metodille annetaan katkaisumerkki:
        String[] nimet = nimi.split(" ");

        System.out.println(nimet[0]);
        System.out.println(nimet[1]);
        System.out.println(nimet[2]);
    }
}
