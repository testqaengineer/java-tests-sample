package ua.lvivskiy.p_harkavy.car.entity;

import ua.lvivskiy.p_harkavy.car.exception.IgnitionException;

//todo: refactor tankVolume, fuelLevel to double type (read, how to compare doubles in Java)
public class Car {

    public static final int DEFAULT_TANK_VOLUME = 40;

    //todo: add DEFAULT_FUEL_CONSO value with overloaded constructor(s)

    private String model;
    private String color;
    private final int tankVolume;
    private int fuelConsumption;

    private int fuelLevel;
    private int odo;
    private boolean isIgnitionOn;

    public Car(String model, String color, int fuelConsumption) {
        this(model, color, DEFAULT_TANK_VOLUME, fuelConsumption);
    }

    public Car(String model, String color, int tankVolume, int fuelConsumption) {
        if (tankVolume < 1) {
            throw new IllegalArgumentException("Tank fuel volume can't be less, than 1 liter");
        }

        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Car model can't be null or empty");
        }

        this.model = model;
        this.color = color;
        this.tankVolume = tankVolume;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public boolean isIgnitionOn() {
        return isIgnitionOn;
    }

    public int getOdo() {
        return odo;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void startEngine() throws IgnitionException {
        if (fuelLevel <= 0) {
            throw new IgnitionException("Can't start car engine - no fuel!");
        }

        isIgnitionOn = true;
    }

    public void stopEngine() {
        isIgnitionOn = false;
    }

    /**
     * @return liters were added to the car
     * todo: use double instead of int
     */
    public int refuel(int liters) throws IgnitionException {
        if (liters < 1) {
            throw new IllegalArgumentException("Can't refuel car on liters: " + liters);
        }

        if (isIgnitionOn) {
            throw new IgnitionException("Can't refuel car - ignition is ON");
        }

        int freeVolume = tankVolume - fuelLevel;
        if (liters > freeVolume) {
        /*
         В баке 30 л., объём баке - 50;
         Хочу залить 100 литров, а могу залить 50 - 30 = 20.
         Когда я залью 20 - у меня всегда будет полный бак, т.к. я хочу залить намного больше, чем есть свободного места
         100 > free space = 50-30
        */
            fuelLevel = tankVolume;

            return freeVolume;
        } else {
        /*
         В баке 30 л., объём баке - 50; В этот else я попаду, если liters меньше, чем 50 - 30.
        */
            fuelLevel = fuelLevel + liters; // всегда < tankLevel

            return liters;
        }
    }

    /**
     * @return km, car has been ridden
     */
    public int ride(int distanceKm) {
        //todo: implement it!

        return 0;
    }
}
