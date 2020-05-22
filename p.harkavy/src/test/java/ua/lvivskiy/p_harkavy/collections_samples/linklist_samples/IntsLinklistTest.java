
package ua.lvivskiy.p_harkavy.collections_samples.linklist_samples;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class IntsLinklistTest {

    private IntsLinklist intsLinklist;

    @Before
    public void setUp() {
        intsLinklist = new IntsLinklist();
        intsLinklist.add(0);
        intsLinklist.add(1);
        intsLinklist.add(2);
    }

    @Test
    public void testOrderOfAddingAndSize() {
        System.out.println(intsLinklist.toString());
        assertEquals(1, intsLinklist.get(1).intValue());
        assertEquals(2, intsLinklist.get(2).intValue());
        assertEquals(3, intsLinklist.size());
    }

    @Test
    public void testTheSameOfAddingAndSize() {
        intsLinklist.add(2);
        intsLinklist.add(1);
        intsLinklist.add(0);
        assertEquals(2, intsLinklist.get(2).intValue());
        System.out.println(intsLinklist.toString());
        assertEquals(2, intsLinklist.get(3).intValue());
        assertEquals(1, intsLinklist.get(4).intValue());
        assertEquals(6, intsLinklist.size());
    }

    @Test
    public void testOfAddingToMiddleAndSize() {
        intsLinklist.add(3);
        intsLinklist.add(4);
        intsLinklist.add(2, 100);
        System.out.println(intsLinklist.toString());
        assertEquals(100, intsLinklist.get(2).intValue());
        assertEquals(6, intsLinklist.size());
    }

    @Test
    public void testOfRemovingFromMiddleByIndexAndSize() {
        intsLinklist.add(3);
        intsLinklist.add(4);
        assertEquals(5, intsLinklist.size());
        intsLinklist.remove(2);
        assertEquals(4, intsLinklist.size());
        System.out.println(intsLinklist.toString());
        assertEquals(3, intsLinklist.get(2).intValue());
    }

    @Test
    public void testOfRemovingFromMiddleByObjectAndSize() {
        intsLinklist.add(300);
        intsLinklist.add(400);
   //     intsLinklist.remove(Integer (300));
        System.out.println(intsLinklist.toString());
        assertEquals(4, intsLinklist.size());
        //System.out.println(intsLinklist.toString());
        //assertEquals(3, intsLinklist.get(2).intValue());
    }

    @Test
    public void testOfSettingToMiddleAndSize() {
        intsLinklist.add(3);
        intsLinklist.add(4);
        System.out.println(intsLinklist.toString());
        intsLinklist.set(2, 100);
        assertEquals(5, intsLinklist.size());
        System.out.println(intsLinklist.toString());
        assertEquals(100, intsLinklist.get(2).intValue());
        assertEquals(3, intsLinklist.get(3).intValue());
    }

    @Test
    public void testOfGettingByIndexAndSize() {
        intsLinklist.add(3);
        intsLinklist.add(4);
        System.out.println(intsLinklist.toString());
        assertEquals(2, intsLinklist.get(2).intValue());
        assertEquals(5, intsLinklist.size());
        assertEquals(4, intsLinklist.get(4).intValue());
        assertEquals(0, intsLinklist.get(0).intValue());
    }

    @Test
    public void testIsEmptyMethodAndSize() {
        assertEquals(3, intsLinklist.size());
        assertEquals(false, intsLinklist.isEmpty());
        intsLinklist.remove(2);
        intsLinklist.remove(1);
        assertEquals(1, intsLinklist.size());
        intsLinklist.remove(0);
        assertEquals(0, intsLinklist.size());
        assertEquals(true, intsLinklist.isEmpty());
    }

    @Test
    public void testContainsMethodAndSize() {
        assertEquals(true, intsLinklist.contains(2));
        intsLinklist.add(300);
        intsLinklist.add(400);
        assertEquals(true, intsLinklist.contains(0));
        assertEquals(true, intsLinklist.contains(2));
        assertEquals(true, intsLinklist.contains(300));
        assertEquals(5, intsLinklist.size());
    }

    @Test
    public void testIndexOfMethodAndSize() {
        assertEquals(2, intsLinklist.indexOf(2));
        assertEquals(3, intsLinklist.size());
        intsLinklist.add(3);
        assertEquals(3, intsLinklist.indexOf(3));
        assertEquals(1, intsLinklist.indexOf(1));
    }

    @Test
    public void testLastIndexOfMethodAndSize() {
        intsLinklist.add(2);
        intsLinklist.add(1);
        intsLinklist.add(0);
        assertEquals(5, intsLinklist.lastIndexOf(0));
        assertEquals(6, intsLinklist.size());
        assertEquals(4, intsLinklist.lastIndexOf(1));
        intsLinklist.add(1);
        intsLinklist.add(100);
        intsLinklist.add(1);
        intsLinklist.add(100);
        assertEquals(8, intsLinklist.lastIndexOf(1));
        assertEquals(9, intsLinklist.lastIndexOf(100));
    }








    @Test
    public void testPrintGeneratedListFromTail() {
        intsLinklist.generateIterableFromTail(12);
        System.out.println(intsLinklist.toString());
        //Arrays.toString(intsLinklist.toArray())
    }

    @Test
    public void testPrintGeneratedListFromHead() {
        intsLinklist.generateIterableFromHead(18);
        System.out.println(Arrays.toString(intsLinklist.toArray()));
    }

    @Test
    public void testSizeGeneratedListFromTail() {
        intsLinklist.generateIterableFromTail(12);
        System.out.println(Arrays.toString(intsLinklist.toArray()));
        //intsLinklist.size();
        System.out.println("sizeOfThisLinkedList = " + intsLinklist.size());
    }

    @Test
    public void testSumGeneratedListFromTail() {
        intsLinklist.generateIterableFromTail(12);
        System.out.println(Arrays.toString(intsLinklist.toArray()));
        intsLinklist.sum();
    }

    @Test
    public void testMaxGeneratedListFromTail() {
        intsLinklist.generateIterableFromTail(12);
        System.out.println(Arrays.toString(intsLinklist.toArray()));
        intsLinklist.max();
    }

    @Test
    public void addToEmpty() {
        intsLinklist.add(190);
        assertEquals(1, intsLinklist.size());
        assertEquals(190, intsLinklist.get(0).intValue());
    }

    @Test
    public void removeFromMiddle() {
        intsLinklist.add(1);
        intsLinklist.add(2);
        intsLinklist.add(3);
        intsLinklist.add(4);
        intsLinklist.add(5);
        System.out.println(intsLinklist);
        intsLinklist.remove(2);
        System.out.println(intsLinklist);
        assertEquals(4, intsLinklist.size());
    }

    @Test
    public void testSuccessAdding() {
        //assertTrue(intsLinklist.add(100500));
    }
}

/*
    @Test
    public void testContainsAnyInteger() {
        assertTrue(intsLinklist.containsNode(15));
    }

    @Test
    public void testSizeOfNewList() {
        assertEquals(10, intsLinklist.size());
    }*//*


}*/
