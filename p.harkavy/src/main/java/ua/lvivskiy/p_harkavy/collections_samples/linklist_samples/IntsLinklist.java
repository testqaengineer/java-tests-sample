package ua.lvivskiy.p_harkavy.collections_samples.linklist_samples;

import java.util.*;

public class IntsLinklist implements List {

    private Node tail;
    static class Node {
        int val;
        Node next;
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node generateIterableFromTail(int max) {
        Node result = null;
        for (int i = 0; i < max; i++) {
            result = new Node(i, result);
            System.out.println(" " + result.val);
        }
        return result;
    }

    Node generateIterableFromHead(int max) {
        Node result = new Node(max, null);
        for (int i = max; i > 0; i--) {
            result.next = new Node(i-1, null);
            System.out.println(" " + result.val);
            result=result.next;

        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    // rec and iter - how many elements in list?
    public int size(Node tail) {
        return 0;
    }

    // rec and iter - how much sum all elements in list?
    public int sum(Node tail) {
        return 0;
    }

    // rec and iter - where max from all elements in list?
    public int max(Node tail) {
        return 0;
    }



    // rec OR iter - go from head to tail and add to the end new Node with elem
    void add(int index, Integer element) {
        if (tail == null) {
            tail = new Node(element, tail);

        }
        else {
            tail = new Node(element, tail);
            //tail = tail.next;
        }

    }
    // Retrieves and removes the head (first element) of this list.
    public Object remove() {
        return null;
    }

    // rec OR iter - go from head to tail and remove last elem
    Node add(Node indxNode, int index, int elem) {
        return null;
    }

    // rec OR iter - go from head to tail and remove elem with index
    public Object remove(Node indxNode, int index) {
        return null;
    }





    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }



    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }



    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public void sort(Comparator c) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


}
