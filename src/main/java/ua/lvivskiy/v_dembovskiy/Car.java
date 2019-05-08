package ua.lvivskiy.v_dembovskiy;

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


    public void turnOn(){
    setIgnition(true);
    System.out.println(getModel()+": "+"The car is turn on");
    }

    public void turnOff(){
    setIgnition(false);
    System.out.println(getModel()+": "+"The car is turn off"+"\n");
    }

    public void ride(int distance){
    System.out.println(getModel()+": "+"The current value of odo is "+getOdo()+" km");
        if (getIgnition()) {
            setOdo(getOdo() + distance);
            float spentFlue = (float)(getFuelConsumption()/100.0 * distance);
            int currentFlue = (int) (getCurrFuelLevel() - spentFlue);
            setCurrFuelLevel(currentFlue);
            setFuelConso(currentFlue);
            System.out.println(getModel()+": "+"The current value of odo after ride "+getOdo()+" km");
            System.out.println(getModel()+": "+"The car drove "+distance+" km");
            System.out.println(getModel()+": "+"The fuel level after ride is "+getCurrFuelLevel()+" L");
        }
        else System.out.println(getModel()+": "+"Your should turnOn the car !");
    }

    public void refuel(int liters){
            System.out.println(getModel()+": "+"Fuel level before refuel is "+ getCurrFuelLevel()+" L");
        if(getCurrFuelLevel()+liters>getTankVolume()){
            System.out.println(getModel()+": "+"Oh no !!! The tank does not hold as much!");
        }
        else {
            setCurrFuelLevel(getCurrFuelLevel() + liters);
            System.out.println(getModel()+": "+"Fuel level after refuel is " + getCurrFuelLevel()+" L");
        }
    }

}
