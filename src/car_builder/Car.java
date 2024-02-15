package car_builder;

public class Car {
    private String engine;
    private int wheels;
    private String color;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car with engine: " + engine + ", wheels: " + wheels + ", color: " + color;
    }

    public String getEngine() {
        return this.engine;
    }

    public int getWheels() {
        return this.wheels;
    }

    public String getColor() {
        return this.color;
    }
}