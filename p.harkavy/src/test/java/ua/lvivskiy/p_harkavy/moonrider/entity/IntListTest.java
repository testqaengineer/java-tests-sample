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

    @Test
    public void testSizeOfListWithoutData() {
        il.add(48);
        il.remove(0);
        assertEquals(0, il.size());
    }

    // ERROR Why I can add char? But can not put String
    @Test
    public void testSizeOfsListWithUncommonData() {
        il.add('1');
        il.add('W');
        //il.add("Love");
        assertEquals(2, il.size());
    }

    @Test
    public void testSizesOfOneTimeIncreasedLists() {
        for (int i=0; i<15; i++) {
            il.add(i);
        }
        assertEquals(15, il.size());
    }

    @Test
    public void testSizeOfVeryBigList() {
        for (int i=0; i<150; i++) {
            il.add(i);
        }
        assertEquals(150, il.size());
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

    @Test
    public void testGetCorrectValueOfIndexAfterIncreaseList() {
        for (int i=0; i<15; i++) {
            il.add(i);
        }
        assertEquals(14, il.get(14));
    }

    @Test
    public void testGetCorrectValueOfIndexBigList() {
        for (int i=0; i<150; i++) {
            il.add(i);
        }
        assertEquals(149, il.get(149));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetValueOfIncorrectIndex() {
        il.get(10);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetUnCorrectValueOfIndexBigList() {
        for (int i=0; i<150; i++) {
            il.add(i);
        }
        il.get(150);
    }











    @Test
    public void testAdd1500Value() {
        for (int i=0; i<1500; i++) {
            il.add(i);
        }
        assertEquals(1500, il.size());
        assertEquals(1499, il.get(1499));
    }

    // 1. ERROR Why I can not add chars? Is it correct write two expectations
    @Test //(expected = IndexOutOfBoundsException.class)
    public void testAdd50UncorrectValue() {
        il.add('1');
        for (int i=1; i<50; i++) {
            il.add('f');
        }
        assertEquals(50, il.size());
        assertEquals('f', il.get(49));
    }











    @Test
    public void testAddManySameValuesByIndex() {
        for (int i=0; i<300; i++) {
            il.add(i, 77);
        }
        assertEquals(300, il.size());
        assertEquals(77, il.get(299));
        assertEquals(77, il.get(0));
        assertEquals(77, il.get(150));
    }

    @Test
    public void testAddValueByIndexToNotEmptyList() {
        for (int i=0; i<100; i++) {
            il.add(i, i++);
        }
        il.add(0, -100);
        il.add(99, -99);
        il.add(50, -50);
        assertEquals(103, il.size());
        assertEquals(-100, il.get(0));
        assertEquals(-50, il.get(50));
        assertEquals(-99, il.get(99));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddValueByUncorrectIndexToNotEmptyList() {
        for (int i=0; i<100; i++) {
            il.add(i, i++);
        }
        assertEquals(100, il.get(99));
        il.add(100, -100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddValueByNegativeIndexToNotEmptyList() {
        for (int i=0; i<10; i++) {
            il.add(i, i++);
        }
        il.add(-1, -1);
    }








    @Test
    public void testRemoveValueByIndexInNotEmptyList() {
        for (int i=0; i<100; i++) {
            il.add(i, i++);
        }
        assertEquals(100, il.get(99));
        il.remove(99);
        assertEquals(99, il.get(98));
        il.remove(0);
        assertEquals(0, il.get(0));
        assertEquals(98, il.size());
        assertEquals(97, il.remove(97));
    }
















}
