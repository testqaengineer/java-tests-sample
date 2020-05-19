package ua.lvivskiy.p_harkavy.collections_samples.linklist_samples;

import java.util.*;

public class IntsLinklist implements List<Integer> {

    static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    private Node tail;
    private Node head;

    private int size = 0;

    @Override
    public String toString() {

        return "";

    }


    Node generateIterableFromTail(int max) {
        tail = null;
        for (int i = 0; i < max; i++) {
            tail = new Node(i, tail);
            System.out.println(" " + tail.val);
            System.out.println(" " + tail.next);
        }
        return tail;
    }

    Node generateIterableFromHead(int max) {
        Node head = new Node(max, null);
        for (int i = max; i > 0; i--) {
            head.next = new Node(i - 1, null);
            System.out.println(" " + head.val);
            head = head.next;

        }
        return head;
    }

    @Override
    public int size() {
        return size(tail);
    }
    // rec and iter - how many elements in list?
    int size(Node tail) {
        int size=0;
        if (tail==null) return size;
        else {
            size=1;
            Node ref = tail;
            while (ref!=null) {
                ref=ref.next;
                size++;
            }
        }
        return size;
    }

    int sum() {
        return sum(tail);
    }
    // rec and iter - how much sum all elements in list?
    int sum(Node tail) {
        int sum=0;
        if (tail==null) return sum;
        else {
            sum=tail.val;
            Node ref = tail;
            while (ref!=null) {
                ref=ref.next;
                sum=sum+ref.val;
            }
        }
        System.out.println(sum);
        return sum;
    }
    int max() {
        return max(tail);
    }
    // rec and iter - where max it is maxValue from all Nodes in list?
    int max(Node tail) {
        int max=0;
        if (tail==null) return max;
        else {
            Node ref = tail;
            max=ref.val;
            while (ref!=null) {
                ref=ref.next;
                if (ref.val>max) max=ref.val;
            }
        }
        System.out.println(max);
        return max;
    }

    // rec and iter - add newNode with elem to tail/head of list?
    public void add(Node newNode, int elem) {

        // tail = null;
        //newNode = new Node(elem, newNode);
    }
    // rec and iter - retrieves and removes the head tail ? from list .
    public Object remove(Node node) {
        return null;
    }

    //rec OR iter - go (from head to tail--?) and add newNode with elem to index
    public void add(Node newNode, int index, int elem) {

    }
    // rec OR iter - go from head to tail and remove node with index
    public Object remove(Node node, int index) {
        return null;
    }



    @Override
    public Integer remove(int index) {
        return null;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public boolean contains(Object o) {
        return false;
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
    public boolean add(Integer integer) {
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
    public Integer get(int index) {
        return null;
    }
    @Override
    public Integer set(int index, Integer element) {
        return null;
    }
    @Override
    public void add(int index, Integer element) {

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

