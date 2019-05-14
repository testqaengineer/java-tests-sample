package ua.lvivskiy.v_dembovskiy.car.entity;

import ua.lvivskiy.v_dembovskiy.car.exeption.IgnitionOffException;
import ua.lvivskiy.v_dembovskiy.car.exeption.IgnitionOnException;
import ua.lvivskiy.v_dembovskiy.car.exeption.OutOfFuelException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class Car {

    private static final int DEFAULT_TANK_VOLUME = 40;
    private static final double DEFAULT_FUEL_CONSUMPTION_PER_KM = 10.0;
    private String model;
    private String color;
    private int odo;
    private double currFuelLevel;
    private double tankVolume;
    private boolean isIgnitionOn;
    private double fuelConsumptionPer100Km;
    private double consumptionLitersPer1Km;


    public Car(MakesModels makesModels, int odo, double currFuelLevel) {
        if (currFuelLevel < 0) {
            throw new IllegalArgumentException("The currFuelLevel can`t be below 0");
        }
        if (odo < 0) {
            throw new IllegalArgumentException("The odo can`t be below 0");
        }
        this.model = makesModels.model;
        setColor(makesModels.color);
        this.odo = odo;
        this.tankVolume = makesModels.tankVolume;
        this.fuelConsumptionPer100Km = DEFAULT_FUEL_CONSUMPTION_PER_KM;
        this.consumptionLitersPer1Km = DEFAULT_FUEL_CONSUMPTION_PER_KM / 100.0;
        setCurrFuelLevel(currFuelLevel);
    }

    public Car(MakesModels makesModels, int odo, double currFuelLevel, double fuelConsumptionPer100Km) {
        this(makesModels, odo, currFuelLevel);
        if (fuelConsumptionPer100Km < 0) {

            throw new IllegalArgumentException("The fuel Consuption can`t be below 0");
        }
        this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
        this.consumptionLitersPer1Km = fuelConsumptionPer100Km / 100.0;
    }

    public Car(MakesModels makesModels, int odo, double currFuelLevel, double fuelConsumptionPer100Km, boolean iSIgnitionOn) {
        this(makesModels, odo, currFuelLevel, fuelConsumptionPer100Km);
        setIsIgnitionOn(iSIgnitionOn);
    }

    public static class MakesModels {
        String model;
        String color;
        double tankVolume;

        public MakesModels(String model, String color, double tankVolume) {

            if (tankVolume < 1.0) {

                throw new IllegalArgumentException("Tank fuel volume can't be less, than 1 liter");
            }

            if (isBlank(model)) {

                throw new IllegalArgumentException("Car model can't be null or empty");
            }

            this.model = model;
            this.color = color;
            this.tankVolume = tankVolume;
        }

        public MakesModels(String model, String color) {
            this(model, color, Car.DEFAULT_TANK_VOLUME);
        }
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getOdo() {
        return odo;
    }

    public void setCurrFuelLevel(double currFuelLevel) {

        if (currFuelLevel > tankVolume) {

            throw new IllegalArgumentException("Current fuel level is more then than volume");
        }

        this.currFuelLevel = currFuelLevel;
    }

    public double getCurrFuelLevel() {
        return currFuelLevel;
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setIsIgnitionOn(boolean isIgnitionOn) {
        this.isIgnitionOn = isIgnitionOn;
    }

    public double getFuelConsumptionPer100Km() {
        return fuelConsumptionPer100Km;
    }

    public boolean getIsIgnitionOn() {
        return isIgnitionOn;
    }

    public double getConsumptionLitersPer1Km() {
        return consumptionLitersPer1Km;
    }

    /**
     * @return liters were added to the car
     * todo: use double instead of int
     */

    public double refuel(double liters) throws IgnitionOnException {

        if (liters < 1.0) {

            throw new IllegalArgumentException("The liters value can't be less, than 1 liter ");
        }

        if (liters > tankVolume) {

            throw new IllegalArgumentException("The liters value can't be more then tankVolume");
        }

        if (isIgnitionOn) {

            throw new IgnitionOnException("Can't refuel car - ignition is ON");
        }

        double addedLiters;

        if (tankVolume < currFuelLevel + liters) {
            addedLiters = tankVolume - currFuelLevel;
            currFuelLevel = tankVolume;
        } else {
            currFuelLevel += liters;
            addedLiters = liters;
        }

        return addedLiters;
    }

    /**
     * @return km, car has been ridden
     */
    public int ride(int distanceKm) throws OutOfFuelException, IgnitionOffException {
        int distanceWasRidden;

        if (distanceKm < 0) {

            throw new IllegalArgumentException("The distance can`t be below 0");
        }

        if (distanceKm == 0) {
            return 0;
        }

        if (!isIgnitionOn) {

            throw new IgnitionOffException("The motor of the car is switched off");
        } else if (currFuelLevel / consumptionLitersPer1Km > distanceKm) {
            distanceWasRidden = distanceKm;
            currFuelLevel -= consumptionLitersPer1Km * distanceKm;
            odo += distanceKm;
        } else {
            stopEngine();
            distanceWasRidden = (int) (currFuelLevel / consumptionLitersPer1Km);
            currFuelLevel = 0.0;
            odo += distanceWasRidden;

            throw new OutOfFuelException("The fuel is over");
        }

        return distanceWasRidden;
    }

    public void startEngine() throws IgnitionOnException {

        if (currFuelLevel < 1.0) {

            throw new IgnitionOnException("Car can`t turn on!");
        }

        isIgnitionOn = true;
    }

    public void stopEngine() {
        isIgnitionOn = false;

    }

}