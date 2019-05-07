public class RacingMain {

    public void turnOn(Car car){
        car.setIgnition(true);
    }

    public void turnOff(Car car){
        car.setIgnition(false);
    }

    public void ride(Car car, int distance){
        if (car.getIgnition()) {
            car.setOdo(car.getOdo() + distance);
            float spentFlue = (float)(car.getFuelConsumption()/100 * distance);
            int currentFlue = car.getCurrFuelLevel() - (int) spentFlue;
            car.setCurrFuelLevel(currentFlue);
            car.setFuelConso(currentFlue);
        }
        else System.out.println("Your should turnOn the car !");
    }

    public void refuel(Car car, int liters){
        if(car.getCurrFuelLevel()+liters>car.getTankVolume()){
            System.out.println("Oh no !!! The tank does not hold as much!");
        }
        else {
            car.setTankVolume(car.getCurrFuelLevel() + liters);
        }
    }

}

