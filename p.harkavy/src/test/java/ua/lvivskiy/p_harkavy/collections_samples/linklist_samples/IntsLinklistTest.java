
package ua.lvivskiy.p_harkavy.collections_samples.linklist_samples;

import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class IntsLinklistTest {

    private IntsLinklist intsLinklist;

    @Before
    public void setUp() {
        intsLinklist = new IntsLinklist();
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
