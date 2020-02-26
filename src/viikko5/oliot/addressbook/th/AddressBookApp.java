package viikko5.oliot.addressbook.th;

/**
 * @see https://github.com/haagahelia/swd4tn032-TH_JJ/wiki/osoitekirja_projekti
 */
public class AddressBookApp {

    public static void main(String[] args) {
        // Kutsuu parametritonta konstruktoria:
        Contact matti = new Contact();

        // Kutsuu parametrillista konstruktoria:
        Contact maija = new Contact("Maija Meikäläinen", "maija@example.com", "+35850555556");

        System.out.println(matti.toString()); // sama kuin seuraava
        System.out.println(maija); // sama kuin edellinen

        // null-arvo voidaan myös antaa parametrina, asettaa muuttujaan jne.
        Contact john = new Contact("John", "john@example.com", null);
        System.out.println(john);
    }
}
