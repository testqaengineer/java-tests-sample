package ua.lvivskiy.p_harkavy.moonrider.entity;

import ua.lvivskiy.p_harkavy.moonrider.exception.MoonriderOdoException;
import ua.lvivskiy.p_harkavy.moonrider.exception.MoonriderRefuelingException;

public class Moonrider {

    // ДЗ1:
    // Написать класс Moonrider (model, color, fuel consumption, odo(одометр), curr fuel level, tank volume, ignition (on/off))
    // машины должны ездить(только если заведены), методы: turnOn(startEngine), turnOff(stopEngine), ride(distance), refuel(liters)
    // Конструкторы должны быть с перегрузкой (сделать возможность создавать с дефолтными tank fuel volume и fuel consumption
    // Создать 5 машинок (в main-е), заправить их, завести, и заставить проехать разные расстояния,
    // Должно быть 3 класса - Car и OffRoadMain и класс с исключениями
    // Доделать класс Car методы (refuel, ride, startEngine, stopEngine) c собственніми исключениями (Метод ride должен
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

    private static int DEFAULT_TANK_VOLUME = 40;
    private static int DEFAULT_FUEL_CONSUMPTION = 50;

    private final String make;
    private String model;
    private String color;
    private final int fuelConsump = DEFAULT_FUEL_CONSUMPTION;
    private int distance;
    private final int tankVolume = DEFAULT_TANK_VOLUME;


    private boolean isIgnitionOn;
    private int currFuel;
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

    public Moonrider(MakeModelColor makeModelColor, int distance) {
        this(makeModelColor, DEFAULT_FUEL_CONSUMPTION, distance, DEFAULT_TANK_VOLUME);
    }

    public Moonrider(MakeModelColor makeModelColor, int fuelConsump, int distance, int tankVolume) {
        if (tankVolume < 1) {
            throw new IllegalArgumentException("Volume of tank any moonrider can not be less 1 liter");
        }
        if (fuelConsump > 60) {
            throw new IllegalArgumentException("Consumption very big - need fix engine");
        }
        if (makeModelColor.color.isEmpty() || makeModelColor.make.isEmpty() || makeModelColor.model.isEmpty() || makeModelColor == null) {
            throw new IllegalArgumentException("makeModelColor can not be null or empty");
        }
        this.make = makeModelColor.make;
        this.model = makeModelColor.model;
        this.color = makeModelColor.color;
        this.distance = distance;
    }

    public void setIgnitionOn(boolean ignitionOn) {
        isIgnitionOn = ignitionOn;
    }

    public void startEngine(boolean ignitionOn) {
        setIgnitionOn(ignitionOn);
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getOdo() {
        return odo;
    }

    public int getCurrFuel() {
        return currFuel;
    }

    public int refuel(int liters) {//return liters which was added to car after refueling (or specified or full tank)
        if (liters < 1) {
            throw new IllegalArgumentException("Cant refuel car on liters" + liters);
        }
        if (isIgnitionOn) {
            throw new MoonriderRefuelingException("Can not refuel because IgnitionOn");
        }
        int freeVolume = tankVolume - currFuel;
        if (liters < freeVolume) {
            currFuel = currFuel + liters;
            return liters;
        } else {
            currFuel = tankVolume;
            return currFuel;
        }
    }


    //Если да - то это очень неэфективно, ты же сразу модешь понять, на сколько увеличится одо и насколько уменьшится fuelLevel

    public int ride(int distance) { //return km which had been ridden by any moonrider (after ridden 1 km increase odo and decreases currFuel)
        if (odo > 1000) {
            throw new MoonriderOdoException("Odo very big - need fix or replace engine");
        }
        currFuel = currFuel - fuelConsump / 100;
        odo = currFuel / distance;

        for (int i = 0; i < distance; i++) {
            distance = i;

            if (odo <= 1 / distance) {
                throw new MoonriderOdoException("Moonrider rover is critical - need replacement or fix engine");
            }

            if (currFuel <= 1) {
                throw new MoonriderRefuelingException("Moonrider current fuel is small - need refuel again");
            }
        }

        return distance;
    }
}
