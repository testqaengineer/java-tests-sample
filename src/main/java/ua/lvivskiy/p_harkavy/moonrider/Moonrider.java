package ua.lvivskiy.p_harkavy.moonrider;

import ua.lvivskiy.p_harkavy.moonrider.entity.MoonRoad;
import ua.lvivskiy.p_harkavy.moonrider.exception.MoonriderRefuelingException;

public class Moonrider {

    // ДЗ1:
    // Написать класс Moonrider (model, color, fuel consumption, odo(одометр), curr fuel level, tank volume, ignition (on/off))
    // машины должны ездить(только если заведены), методы: turnOn(startEngine), turnOff(stopEngine), ride(distance), refuel(liters)
    // Конструкторы должны быть с перегрузкой (сделать возможность создавать с дефолтными tank fuel volume и fuel consumption
    // Создать 5 машинок (в main-е), заправить их, завести, и заставить проехать разные расстояния,
    // Должно быть 3 класса - Car и OffRoadMain и класс с исключениями
    // Доделать класс Car методы (refuel, ride, startEngine, stopEngine) c собственными исключениями (Метод ride должен
    // бросать исключение (подумать, какое - checked или unchecked, посмотреть иерархию,
    // почитать про них, посмотреть головача на ютубе, (если не хватило бензина на всю дистанцию)

    // ДЗ2:
    // 1. Вызучить возможные библиотеки для юнит тестов, все самые используемые, разницу тестНЖ и ДжиЮнит (дифф 4 и 5 версии)
    // 2. Жизненный цикл мавен детально изучить, прописывание скоупов в поме
    // 2. Покрыть юниттестами Car Тесты не должны зависеть один от другого и от порядка выполнения.
    //

    /**
     * java doc how to
     * AltInsert hotKeys which add constructor or getter/setter
     * psvm and Enter this is hotKeys which add main method
     */

    private int DEFAULT_TANK_VOLUME = 40;
    private int DEFAULT_FUEL_CONSUMPTION = 50;

    private String make;
    private String model;
    private String color;
    private int fuelConsump = DEFAULT_FUEL_CONSUMPTION;
    private int distance;
    private int tankVolume = DEFAULT_TANK_VOLUME;


    private boolean isIgnitionOn;
    private double currFuel;
    private int odo; //пробег лунохода

    /**
     * - если это entity или DTO - то в конструктор можно хоть 20 параметров. Иначе получается,
     * что бы создать один контейнер, создаём ещё один контейнер
     * - если это специфиеский метод (или конструктор не entity/DTO), в который нужно много всего -
     * то тогда да, есть смысл написать контейнер.
     * А вообще нужно задуматься, как написать, что бы было наиболее понятно и соответствовало общеринятым нормам
     **/

    public static class MakeModelColor {
        String make;
        String model;
        String color;

        public MakeModelColor(String make, String model, String color) {
            this.make = make;
            this.model = model;
            this.color = color;
        }
    }

    /*
    public Moonrider(MakeModelColor makeModelColor, int distance, double currFuel) {
        this(makeModelColor, DEFAULT_FUEL_CONSUMPTION, distance, DEFAULT_TANK_VOLUME, currFuel);
    }
    */

    public Moonrider(MakeModelColor makeModelColor, int fuelConsump, int distance, int tankVolume, double currFuel) {
        if (tankVolume < 1) {
            throw new IllegalArgumentException("Volume of tank any moonrider can not be less 1 liter");
        }
        if (fuelConsump > 60) {
            throw new IllegalArgumentException("Consumption very big - need fix engine");
        }
        if (makeModelColor.color.isEmpty() || makeModelColor.make.isEmpty() || makeModelColor.model.isEmpty() || makeModelColor == null) {
            throw new IllegalArgumentException("make or model or color can not be null or empty");
        }
        this.make = makeModelColor.make;
        this.model = makeModelColor.model;
        this.color = makeModelColor.color;
        this.fuelConsump = fuelConsump;
        this.distance = distance;
        this.tankVolume = tankVolume;
        this.currFuel = currFuel;
    }

    public void setIgnitionOn(boolean ignitionOn) {
        isIgnitionOn = ignitionOn;
    }

    public void startEngine(boolean ignitionOn) {
        setIgnitionOn(ignitionOn);
    }

    public void stopEngine() {
        if (isIgnitionOn) {
            isIgnitionOn = false;
        }
    }

    public int getDistance() {
        return distance;
    }

    public int refuel(int liters) throws MoonriderRefuelingException {//return liters which was added to car after refueling (or specified or full tank)
        System.out.println();
        System.out.println("NEXT MOONRIDER PREPARE TO TRIP ON " + getDistance());
        if (liters < 1) {
            throw new IllegalArgumentException("Cant refuel car on liters" + liters);
        }
        if (isIgnitionOn) {
            throw new MoonriderRefuelingException("Can not refuel because IgnitionOn");
        }
        int freeVolume = (int) (tankVolume - currFuel);
        System.out.println("Free volume in the tank of this Moonride = " + freeVolume);
        if (liters < freeVolume) {
            currFuel = currFuel + liters;
            System.out.println("Refueling! Moonrider was refueling on " + liters + " liters and now in the tank " + currFuel);
            return liters;
        } else {
            currFuel = tankVolume;
            System.out.println("Moonrider was refueling to full tank and now it is " + currFuel + " liters");
            return (int) currFuel;
        }
    }

    //THIS IS NEW VERSION OF METHOD. THE OLD version: return km which had been ridden by any moonrider
    public double ride(MoonRoad road, boolean rideUntilFuelRunsOut) throws MoonriderRefuelingException {
        double ridden = 0.0;
        double ableRide = currFuel / (fuelConsump * road.getType() / 100);
        System.out.println("Start move! Note: Before start Moonrider was refueling and now in the tank " +
                currFuel + " AND for road use rate " + road.getType());
        //if (road.getType()== roadTypes.get("Gravel_moon_road"))
        if (road.getDistance() < 0) {
            throw new IllegalArgumentException("distance can not be <0");
        }
        if (road.getDistance() == 0) {
            System.out.println("Ridden distance = " + 0.0 + " because requirement distance is 0");
        } else if (road.getDistance() <= ableRide) {
            startEngine(true);
            ridden = distance;
            System.out.println("===Moonrider was ridden " + ridden + " km which equals full distance = " + distance);
            currFuel -= (int) (road.getDistance() * (road.getType() * fuelConsump) / 100);  //9.6 литров при 20 входящих
            System.out.println("===Moonrider left currFuel " + currFuel + " liters");
            odo = odo + distance;
            System.out.println("===Moonrider increase odo on " + odo + " km");
            stopEngine();
        } else if (road.getDistance() > ableRide) {
            if (rideUntilFuelRunsOut == false) {
                throw new MoonriderRefuelingException("there's no enough fuel to ride requested distance");
            }
            startEngine(true);
            ridden = ableRide;
            System.out.println("===Moonrider has ridden " + ridden + " km because fuel in the tank is finished");
            odo = (int) (odo + ableRide);
            System.out.println("===Moonrider increase odo on " + odo + " km and after that fuel in the tank is finished");
            currFuel = 0;
        }
        return ridden;
    }

    public double ride(MoonRoad road) throws MoonriderRefuelingException {
        double ridden = 0.0;
        double ableRide = currFuel / (fuelConsump * road.getType() / 100);
        System.out.println("Start move! Note: Before start Moonrider was refueling and now in the tank " +
                currFuel + " AND for road use rate " + road.getType());
        if (road.getDistance() < 0) {
            throw new IllegalArgumentException("distance can not be <0");
        }
        if (road.getDistance() == 0) {
            System.out.println("Ridden distance = " + 0.0 + " because requirement distance is 0");
        } else if (road.getDistance() <= ableRide) {
            startEngine(true);
            ridden = distance;
            System.out.println("===Moonrider was ridden " + ridden + " km which equals full distance = " + distance);
            currFuel = (int) (currFuel - road.getDistance() * (road.getType() * fuelConsump) / 100);
            System.out.println("===Moonrider has left currFuel " + currFuel + " liters");
            odo = odo + distance;
            System.out.println("===Moonrider has increased odo on " + odo + " km");
            stopEngine();
        } else if (road.getDistance() > ableRide) {
            startEngine(true);
            ridden = currFuel / (fuelConsump * road.getType() / 100);
            System.out.println("===Moonrider has ridden " + ridden + " km because fuel in the tank is finished");
            odo = (int) (odo + ableRide);
            System.out.println("===Moonrider increase odo on " + odo + " km and after that fuel in the tank is finished");
            currFuel = 0;
        }
        return ridden;
    }


}
