/**
 * Created by Arsen on 11.08.2017.
 */
public class BuilderApp {
    public static void main(String[] args) {

        Director director = new Director();
        director.setCarBuilder(new SubaruBuilder());
        Car car = director.builderCar();

        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO
}

// продукт
class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {this.make = make;}
    public void setTransmission(Transmission transmission) {this.transmission = transmission;}
    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

// билдер
abstract class CarBuilder {
    Car car;
    void createCar() {car = new Car();}

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Car getCar() {return car;}
}

class FordMandeoBuilder extends CarBuilder {
    void buildMake() {car.setMake("Ford Mondeo");}
    void buildTransmission() {car.setTransmission(Transmission.AUTO);}
    void buildMaxSpeed() {car.setMaxSpeed(333);}
}
class SubaruBuilder extends CarBuilder {
    void buildMake() {car.setMake("Subaru");}
    void buildTransmission() {car.setTransmission(Transmission.MANUAL);}
    void buildMaxSpeed() {car.setMaxSpeed(334);}
}

class Director {
    CarBuilder carBuilder;

    public void setCarBuilder(CarBuilder b) {this.carBuilder = b;}

    Car builderCar() {
        carBuilder.createCar();
        carBuilder.buildMake();
        carBuilder.buildTransmission();
        carBuilder.buildMaxSpeed();
        Car car = carBuilder.getCar();
        return car;
    }
}