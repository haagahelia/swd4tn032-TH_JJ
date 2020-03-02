package viikko6.oliot.vertailu;

public class MerkkijonojenVertailu {

    public static void main(String[] args) {
        String maito1 = new String("Maito");
        String maito2 = new String("Maito");

        System.out.println(maito1 == maito2); // ei toimi, koska pitäisi olla SAMA OLIO
        System.out.println(maito1.equals(maito2)); // toimii, koska vertailee sisältöä

        System.out.println("MAITO".equalsIgnoreCase(maito1)); // vertailee kirjainkoosta riippumatta
    }
}
