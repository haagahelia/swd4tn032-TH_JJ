package viikko5.oliot.th;

public class AutoOhjelma {

    public static void main(String[] args) {
        // Luodaan kaksi muuttujaa ja kaksi autoa:
        Auto tesla = new Auto("Tesla");
        Auto bmw = new Auto("BMW");

        // Kutsutaan kunkin auton `aja`-metodia
        tesla.aja(100);
        bmw.aja(98);

        // Kutsutaan toString-metodia "käsin" ja printataan:
        System.out.println(tesla.toString());
    }
}
