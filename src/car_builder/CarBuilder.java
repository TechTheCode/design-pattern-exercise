package car_builder;

public class CarBuilder {
    private Car car = new Car();

    public CarBuilder engine(String engine) {
        car.setEngine(engine);
        return this;
    }

    public CarBuilder wheels(int wheels) {
        car.setWheels(wheels);
        return this;
    }

    public CarBuilder color(String color) {
        car.setColor(color);
        return this;
    }

    public Car build() {
        Car builtCar = new Car();
        builtCar.setEngine(car.getEngine());
        builtCar.setWheels(car.getWheels());
        builtCar.setColor(car.getColor());
        return builtCar;
    }

}