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
    public void checkCorrectnessOfAddedElementsToTail() {
        assertEquals(1, arrList.get(0).intValue());
        assertEquals(2, arrList.get(1).intValue());
    }

    @Test
    public void checkCorrectnessOfRemoveElementsFromTail() {
        arrList.remove();
        arrList.add(200);
        assertEquals(200, arrList.get(1).intValue());
    }

    @Test
    public void checkCorrectnessOfAddedElementsToAnyWhere() {
        arrList.add(3);
        arrList.add(4);

        arrList.add(4, 170);
        arrList.add(0, 170);
        arrList.add(3, 170);

        assertEquals(170, arrList.get(4).intValue());
        assertEquals(170, arrList.get(0).intValue());
        assertEquals(170, arrList.get(3).intValue());
    }

    @Test
    public void checkCorrectnessOfRemoveElementsFromAnyWhere() {


    }
}