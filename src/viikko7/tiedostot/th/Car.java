package viikko7.tiedostot.th;

public class Car {

    private String year;
    private String make;
    private String model;

    public Car(String year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car [year=" + year + ", make=" + make + ", model=" + model + "]";
    }
}