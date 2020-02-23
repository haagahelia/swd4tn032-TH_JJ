```java
import java.util.ArrayList;
import java.util.List;

public class Country {

    private String name;
    private int population;
    private List<Country> neighbors;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
        this.neighbors = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public void addNeighbor(Country neighbor) {
        if (!this.isNeighbor(neighbor)) {
            this.neighbors.add(neighbor);
        }
    }

    /*
     * "Varargs help us avoid writing boilerplate code by introducing the new syntax that
     * can handle an arbitrary number of parameters automatically – using an array under the hood."
     *
     * https://www.baeldung.com/java-varargs
     */
    public void addNeighbors(Country... newNeighbors) {
        for (Country neighbor : newNeighbors) {
            this.addNeighbor(neighbor);
        }
    }

    public boolean isNeighbor(Country other) {
        return false;
    }

    public List<Country> getCommonNeighbors(Country other) {
        return new ArrayList<>();
    }

    public boolean hasRouteTo(Country destination) {
        return false;
    }

    public List<Country> findRouteTo(Country destination) {
        return new ArrayList<>();
    }
}
```