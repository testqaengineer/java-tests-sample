package ua.lvivskiy.p_harkavy.moonrider.entity;

import org.junit.Test;
import ua.lvivskiy.p_harkavy.moonrider.Moonrider;
import ua.lvivskiy.p_harkavy.moonrider.exception.MoonriderRefuelingException;

import static org.junit.Assert.*;

public class MoonriderTest {

    @Test
    public void refuel() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColor1 = new Moonrider.MakeModelColor("moonrider", "test", "1");
        Moonrider moonrider_test1=new Moonrider(makeModelColor1, 1, 100, 4, 1);
        int currRefuelTillRefueling= (int) moonrider_test1.getCurrFuel();
        moonrider_test1.refuel(3);
        assertEquals((long) moonrider_test1.getCurrFuel(), 3+currRefuelTillRefueling);
    }

    @Test
    public void refuelOnLitersWhichVerySmallLessThen1() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColor0 = new Moonrider.MakeModelColor("moonrider", "test", "0");
        Moonrider moonrider_test0=new Moonrider(makeModelColor0, 1, 100, 4, 1);
        int currRefuelTillRefueling= (int) moonrider_test0.getCurrFuel();
        moonrider_test0.refuel(0.5);
        assertEquals((long) moonrider_test0.getCurrFuel(), (long) 0.5+currRefuelTillRefueling);
    }

    @Test
    public void refuelWhenIsIgnitionOn() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColorWithIgnition = new Moonrider.MakeModelColor("moonrider", "test", "WithIgnition");
        Moonrider moonrider_testWithIgnition=new Moonrider(makeModelColorWithIgnition, 1, 100, 4, 1);
        int currRefuelTillRefueling= (int) moonrider_testWithIgnition.getCurrFuel();
        moonrider_testWithIgnition.startEngine(true);
        moonrider_testWithIgnition.refuel(1.5);
        assertEquals((long) moonrider_testWithIgnition.getCurrFuel(), (long) 1.5+currRefuelTillRefueling);
    }


    @Test
    public void refuelAfterIgnitionOff() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColorAfterIgnitionOff = new Moonrider.MakeModelColor("moonrider", "test", "AfterIgnitionOff");
        Moonrider moonrider_testAfterIgnitionOff=new Moonrider(makeModelColorAfterIgnitionOff, 1, 100, 4, 1);
        int currRefuelTillRefueling= (int) moonrider_testAfterIgnitionOff.getCurrFuel();
        moonrider_testAfterIgnitionOff.startEngine(true);
        moonrider_testAfterIgnitionOff.stopEngine();
        moonrider_testAfterIgnitionOff.refuel(10.5);
        assertEquals((long) moonrider_testAfterIgnitionOff.getCurrFuel(), (long) 10.5+currRefuelTillRefueling);
    }

    @Test
    public void refuelTankOnZeroLitersWhenTankNotEmpty() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColor2 = new Moonrider.MakeModelColor("moonrider", "test", "2");
        Moonrider moonrider_test2=new Moonrider(makeModelColor2, 2, 400, 40, 1);
        int currRefuelTillRefueling= (int) moonrider_test2.getCurrFuel();
        moonrider_test2.refuel(0);
        assertEquals((long) moonrider_test2.getCurrFuel(), 0+currRefuelTillRefueling);
    }

    @Test
    public void refuelTankOnZeroLitersWhenTankIsEmpty() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColor3 = new Moonrider.MakeModelColor("moonrider", "test", "3");
        Moonrider moonrider_test3=new Moonrider(makeModelColor3, 3, 400, 40, 0);
        int currRefuelTillRefueling= (int) moonrider_test3.getCurrFuel();
        moonrider_test3.refuel(0);
        assertEquals((long) moonrider_test3.getCurrFuel(), 0+currRefuelTillRefueling);
    }

    @Test
    public void refuelTankIfSizeOfTankIsEmpty() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColor4 = new Moonrider.MakeModelColor("moonrider", "test", "3");
        Moonrider moonrider_test4=new Moonrider(makeModelColor4, 4, 400, 0, 0);
        int currRefuelTillRefueling= (int) moonrider_test4.getCurrFuel();
        moonrider_test4.refuel(5);
        assertEquals((long) moonrider_test4.getCurrFuel(), 5+currRefuelTillRefueling);
    }

    @Test
    public void refuelOnLitersWhichMoreThenTankVolume() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColor5 = new Moonrider.MakeModelColor("moonrider", "test", "1");
        Moonrider moonrider_test5=new Moonrider(makeModelColor5, 5, 100, 4, 1);
        int currRefuelTillRefueling= (int) moonrider_test5.getCurrFuel();
        moonrider_test5.refuel(30);
        assertEquals((long) moonrider_test5.getCurrFuel(), 30+currRefuelTillRefueling);
    }

    @Test
    public void refuelOnLitersWhereCurrFuelLevelMoreThenTankVolume() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColor6 = new Moonrider.MakeModelColor("moonrider", "test", "1");
        Moonrider moonrider_test6=new Moonrider(makeModelColor6, 6, 100, 4, 100);
        int currRefuelTillRefueling= (int) moonrider_test6.getCurrFuel();
        moonrider_test6.refuel(2);
        assertEquals((long) moonrider_test6.getCurrFuel(), 2+currRefuelTillRefueling);
    }

    @Test
    public void refuelOnLitersWhereFuelLevelAfterRefuelingMoreThenTankVolume() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColor7 = new Moonrider.MakeModelColor("moonrider", "test", "1");
        Moonrider moonrider_test7=new Moonrider(makeModelColor7, 7, 100, 40, 20);
        int currRefuelTillRefueling= (int) moonrider_test7.getCurrFuel();
        moonrider_test7.refuel(200);
        assertEquals((long) moonrider_test7.getCurrFuel(), 200+currRefuelTillRefueling);
    }

    @Test
    public void refuelOnToNegativeNumberOfLiters() throws MoonriderRefuelingException {
        Moonrider.MakeModelColor makeModelColor8 = new Moonrider.MakeModelColor("moonrider", "test", "1");
        Moonrider moonrider_test8=new Moonrider(makeModelColor8, 1, 100, 4, 1);
        int currRefuelTillRefueling= (int) moonrider_test8.getCurrFuel();
        moonrider_test8.refuel(-33);
        assertEquals((long) moonrider_test8.getCurrFuel(), -33+currRefuelTillRefueling);
    }


}