package ua.lvivskiy.v_dembovskiy.car.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.lvivskiy.v_dembovskiy.car.exeption.IgnitionOnException;
import ua.lvivskiy.v_dembovskiy.car.exeption.OutOfFuelException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
public class CarTest {

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
    public void refuel() throws IgnitionOnException {
        car.refuel(10.0);
        assertEquals(car.getCurrFuelLevel(), 35.0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void refuelWithInvalidValue1() throws IgnitionOnException {
        car.refuel(0.99);
    }

    @Test(expected = IllegalArgumentException.class)
    public void refuelWithInvalidValue2() throws IgnitionOnException {
        car.refuel(-1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void refuelWithInvalidValue3() throws IgnitionOnException {
        car.refuel(0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void refuelWithInvalidValue4() throws IgnitionOnException {
        car.refuel(51.0);
    }

    @Test(expected = IgnitionOnException.class)
    public void refuelWhileIgnitionOn() throws IgnitionOnException {
        car.setIsIgnitionOn(true);
        car.refuel(10.0);
    }


    @Test
    public void ride() throws IgnitionOnException, OutOfFuelException {
        double fuelValueBeforeRide = car.getCurrFuelLevel();
        int odo = car.getOdo();
        car.ride(100);
        assertEquals(car.getOdo(), odo + 100);
        assertEquals(car.getCurrFuelLevel(), fuelValueBeforeRide - 10.0, 2);
    }

    @Test
    public void ride2() throws IgnitionOnException, OutOfFuelException {
        double fuelValueBeforeRide = car.getCurrFuelLevel();
        int odo = car.getOdo();
        car.ride(0);
        assertEquals(car.getOdo(), odo);
        assertEquals(car.getCurrFuelLevel(), fuelValueBeforeRide, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rideWithInvalidValue1() throws IgnitionOnException, OutOfFuelException {
        int odo = car.getOdo();
        car.ride(-1);
        assertEquals(car.getOdo(), odo);
    }

    @Test(expected = OutOfFuelException.class)
    public void rideWithInvalidValue2() throws Exception {
        int odo = car.getOdo();
        car.ride(10_000);
        assertEquals(car.getOdo(), odo + 250);
    }


    @Test()
    public void startEngine() throws IgnitionOnException {
        car.startEngine();
        assertTrue(car.getIsIgnitionOn());
    }

    @Test(expected = IgnitionOnException.class)
    public void startEngineNotEnoughFuel() throws Exception {
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