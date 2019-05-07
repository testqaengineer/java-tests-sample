package java.ua.lvivskiy.pharkavy.car;

import java.util.ArrayList;

public class RacingMain {

    public static void main(String... args) {
        // Создать 5 машинок

        Car car1 = new Car(["Toyota", "Prius"], "White", 60, 0);
        Car car2 = new Car(["Toyota", "Tacoma"], "Blue", 160, 0);
        Car car3 = new Car(["Alfa Romeo", "Brera"], "Red", 55, 25);
        Car car4 = new Car(["Porsche ", "Boxster"], "Yellow", 50, 15);
        Car car5 = new Car(["Alfa Romeo", "Brera"], "Red", 55, 0);

        ArrayList<Car> cars=new ArrayList<Car>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        //запрвавить, завести и заставить проехать разные расстояния
        int countDistance=50;
        for(Car car: cars) {

            if (car.tankFuelVolumeMinForCars-car.getFuelConsolIndication()>=45) {
                car.refuel(40);
            }
            if (car.getCurrentFuelLevel()>=40) {
                car.turnOn(true);
            }
            car.setRideDistanse(countDistance);
            if (car.getOdoIndication()<=car.getRideDistanse()*1000/60*3.14) {
                countDistance=countDistance+10;
            }
            else {
                countDistance=countDistance+0;
            }
        }
    }
}