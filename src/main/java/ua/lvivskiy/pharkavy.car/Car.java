package java.ua.lvivskiy.pharkavy.car;

public class Car {

    private String[] makesmodels;
    private String color;
    private int tankFuelVolume;
    final public int tankFuelVolumeMinForCars=50;
    private int distance;

    private Boolean ignition;

    private int fuelConsolIndication;
    private int currentFuelLevel=0;


    private long odoIndication;
    public double getOdoIndication() {
        return distance*1000/(60*3.14);
    }


    public Car(String[] makesmodels, String color, int tankFuelVolume, int fuelConsolIndication) {
        this.makesmodels=makesmodels;
        this.color=color;
        this.tankFuelVolume=tankFuelVolume;
        this.fuelConsolIndication=fuelConsolIndication;
    }



    public void turnOn(Boolean ignition) {
        this.ignition=ignition;
    }
    public void turnOff() {
        ignition=false;
    }



    public int getRideDistanse() {
        return distance;
    }
    public void setRideDistanse(int distance) {
        this.distance=distance;
    }



    public int getFuelConsolIndication() {
        return this.fuelConsolIndication;
    }
    public int getCurrentFuelLevel() {
        return this.currentFuelLevel;
    }



    public void refuel(int liters) {
        currentFuelLevel=liters;
    }

}