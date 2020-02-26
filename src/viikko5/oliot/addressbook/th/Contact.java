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
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        // Haluttu muoto: "Maija Meikäläinen (email: foo@bar.fi, phone: 5555)"
        return this.name + " (email: " + this.email + ", phone: " + this.phone + ")";
    }
}
