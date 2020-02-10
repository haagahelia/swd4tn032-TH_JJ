package viikko4.metodit.th;

public class NimenLyhentaja {

    public static String lyhenna(String etunimi, String sukunimi) {

        // Muuntaa "Keijo" ja "Rosberg" -> "K. Rosberg"
        String lyhennetty = etunimi.substring(0, 1) + ". " + sukunimi;

        return lyhennetty;
    }

}
