package ua.lvivskiy.p_harkavy.car.entity;

import org.junit.*;
import ua.lvivskiy.p_harkavy.car.exception.IgnitionException;

import static org.junit.Assert.assertEquals;

public class CarTest {

    private Car car = new Car("Renault", "blue", 10);

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Once before class");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before each test method");
    }

    @Test(expected = IgnitionException.class)
    public void startEngine() throws Exception {
        car.startEngine();
    }

    @Test
    public void refuel() throws Exception {
        car.refuel(15);

        assertEquals(car.getFuelLevel(), 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void refuelWithInvalidVal() throws Exception {
        car.refuel(-1);
    }

    @Test(expected = IgnitionException.class)
    public void refuelStartedCar() throws Exception {
        car.refuel(10);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After each test method");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("Once after class");
    }
}
