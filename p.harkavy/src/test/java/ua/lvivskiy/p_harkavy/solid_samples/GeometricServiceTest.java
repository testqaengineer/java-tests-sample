package ua.lvivskiy.p_harkavy.solid_samples;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeometricServiceTest {

    private GeometricService gs = new GeometricService();

    @Test
    public void areaOfCompare1() {
        Figure r = new Rectangle(9, 7);
        Figure s = new Square(8);
        assertTrue(gs.compareArea(r, s) < 0);
    }

    @Test
    public void areaOfCompare2() {
        Figure r = new Rectangle(9, 7);
        Figure c = new Circle(7);
        assertTrue(gs.compareArea(r, c) < 0);
    }
}