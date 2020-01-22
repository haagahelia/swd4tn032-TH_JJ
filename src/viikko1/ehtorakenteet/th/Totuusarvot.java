package viikko1.ehtorakenteet.th;

public class Totuusarvot {

    public static void main(String[] args) {
        int luku = 1;

        boolean b1 = luku == 1;
        boolean b2 = luku > 0;
        boolean b3 = luku < 2;
        boolean b4 = luku >= 1;
        boolean b5 = luku <= 1;
        boolean b6 = luku != 0;

        System.out.println(b1 && b2 && b3 && b4 && b5 && b6);
    }
}
