package ua.lvivskiy.v_dembovskiy.car.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntListTest {

    IntList intList = new IntList();

    @Test
    public void addThousandValues() {
        for (int a = 0; a < 1000; a++) {
            intList.add(a);
        }
        assertEquals(intList.size(), 1000);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addUsingIncorrectIndex() {
        for (int a = 0; a < 10; a++) {
            intList.add(a);
        }
        intList.add(100, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addUsingNegativeIndex() {
        for (int a = 0; a < 10; a++) {
            intList.add(a);
        }
        intList.add(-5, 5);
    }

    @Test
    public void addValueByIndex() {
        for (int a = 0; a < 10; a++) {
            intList.add(a);
        }
        intList.add(5, 77);
        assertEquals(intList.get(5), 77);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithIncorrectIndex() {
        for (int a = 0; a < 10; a++) {
            intList.add(a);
        }
        intList.add(20, 77);
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
        for (int a = 0; a < 10; a++) {
            intList.add(a + 10);
        }
        for (int a = 0; a < 10; a++) {
            assertEquals(intList.get(a), a + 10);
        }
    }

    @Test
    public void size() {
        for (int a = 0; a < 5; a++) {
            intList.add(a);
        }
        assertEquals(intList.size(), 5);
    }

    @Test
    public void trimToSize() {
        for (int a = 0; a < 11; a++) {
            intList.add(a);
        }
        intList.trimToSize();
        assertEquals(intList.size(), 11);
    }
}