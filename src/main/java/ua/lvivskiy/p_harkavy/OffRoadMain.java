package ua.lvivskiy.p_harkavy;

import ua.lvivskiy.p_harkavy.moonrider.Moonrider;
import ua.lvivskiy.p_harkavy.moonrider.entity.MoonRoad;
import ua.lvivskiy.p_harkavy.moonrider.exception.MoonriderRefuelingException;


public class OffRoadMain {

    public static void main(String[] args) throws MoonriderRefuelingException {

        /**
         * @param road - instance of class {@link Road}, that encapsulates distance and road type.
         * Road type is a coefficient of fuel consumption,
         * example: for dirt road car consumes 1.2x of standard consumption,
         * for highway car consumes 0.9x respectively.
         * @param rideUntilFuelRunsOut
         * - if 'true', rides  any distance as long as there is fuel
         * - if 'false' - throws exception, if there's no enough fuel to ride requested distance
         * todo: Define it!
         * @return distance was ridden
         * public double ride(Road road, boolean rideUntilFuelRunsOut) {}
         * + добавь ему перегрузку, что бы можно было вызвать ride(road) и ride(road, boolean)
         */
        // Problems&Questions
        // 1) what is found dublicate how to less dublictes
        // 2) make, model, color is grey
        // 2) problem with final static DEFAULT enums
        // 3) пробег лунохода, как правильно задать не нулевой вариант. А стартовый изначальный одо
        // 4) как правильно в классе MoonRoad задать соответсвие типа(коэфициента) и названия лунной дороги (массивы, списки, ЭНАМЫ ...)
        // 5) если мапа это типа хэш мапы как сразу записать всю простыню а не класть по одной паре каждый раз??
        // 6) статик блок и мапа.. как быть?
        // 7) как сделать перегрузку не копируя метод еще раз чтобі кода біло меньше
        // 8) Exceptions - вылетает с коде1 так должно быть? Что можно дописывать в сови классы эксепшенов? Зачем своё городить?

        Moonrider.MakeModelColor makeModelColor1 = new Moonrider.MakeModelColor("moonrider", "0", "metallic");
        Moonrider moonrider0 = new Moonrider(makeModelColor1, 6, 100, 60, 1);
        moonrider0.refuel(80);
        MoonRoad road0 = new MoonRoad(moonrider0.getDistance(), (float) 1.6);
        moonrider0.ride(road0, false);

        Moonrider.MakeModelColor makeModelColor2 = new Moonrider.MakeModelColor("moonrider", "1", "dark-orange");
        Moonrider moonrider1 = new Moonrider(makeModelColor2, 35, 1700, 500, 3);
        moonrider1.refuel(70);
        MoonRoad road1 = new MoonRoad(moonrider1.getDistance(), (float) 0.9);
        moonrider1.ride(road1);

        Moonrider.MakeModelColor makeModelColor3 = new Moonrider.MakeModelColor("moonrider", "17", "bright-blue");
        Moonrider moonrider17 = new Moonrider(makeModelColor3, 50, 1000, 500, 5);
        moonrider17.refuel(30);
        MoonRoad road17 = new MoonRoad(moonrider17.getDistance(), (float) 1.2);
        moonrider17.ride(road17, true);

        Moonrider.MakeModelColor makeModelColor4 = new Moonrider.MakeModelColor("moonrider", "2", "bright-blue");
        Moonrider moonrider2 = new Moonrider(makeModelColor4, 4, 1400, 400, 9);
        moonrider2.refuel(30);
        MoonRoad road2 = new MoonRoad(moonrider2.getDistance(), (float) 1.4);
        moonrider2.ride(road2);

        Moonrider.MakeModelColor makeModelColor5 = new Moonrider.MakeModelColor("moonrider", "3", "x-rays");
        Moonrider moonrider3 = new Moonrider(makeModelColor5, 7, 1600, 45, 11);
        moonrider3.refuel(300);
        MoonRoad road3 = new MoonRoad(moonrider3.getDistance(), (float) 1.4);
        moonrider3.ride(road3, false);

    }
}
