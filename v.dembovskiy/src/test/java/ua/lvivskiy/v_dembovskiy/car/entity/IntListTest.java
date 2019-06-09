package ua.lvivskiy.v_dembovskiy.car.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntListTest {

    IntList intList = new IntList();

    @Test
    public void arrayGrowsCorrectly() {
        IntList intList = new IntList(1);
        for (int a = 0; a < 5; a++) {
            intList.add(a);
        }
        assertEquals(intList.size(), 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addWithIllegalIndex() {
        intList.add(1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addUsingNegativeIndex() {
        intList.add(0, 1);
        intList.add(-5, 5);
    }

    @Test
    public void addConsecutiveValueByIndex() {
        intList.add(0, 1);
        intList.add(1, 2);
        assertEquals(intList.get(0), 1);
        assertEquals(intList.get(1), 2);
        assertEquals(intList.size(), 2);
    }

    @Test
    public void removeValue() {
        for (int a = 0; a < 10; a++) {
            intList.add(a);
        }
        intList.remove(5);
        assertEquals(intList.get(5), 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeUsingIncorrectIndex() {
        for (int a = 0; a < 10; a++) {
            intList.add(a);
        }
        intList.remove(11);
    }

    @Test
    public void getValue() {
        intList.add(1);
        assertEquals(intList.get(0), 1);
    }

    @Test
    public void size() {
        intList.add(1);
        assertEquals(intList.size(), 1);
    }

    @Test
    public void trimToSize() {
        intList.add(1);
        intList.trimToSize();
        assertEquals(intList.size(), 1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void insertInTheMiddle() {
        for (int a = 0; a < 5; a++) {
            intList.add(a);
        }
        System.out.println(intList);
        intList.add(7, 7777);
    }
}