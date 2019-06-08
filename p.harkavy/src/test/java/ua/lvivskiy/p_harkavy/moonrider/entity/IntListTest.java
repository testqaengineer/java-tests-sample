package ua.lvivskiy.p_harkavy.moonrider.entity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.lvivskiy.p_harkavy.car.entity.IntList;
import ua.lvivskiy.p_harkavy.moonrider.exception.MoonriderRefuelingException;

import static org.junit.Assert.assertEquals;

public class IntListTest {

    private IntList il;

    @Before
    public void setUp() {
        il = new IntList();
    }

    @Test
    public void testSizesOfNewsLists() {
        assertEquals(0, il.size());
    }

    @Test
    public void testSizesOfDiffsLists() {
        il.add(100);
        il.add(0);
        assertEquals(2, il.size());
    }




}
