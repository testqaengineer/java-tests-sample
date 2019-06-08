package ua.lvivskiy.p_harkavy.moonrider.entity;

import org.junit.Before;
import org.junit.Test;
import ua.lvivskiy.p_harkavy.car.entity.IntList;

import static org.junit.Assert.assertEquals;

public class IntListTest {

    private IntList il;

    @Before
    public void setUp() {
        il = new IntList();
    }

    @Test
    public void testSizeOfNewList() {
        assertEquals(0, il.size());
    }

    @Test
    public void testSizeOfListWithCorrectData() {
        il.add(100);
        il.add(0);
        assertEquals(2, il.size());
    }

    //??
    @Test
    public void testSizeOfListWithoutData() {
        il.add(48);
        il.remove(0);
        assertEquals(0, il.size());
    }

    // ERROR Why I can add char
    @Test
    public void testSizeOfsListWithUncommonData() {
        il.add('1');
        il.add('W');
        //il.add("Love");
        assertEquals(0, il.size());
    }

    @Test
    public void testSizesOfOneTimeIncreasedLists() {
        for (int i=0; i<15; i++) {
            il.add(i);
        }
        assertEquals(15, il.size());
    }

    //ERROR
    @Test
    public void testSizeOfVeryBigList() {
        for (int i=0; i<150; i++) {
            il.add(i);
        }
        assertEquals(149, il.size());
    }






    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetValueOfIndexFromEmptyList() {
        il.get(0);
    }

    @Test
    public void testGetCorrectValueOfIndex() {
        il.add(567);
        il.add(888);
        assertEquals(567, il.get(0));
        assertEquals(888, il.get(1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetValueOfIncorrectIndex() {
        il.get(10);
    }

    @Test
    public void testGetCorrectValueOfIndexAfterIncreaseList() {
        for (int i=0; i<15; i++) {
            il.add(i);
        }
        assertEquals(14, il.get(14));
    }

    //ERROR
    @Test
    public void testGetCorrectValueOfIndexBigList() {
        for (int i=0; i<150; i++) {
            il.add(i);
        }
        assertEquals(149, il.get(149));
    }





}
