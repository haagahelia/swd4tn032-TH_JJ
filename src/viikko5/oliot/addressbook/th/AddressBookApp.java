package viikko5.oliot.addressbook.th;

import java.util.Scanner;

/**
 * @see https://github.com/haagahelia/swd4tn032-TH_JJ/wiki/osoitekirja_projekti
 */
public class AddressBookApp {

    public static void main(String[] args) {
        System.out.println("This is an address book application. Available commands:\r\n" + " list\r\n" + " help\r\n"
                + " add <name>, <email>, <phone>\r\n" + " search <name>\r\n" + " exit");
        AddressBook book = new AddressBook();

        Scanner input = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.print("> ");
            String command = input.next();
            String theRest = input.nextLine().trim();

            // ... toimintalogiikka

            switch (command) {
            case "help":
                // tulosta ohje
                break;
            case "list":
                // tulosta osoitekirjan koko sisältö
                System.out.println(book);
                break;
            case "add":
                // käytä annettua nimeä, emailia ja puhelinnumeroa luodaksesi uuden yhteystiedon
                String[] parts = theRest.split(",");

                try {
                    // try-lohkon sisällä voidaan tehdä "riskialttiita" operaatioita
                    String name = parts[0].trim();
                    String email = parts[1].trim();
                    String phone = parts[2].trim();

                    Contact newContact = new Contact(name, email, phone);
                    boolean added = book.add(newContact);
                    if (added) {
                        System.out.println("Added " + newContact);
                    } else {
                        System.out.println(newContact + " is already in the address book.");
                    }
                } catch (ArrayIndexOutOfBoundsException poikkeus) {
                    // catch-lohkoon päädytään vain, jos try-lohkossa tapauhtui virhe
                    System.out.println("Virheellinen määrä arvoja");

                    // ohjelma ei enää kaadu koska virheet käsitellään asianmukaisesti
                } catch (IllegalArgumentException poikkeus) {
                    // virheilmoitus voidaan kysyä getMessage-metodilla:
                    System.out.println(poikkeus.getMessage());
                }
                break;
            case "search":
                // etsi yhteystietoa ja tulosta se
                break;
            case "exit":
                // poistu ohjelmasta
                System.out.println("Bye!");
                running = false;
                break;
            default:
                // tunnistamaton komento:
                System.out.println("Unknown command");
                break;
            }
            System.out.println();
        }
    }
}
