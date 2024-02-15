package car_builder;

public class CarDirector {
    private CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public Car buildSportsCar() {
        return builder.engine("V8")
                .wheels(4)
                .color("Red")
                .build();
    }

    public Car buildFamilyCar() {
        return builder.engine("V6")
                .wheels(4)
                .color("Blue")
                .build();
    }
}
