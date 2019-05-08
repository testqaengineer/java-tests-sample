package ua.lvivskiy.p_harkavy;

import ua.lvivskiy.p_harkavy.car.entity.Car;
import ua.lvivskiy.p_harkavy.car.exception.IgnitionOnException;

/**
 * todo: will be done later
 */
public class RacingMain {

    public static void main(String... args) throws Exception {
        Car car1 = new Car("Renault", "White", 60, 0);

        try {
            car1.refuel(1);
        } catch (IgnitionOnException e) {
            car1.setIgnitionOn(false);

            car1.refuel(1);
        }
    }
}
