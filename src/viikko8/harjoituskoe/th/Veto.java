package viikko8.harjoituskoe.th;

import java.text.DecimalFormat;

/*
 * Anna painosi: 75
Tavoitepainosi on  67,50
1. viikon lopussa painon pitäisi olla 73,93
2. viikon lopussa painon pitäisi olla 72,86
3. viikon lopussa painon pitäisi olla 71,79
4. viikon lopussa painon pitäisi olla 70,71
5. viikon lopussa painon pitäisi olla 69,64
6. viikon lopussa painon pitäisi olla 68,57
7. viikon lopussa painon pitäisi olla 67,50
 */
public class Veto {

    public static void main(String[] args) {
        int alku = 75;

        // pystyvätkö vetoon osallistujat pudottamaan painoaan 10% seitsemän viikon
        // aikana?
        double loppupaino = alku * 0.9;
        double erotus = alku - loppupaino;
        double erotusPerViikko = erotus / 7;

        DecimalFormat muotoilija = new DecimalFormat("0.00");

        System.out.println("Tavoitepainosi on " + muotoilija.format(loppupaino));

        for (int viikko = 1; viikko <= 7; viikko++) {
            double painoViikonLopussa = alku - erotusPerViikko * viikko;
            String pyoristetty = muotoilija.format(painoViikonLopussa);
            System.out.println(viikko + ". viikon lopussa painon pitäisi olla " + pyoristetty);
        }
    }
}
