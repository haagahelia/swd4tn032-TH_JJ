package viikko5.oliot.addressbook.th;

public class Contact {

    private String name;
    private String email;
    private String phone;

    // parametriton konstruktori (usein turha)
    public Contact() {
    }

    // parametrillinen konstruktori (luo valideja olioita)
    public Contact(String name, String email, String phone) {
        this.name = name;
        this.phone = phone;
        this.setEmail(email);
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        // tarkista, että email on validi. Jos ei ole, heitä poikkeus!
        if (!email.contains("@")) {
            // 'throw' avainsanalla heitetään poikkeus. Poikkeukset ovat olioita, jotka
            // luodaan new-avainsanalla. Poikkeukselle annetaan parametrina virheilmoitus:
            throw new IllegalArgumentException(email + " is not a valid email address");
        }

        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        // "riittävän tarkka" vertailu vertailee olioiden merkkijonoesityksiä
        return this.toString().equals(obj.toString());
    }

    public String toString() {
        // Haluttu muoto: "Maija Meikäläinen (email: foo@bar.fi, phone: 5555)"
        return this.name + " (email: " + this.email + ", phone: " + this.phone + ")";
    }
}
