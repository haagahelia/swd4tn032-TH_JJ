package viikko5.oliot.addressbook.th;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void add(Contact newContact) {
        this.contacts.add(newContact);
    }

    /*
     * Etsii listalta yhteystiedon, jonka nimessä esiintyy annettu hakusana
     */
    public Contact search(String keyword) {
        for (Contact current : this.contacts) {
            String name = current.getName();
            if (name != null && name.toLowerCase().contains(keyword.toLowerCase())) {
                return current; // palautetaan löytynyt arvo heti
            }
        }
        return null; // palautetaan null, jos ei löytynyt
    }

    @Override
    public String toString() {
        return "Contacts: " + this.contacts.toString();
    }
}
