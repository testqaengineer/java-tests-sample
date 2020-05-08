package ua.lvivskiy.p_harkavy.collections_samples.linklist_samples;

import org.junit.Before;
import org.junit.Test;
import ua.lvivskiy.p_harkavy.collections_samples.tree_samples.IntsTree;

import java.util.*;


public class IntsLinklistTest {

    private IntsLinklist intsLinklist;

    @Before
    public void setUp() {
        //intsLinklist = new IntsLinklist();
        intsLinklist.generateIterableFromTail(28);
    }

    @Test
    public void testPrintGeneratedList() {
        System.out.println(Arrays.toString(intsLinklist.toArray()));
    }


    /*@Test
    public void testSuccessAdding() {
        assertTrue(intsLinklist.add(100500));
    }

    @Test
    public void testContainsAnyInteger() {
        assertTrue(intsLinklist.containsNode(15));
    }

    @Test
    public void testSizeOfNewList() {
        assertEquals(10, intsLinklist.size());
    }*/

}