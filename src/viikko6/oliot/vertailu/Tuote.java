package viikko6.oliot.vertailu;

public class Tuote {

    private String nimi;

    public Tuote(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return "Tuote: " + this.nimi;
    }

    @Override
    public boolean equals(Object obj) {
        String toinenStr = obj.toString();
        String tamaStr = this.toString();
        return tamaStr.equals(toinenStr);
    }
}
