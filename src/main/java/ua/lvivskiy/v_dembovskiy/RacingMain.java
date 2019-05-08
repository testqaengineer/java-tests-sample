package ua.lvivskiy.v_dembovskiy;

public class RacingMain {

    public static void main(String... args) {

        Car car1 = new Car("Mersedes", "Black",30, 50000,30, 80, true , 10);
        car1.refuel( 5);
        car1.turnOn();
        car1.ride( 20);
        car1.turnOff();

        Car car2 = new Car("BMW", "Wight", 60, 35,false, 7);
        car2.refuel( 8);
        car2.turnOn();
        car2.ride( 67);
        car2.turnOff();

        Car car3 = new Car("Maserati", "Blue",90, 9000, 90, 90, true , 8);
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

    }

}

