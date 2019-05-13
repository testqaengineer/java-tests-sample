package ua.lvivskiy.v_dembovskiy;

import ua.lvivskiy.v_dembovskiy.car.entity.Car;
import ua.lvivskiy.v_dembovskiy.car.exeption.IgnitionOnException;
import ua.lvivskiy.v_dembovskiy.car.exeption.OutOfFuelException;

public class RacingMain {

    public static void main(String... args) throws IgnitionOnException, OutOfFuelException {
        Car.MakesModels makesModels1 = new Car.MakesModels("model", "", 30);
        Car car1 = new Car(makesModels1, 6000, 10, 10, true);
        car1.stopEngine();
        System.out.println(car1.refuel(5.0));
        System.out.println(car1.ride(15));

        Car.MakesModels makesModels2 = new Car.MakesModels("BMW", "red", 50);
        Car car2 = new Car(makesModels2, 200000, 40, 8, false);
        car2.refuel(20.0);
        car2.ride(50);
        car2.stopEngine();

        Car.MakesModels makesModels3 = new Car.MakesModels("Mercedes", "black", 60);
        Car car3 = new Car(makesModels3, 100_000, 5, 12, false);
        car3.refuel(10.0);
        car3.ride(100);

        Car.MakesModels makesModels4 = new Car.MakesModels("Opel", "black", 40);
        Car car4 = new Car(makesModels4, 110_000, 40, 9, false);
        car4.refuel(1.0);
        car4.ride(1000);
        car2.stopEngine();

        Car.MakesModels makesModels5 = new Car.MakesModels("Opel", "black");
        Car car5 = new Car(makesModels5, 110_000, 41);
        car5.refuel(14.0);
        car5.ride(1000);
        car2.stopEngine();
    }
}

