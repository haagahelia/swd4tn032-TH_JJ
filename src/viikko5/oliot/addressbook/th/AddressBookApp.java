package viikko5.oliot.addressbook.th;

import java.util.Scanner;

/**
 * @see https://github.com/haagahelia/swd4tn032-TH_JJ/wiki/osoitekirja_projekti
 */
public class AddressBookApp {

    public static void main(String[] args) {
        AddressBook book = new AddressBook();

        Scanner input = new Scanner(System.in);

        // Kutsuu parametritonta konstruktoria (käyttää null-arvoja):
        Contact matti = new Contact();
        book.add(matti);

        // Kutsuu parametrillista konstruktoria:
        Contact maija = new Contact("Maija Meikäläinen", "maija@example.com", "+35850555556");
        book.add(maija);

        // null-arvo voidaan myös antaa parametrina, asettaa muuttujaan jne.
        Contact john = new Contact("John", "john@example.com", null);
        book.add(john);

        System.out.print("Enter keyword: ");
        String keyword = input.nextLine();

        Contact found = book.search(keyword);
        System.out.println("Found contact: " + found);
    }
}
