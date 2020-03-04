package viikko7.tiedostot.th;

import java.util.List;

import viikko5.oliot.addressbook.th.Contact;

public class CsvTiedostonLukeminen {

    public static void main(String[] args) {
        ContactReader reader = new ContactReader();
        ContactWriter writer = new ContactWriter();

        String inputFile = "contacts-outlook.csv";
        List<Contact> contacts = reader.readContactsFromFile(inputFile);

        contacts.forEach(System.out::println);

        String outputFile = "contacts-out.csv";
        writer.writeContactsToFile(outputFile, contacts);

    }
}
