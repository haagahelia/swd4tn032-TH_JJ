package viikko7.tiedostot.th;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import viikko5.oliot.addressbook.th.Contact;

public class ContactWriter {
    private static final String FIRST_NAME_HEADER = "First Name";
    private static final String LAST_NAME_HEADER = "Last Name";
    private static final String EMAIL_HEADER = "E-mail Address";
    private static final String PHONE_HEADER = "Other Phone";

    public void writeContactsToFile(String outputFile, List<Contact> contacts) {
        Path csvFile = Paths.get(outputFile);

        List<String> lines = new ArrayList<>();
        lines.add(FIRST_NAME_HEADER + "," + LAST_NAME_HEADER + "," + EMAIL_HEADER + "," + PHONE_HEADER); // add the
                                                                                                         // header line
                                                                                                         // first
        contacts.forEach(c -> lines.add(contactToCsv(c)));

        try {
            Files.write(csvFile, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String contactToCsv(Contact c) {
        String[] names = c.getName().split(" ");
        return names[0] + "," + names[1] + "," + c.getEmail() + "," + c.getPhone();
    }
}
