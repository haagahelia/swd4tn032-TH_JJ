package viikko7.tiedostot.th.weather;

public class SplitEmptyCSV {

    public static void main(String[] args) {
        String emptyRow = ",,,,,,,";
        String[] parts = emptyRow.split(",");
        System.out.println(parts.length);
    }
}
