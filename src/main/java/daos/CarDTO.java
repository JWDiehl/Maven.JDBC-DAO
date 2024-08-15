package daos;

public class CarDTO implements DTO {
    private int id;
    private String make;
    private String model;
    private int year;
    private String color;
    private String vin;

    public CarDTO(int id, String make, String model, int year, String color, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
