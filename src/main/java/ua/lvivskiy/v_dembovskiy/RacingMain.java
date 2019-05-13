package ua.lvivskiy.v_dembovskiy;

import ua.lvivskiy.v_dembovskiy.car.entity.Car;
import ua.lvivskiy.v_dembovskiy.car.exeption.IgnitionOnException;
import ua.lvivskiy.v_dembovskiy.car.exeption.OutOfFuelException;

public class RacingMain {

<<<<<<< HEAD
    public static void main(String... args) {

        main.java.ua.lvivskiy.v.dembovskiy.Car car1 = new main.java.ua.lvivskiy.v.dembovskiy.Car("Mersedes", "Black",30, 50000,30, 80, true , 10);
        car1.refuel( 5);
        car1.turnOn();
        car1.ride( 20);
        car1.turnOff();

        main.java.ua.lvivskiy.v.dembovskiy.Car car2 = new main.java.ua.lvivskiy.v.dembovskiy.Car("BMW", "Wight", 60, 35,false, 7);
        car2.refuel( 8);
        car2.turnOn();
        car2.ride( 67);
        car2.turnOff();

        main.java.ua.lvivskiy.v.dembovskiy.Car car3 = new main.java.ua.lvivskiy.v.dembovskiy.Car("Maserati", "Blue",90, 9000, 90, 90, true , 8);
        car3.refuel( 20);
        car3.turnOn();
        car3.ride( 80);
        car3.turnOff();

        Car car4 = new Car("Ford", "Lilac",10,70000, 10, 60, true , 5);
        car4.refuel( 7);
        car4.turnOn();
        car4.ride( 200);
        car4.turnOff();

        Car car5 = new Car("Volvo", "Smoke",20,6000, 20, 60, true , 7);
        car5.refuel( 9);
        car5.turnOn();
        car5.ride( 20);
        car5.turnOff();
=======
    public static void main(String... args) throws IgnitionOnException, OutOfFuelException {
        Car.MakesModels makesModels1 = new Car.MakesModels("model", "", 30);
        Car car1 = new Car(makesModels1,6000, 10,10,  true);
        car1.stopEngine();
        System.out.println(car1.refuel(5.0));
        System.out.println(car1.ride(15));

        Car.MakesModels makesModels2 = new Car.MakesModels("BMW", "red", 50);
        Car car2 = new Car(makesModels2,200000, 40,8,  false);
        car2.refuel(20.0);
        car2.ride(50);
        car2.stopEngine();

        Car.MakesModels makesModels3 = new Car.MakesModels("Mercedes", "black", 60);
        Car car3 = new Car(makesModels3,100_000, 5,12,  false);
        car3.refuel(10.0);
        car3.ride(100);

        Car.MakesModels makesModels4 = new Car.MakesModels("Opel", "black", 40);
        Car car4 = new Car(makesModels4,110_000, 40,9,  false);
        car4.refuel(1.0);
        car4.ride(1000);
        car2.stopEngine();

        Car.MakesModels makesModels5 = new Car.MakesModels("Opel", "black");
        Car car5 = new Car(makesModels5,110_000, 41);
        car5.refuel(14.0);
        car5.ride(1000);
        car2.stopEngine();
>>>>>>> 6144493ccbf950164d04a19f9c84b6207f33f552

    }

}

