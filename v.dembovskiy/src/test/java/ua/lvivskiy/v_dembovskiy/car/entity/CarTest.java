package ua.lvivskiy.v_dembovskiy.car.entity;

import org.junit.Test;
import ua.lvivskiy.v_dembovskiy.car.exeption.IgnitionOffException;
import ua.lvivskiy.v_dembovskiy.car.exeption.IgnitionOnException;
import ua.lvivskiy.v_dembovskiy.car.exeption.OutOfFuelException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
public class CarTest {

    public static double DELTA = 0.00000001;

    /*
    @Parameterized.Parameters
    public static List<Double> boundaryValues() {
        return Arrays.asList(-1.0, 0.0, 51.0, 100.0);
    }
    @Parameterized.Parameter
    public double liters;
    */

    private Car.MakesModels makesModels = new Car.MakesModels("BMW", "Red", 50);
    private Car car = new Car(makesModels, 10000, 25.0, 10, false);


    @Test
    public void refuelWithCorrectValues() throws IgnitionOnException {
        car.refuel(10.0);
        assertEquals(car.getCurrFuelLevel(), 35.0, DELTA);
    }

    @Test
    public void refuelWithBoundaryValue1s() {
        List<Double> invalidRefuelingVal = new ArrayList<>(Arrays.asList(0.99, -1.0, 0.0, 51.0));

        for (Double invalidVal : invalidRefuelingVal) {
            try {
                car.refuel(invalidVal);

                fail("Expected exeption isn`t thrown when refuel car with " + invalidVal + " value");
            } catch (IgnitionOnException | IllegalArgumentException e) {
                continue;
            }
        }
    }

    @Test(expected = IgnitionOnException.class)
    public void refuelWhileIgnitionOn() throws IgnitionOnException {
        car.setIsIgnitionOn(true);
        car.refuel(10.0);
    }

    @Test
    public void rideWithCorrectValues() throws OutOfFuelException, IgnitionOnException, IgnitionOffException {
        double fuelValueBeforeRide = car.getCurrFuelLevel();
        int odo = car.getOdo();
        car.startEngine();
        car.ride(100);
        assertEquals(car.getOdo(), odo + 100);
        assertEquals(car.getCurrFuelLevel(), fuelValueBeforeRide - 10.0, DELTA);
    }

    @Test
    public void rideWithBoundaryValue1s() {

        List<Integer> invalidRideVal = new ArrayList<>(Arrays.asList(-1, -100));
        double fuelValueBeforeRide = car.getCurrFuelLevel();
        int odo = car.getOdo();
        for (int invalidVal : invalidRideVal) {
            try {
                car.ride(invalidVal);
                assertEquals(car.getOdo(), odo);
                assertEquals(car.getCurrFuelLevel(), fuelValueBeforeRide, DELTA);
                fail("Expected exeption isn`t thrown when refuel car with " + invalidVal + " value");
            } catch (IllegalArgumentException | IgnitionOffException | OutOfFuelException e) {
                continue;
            }
        }
    }

    @Test
    public void rideWithValue0Km() throws OutOfFuelException, IgnitionOffException {
        double fuelValueBeforeRide = car.getCurrFuelLevel();
        int odo = car.getOdo();
        car.ride(0);
        assertEquals(car.getOdo(), odo);
        assertEquals(car.getCurrFuelLevel(), fuelValueBeforeRide, DELTA);
    }

    @Test(expected = OutOfFuelException.class)
    public void rideWithInsufficientFuel() throws Exception {
        int odo = car.getOdo();
        car.startEngine();
        car.ride(10_000);
        assertEquals(car.getOdo(), odo + 250);
    }

    @Test()
    public void startEngine() throws IgnitionOnException {
        car.startEngine();
        assertTrue(car.getIsIgnitionOn());
    }

    @Test(expected = IgnitionOnException.class)
    public void startEngineWhenNotEnoughFuel() throws Exception {
        car.setCurrFuelLevel(0.9);
        car.startEngine();
        assertFalse(car.getIsIgnitionOn());
    }

    @Test()
    public void stopEngine() {
        car.stopEngine();
        assertFalse(car.getIsIgnitionOn());
    }


}