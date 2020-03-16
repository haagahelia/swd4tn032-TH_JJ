package viikko8.harjoituskoe.th;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TankkausOhjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna päivämäärä: ");
        String pvm = lukija.nextLine();

        System.out.print("Anna tankattu määrä: ");
        double maara = lukija.nextDouble();

        System.out.print("Anna litrahinta: ");
        double litrahinta = lukija.nextDouble();

        Tankkaus tankkaus = new Tankkaus(pvm, maara, litrahinta);

        System.out.println(tankkaus);
    }

}

class Tankkaus {

    private String paiva;
    private double maara;
    private double litrahinta;

    public Tankkaus() {
    }

    public Tankkaus(String paiva, double maara, double litrahinta) {
        this.paiva = paiva;
        this.maara = maara;
        this.litrahinta = litrahinta;
    }

    public double laskeTankkaus() {
        return this.maara * this.litrahinta;
    }

    @Override
    public String toString() {
        DecimalFormat muotoilu = new DecimalFormat("0.00");
        String maksettu = muotoilu.format(this.laskeTankkaus());
        return "Päivä: " + this.paiva + "\nMaksettu: " + maksettu;
    }
}