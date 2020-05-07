package ua.lvivskiy.p_harkavy.moonrider.entity;

import org.junit.Before;
import org.junit.Test;
import ua.lvivskiy.p_harkavy.collections_samples.IntsTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntsTreeTest {

        private IntsTree intTree;

        @Before
        public void setUp() {
            intTree = new IntsTree();
            intTree.add(34);
            intTree.add(75);
            intTree.add(44);
            intTree.add(55);
            intTree.add(14);
            intTree.add(15);
            intTree.add(54);
            intTree.add(45);
            intTree.add(43);
            intTree.add(57);
        }

        @Test
        public void testSuccessAdding() {
            assertTrue(intTree.add(100500));
        }

        @Test
        public void testContainsAnyInteger() {
            assertTrue(intTree.containsNode(15));
        }

        @Test
            public void testSizeOfNewList() {
            assertEquals(10, intTree.size());
        }




        /*
        @Test
        public void testSizeOfListWithCorrectData() {
            intTree.add(100);
            intTree.add(0);
            assertEquals(2, intTree.size());
        }

        @Test
        public void testSizeOfListWithoutData() {
            intTree.add(48);
            intTree.remove(0);
            assertEquals(0, intTree.size());
        }


        @Test
        public void testSizesOfOneTimeIncreasedLists() {
            for (int i=0; i<15; i++) {
                intTree.add(i);
            }
            assertEquals(15, intTree.size());
        }*/
}
