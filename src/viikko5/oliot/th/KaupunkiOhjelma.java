package viikko5.oliot.th;

public class KaupunkiOhjelma {

    public static void main(String[] args) {
        // Omaa luokkaa voidaan käyttää muuttujan tyyppinä:
        Kaupunki omanLuokanMuuttuja;

        // Omasta luokasta voidaan luoda olioita, kuten Javan valmiista luokista, eli
        // new-avainsalla:
        Kaupunki hki = new Kaupunki("Helsinki", 653_867);

        // Parametreina annettavat arvot välitetään luokan konstruktorille:
        Kaupunki esp = new Kaupunki("Espoo", 289_413);

        System.out.println("Luotiin kaksi kaupunkia");
    }
}
