package ua.lvivskiy.p_harkavy.collections_samples.arraylist_samples;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntsArrayListTest {

    private IntsArrayList arrList;
    @Before
    public void setup() {
        arrList = new IntsArrayList();
        arrList.add(1);
        arrList.add(2);
    }

    @Test
    public void checkCorrectnessOfAddedElements() {
        assertEquals(arrList.data[0], 1);
        assertEquals(arrList.data[1], 2);
        assertEquals(arrList.data[2], 0);
    }

    @Test
    public void add1() {
        arrList.add(6, 7);
        for (int i=0; i<12; i++) {
            arrList.data[i]=i;
        }
    }

    @Test
    public void remove() {
    }

    @Test
    public void remove1() {
    }
}