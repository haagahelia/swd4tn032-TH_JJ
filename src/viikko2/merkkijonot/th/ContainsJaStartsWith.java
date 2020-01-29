package viikko2.merkkijonot.th;

public class ContainsJaStartsWith {

    public static void main(String[] args) {
        String url = "https://www.example.com";

        boolean isSecure = url.startsWith("https://");
        boolean isUnsecure = !isSecure;
        boolean containsExample = url.contains("example.com");
        boolean endsWithDotCom = url.endsWith(".com");

        System.out.println(url + " is secure: " + isSecure);
    }
}
