package ua.lvivskiy.p_harkavy;

import ua.lvivskiy.p_harkavy.car.entity.Car;
import ua.lvivskiy.p_harkavy.car.exception.IgnitionException;

/**
 * todo: will be done later
 */
public class RacingMain {

    public static void main(String... args) throws Exception {
        Car car1 = new Car("Renault", "White", 60, 0);

        try {
            car1.refuel(1);
        } catch (IgnitionException e) {
            car1.stopEngine();

            car1.refuel(1);
        }
    }
}
