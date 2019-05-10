package ua.lvivskiy.v_dembovskiy.car.entity;

import ua.lvivskiy.v_dembovskiy.car.exeption.IgnitionOnException;
import ua.lvivskiy.v_dembovskiy.car.exeption.OutOfFuelException;

import java.math.BigDecimal;

public class Car {

    private static final int DEFAULT_TANK_VOLUME = 40;
    private static final int DEFAULT_FUEL_CONSUMPTION = 10;
    private String model;
    private String color;
    private int odo;
    private double currFuelLevel;
    private double tankVolume;
    private boolean isIgnitionOn;
    private int fuelConsumption;

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
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
        setCurrFuelLevel(currFuelLevel);
    }

    public Car(MakesModels makesModels, int odo, double currFuelLevel, int fuelConsumption) {
        this(makesModels, odo, currFuelLevel);
        if (fuelConsumption < 0) {
            throw new IllegalArgumentException("The fuelConsuption can`t be below 0");
        }
        this.fuelConsumption = fuelConsumption;
    }

    public Car(MakesModels makesModels, int odo, double currFuelLevel, int fuelConsumption, boolean iSIgnitionOn) {
        this(makesModels, odo, currFuelLevel, fuelConsumption);
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
            if (model == null || model.isEmpty() || model.equals(" ")) {
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

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public boolean getIsIgnitionOn() {
        return isIgnitionOn;
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
    public int ride(int distanceKm) throws IgnitionOnException, OutOfFuelException {
        int rode;
        if (distanceKm < 0) {
            throw new IllegalArgumentException("The distance can`t be below 0");
        }
        if (distanceKm == 0) {
            rode = 0;
        } else if (currFuelLevel / (fuelConsumption / 100.0) > distanceKm) {
            startEngine();
            rode = distanceKm;
            currFuelLevel -= (double) fuelConsumption / 100.0 * distanceKm;
            odo += distanceKm;
        } else {
            stopEngine();
            rode = (int) (currFuelLevel / (fuelConsumption / 100.0));
            currFuelLevel = 0.0;
            odo += rode;
            throw new OutOfFuelException("The fuel is over");
        }
        return rode;
    }

    public void startEngine() throws IgnitionOnException {
        if (currFuelLevel < 1.0) {
            throw new IgnitionOnException("Car can`t turn on!");
        }
        isIgnitionOn = true;
    }

    public void stopEngine() {
        if (isIgnitionOn) {
            isIgnitionOn = false;
        }
    }

}