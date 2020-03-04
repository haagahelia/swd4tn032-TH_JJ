package viikko7.tiedostot.th;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import viikko5.oliot.addressbook.th.Contact;

public class ContactReader {

    private static final String FIRST_NAME_HEADER = "First Name";
    private static final String LAST_NAME_HEADER = "Last Name";
    private static final String EMAIL_HEADER = "E-mail Address";
    private static final String PHONE_HEADER = "Other Phone";

    public List<Contact> readContactsFromFile(String file) {
        List<Contact> contacts = new ArrayList<Contact>();
        Path csvFile = Paths.get(file);
        try {
            List<String> lines = Files.readAllLines(csvFile, StandardCharsets.UTF_8);

            String firstLine = lines.get(0);
            List<String> headers = Arrays.asList(firstLine.split(","));

            int firstNameIndex = headers.indexOf(FIRST_NAME_HEADER);
            int lastNameIndex = headers.indexOf(LAST_NAME_HEADER);
            int emailIndex = headers.indexOf(EMAIL_HEADER);
            int phoneIndex = headers.indexOf(PHONE_HEADER);

            for (int i = 1; i < lines.size(); i++) {
                String[] values = lines.get(i).split(",");
                String name = values[firstNameIndex].trim() + " " + values[lastNameIndex].trim();
                String email = values[emailIndex].trim();
                String phone = values[phoneIndex].trim();

                Contact newContact = new Contact(name, email, phone);
                contacts.add(newContact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
