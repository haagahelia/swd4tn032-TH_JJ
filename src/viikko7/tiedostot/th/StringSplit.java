package viikko7.tiedostot.th;

public class StringSplit {

    public static void main(String[] args) {
        System.out.println(",,,,,,".split(",").length); // 0

        System.out.println("".split(" ").length); // 1?
        System.out.println(" ".split(" ").length); // 0?
    }
}
