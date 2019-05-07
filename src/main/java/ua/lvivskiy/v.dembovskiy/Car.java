public class Car {
private String model;
private String color;
private int fuelConso = 30;
private int odo;
private int currFuelLevel;
private int tankVolume = 50;
private boolean ignition;
private int fuelConsumption;

public Car(String model, String color, int fuelConso, int odo,  int currFuelLevel, int tankVolume, boolean ignition, int fuelConsumption){
    setModel(model);
    setColor(color);
    setFuelConso(fuelConso);
    setOdo(odo);
    setCurrFuelLevel(currFuelLevel);
    setTankVolume(tankVolume);
    setIgnition(ignition);
    setFuelConsumption(fuelConsumption);
}

public Car(String model, String color, int odo, int currFuelLevel, boolean ignition, int fuelConsumption){
    setModel(model);
    setColor(color);
    setOdo(odo);
    setCurrFuelLevel(currFuelLevel);
    setIgnition(ignition);
    setFuelConsumption(fuelConsumption);
    }

    public void setModel(String model){
        if (!model.equals("")) {
            this.model = model;
        }
        else{
            System.out.println("The model parameter must not be empty!!!");
        }
    }

    public String getModel(){ return  model; }

    public void setColor(String color){
        if (!color.equals("")) {
            this.color = color;
        }
        else{
            System.out.println("The color parameter must not be empty!!!");
        }
    }

    public String getColor(){ return  color; }

    public void setFuelConso(int fuelConso){
        if (fuelConso>=0) {
            this.fuelConso = fuelConso;
        }
        else{
            System.out.println("The fuelConso parameter must not be below 0!!!");
        }
    }

    public int getFuelConso(){ return  fuelConso; }

    public void setOdo(int odo){
        if (odo>=0) {
            this.odo = odo;
        }
        else{
            System.out.println("The odo parameter must not be below 0!!!");
        }
    }

    public int getOdo(){ return  odo; }

    public void setCurrFuelLevel(int currFuelLevel){
        if (currFuelLevel>=0) {
            this.currFuelLevel = currFuelLevel;
        }
        else{
            System.out.println("The currFuelLevel parameter must not be below 0!!!");
        }
    }

    public int getCurrFuelLevel(){ return  currFuelLevel; }

    public void setTankVolume(int tankVolume){
        if (tankVolume>=0) {
            this.tankVolume = tankVolume;
        }
        else{
            System.out.println("The tankVolume parameter must not be below 0!!!");
        }
    }

    public int getTankVolume(){ return  tankVolume; }

    public void setIgnition(boolean ignition){
            this.ignition = ignition;
    }

    public void setFuelConsumption(int fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelConsumption(){ return  fuelConsumption; }

    public boolean getIgnition(){ return  ignition; }


    public  static void main (String [] args){
        RacingMain racingMain = new RacingMain();
        Car car1 = new Car("Mersedes", "Black",30, 50000,30, 80, true , 10);
        racingMain.refuel(car1, 10);
        racingMain.turnOn(car1);
        racingMain.ride(car1, 100);
        racingMain.turnOff(car1);

        Car car2 = new Car ("BMW", "Wight", 60, 70000,false, 7);
        racingMain.refuel(car2, 8);
        racingMain.turnOn(car2);
        racingMain.ride(car2, 67);
        racingMain.turnOff(car2);

        Car car3 = new Car("Maserati", "Blue",90, 9000, 90, 90, true , 8);
        racingMain.refuel(car3, 11);
        racingMain.turnOn(car3);
        racingMain.ride(car3, 80);
        racingMain.turnOff(car3);

        Car car4 = new Car("Ford", "Lilac",10,70000, 10, 60, true , 5);
        racingMain.refuel(car4, 7);
        racingMain.turnOn(car4);
        racingMain.ride(car4, 200);
        racingMain.turnOff(car4);

        Car car5 = new Car("volvo", "Smoke",20,6000, 20, 60, true , 7);
        racingMain.refuel(car5, 9);
        racingMain.turnOn(car5);
        racingMain.ride(car5, 20);
        racingMain.turnOff(car5);

    }



}
