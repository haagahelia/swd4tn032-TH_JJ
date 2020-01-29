package viikko2.merkkijonot.th;

public class SubstringJaIndexOf {

    public static void main(String[] args) {
        String feeling = "unhappy";

        // indeksit alkavat aina nollasta!
        String substring = feeling.substring(2);
        System.out.println(substring);

        // substringille voidaan antaa myös loppuindeksi:
        String app = feeling.substring(3, 6); // loppuindeksiä ei oteta mukaan
        System.out.println(app);

        String email = "jane.ferguson@example.com";
        int atSignIndex = email.indexOf("@");
        System.out.println(atSignIndex);

        String username = email.substring(0, atSignIndex);
        System.out.println(username);

        String domain = email.substring(atSignIndex + 1);
        System.out.println(domain);
    }
}
