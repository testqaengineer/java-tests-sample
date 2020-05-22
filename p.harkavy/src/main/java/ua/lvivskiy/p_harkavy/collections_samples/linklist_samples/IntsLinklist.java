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

    /**
     * @IvanGolovach labs
     * */
    Node generateIterableFromHead(int max) {
        head = null;
        for (int i = 0; i < max; i++) {
            head = new Node(i, head);
            System.out.println(" " + head.val);
            System.out.println(" " + head.next);
        }
        return head;
    }
    Node generateIterableFromTail(int max) {
        tail = new Node(max, null);
        for (int i = max; i > 0; i--) {
            tail.next = new Node(i - 1, null);
            System.out.println(" " + tail.val);
            tail = tail.next;

        }
        return tail;
    }
    public long dimension() {
        return size(head);
    }
    // rec and iter - how many elements in list?
    private int size(Node head) {
        if (head == null) return 0;
        else {
            size = 0;
            Node ref = head;
            while (ref != null) {
                ref = ref.next;
                size++;
            }
        }
        return size;
    }
    int sum() {
        return sum(head);
    }
    // rec and iter - how much sum all elements in list?
    private int sum(Node head) {
        int sum = 0;
        if (head == null) return 0;
        else {
            Node ref = head;
            while (ref != null) {
                ref = ref.next;
                sum = sum + ref.val;
            }
        }
        return sum;
    }
    int max() {
        return max(tail);
    }
    // rec and iter - where max it is maxValue from all Nodes in list?
    private int max(Node head) {
        int max = 0;
        if (head == null) return 0;
        else {
            Node ref = head;
            max = ref.val;
            while (ref != null) {
                ref = ref.next;
                if (ref.val > max) max = ref.val;
            }
        }
        System.out.println(max);
        return max;
    }
    // rec and iter - add newNode with elem to tail/head of list?
    public void add(Node newNode, int elem) {
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



    /**
     * @IvanKushn&&PaulGrk homeworks
     * */
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean add(Integer element) {
        Node node = new Node(element, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }
    @Override
    public void add(int index, Integer element) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node node = new Node(element, null);
        Node ref = head;
        for (int i = 0; i < index - 1; i++) {
            ref = ref.next;
        }
        node.next = ref.next;
        ref.next = node;
        size++;
    }
    @Override
    public Integer set(int index, Integer element) {
        add(index, element);
        remove(index+1);
        return element;
    }
    @Override
    public Integer get(int index) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node ref = head;
        for (int i = 0; i < index; i++) {
            ref = ref.next;
        }
        return ref.val;
    }
    @Override
    public Integer remove(int index) {
        if (index > size && index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node ref = head;
        for (int i = 0; i < index-1; i++) {
            ref = ref.next;
        }
        Node deleted=ref;
        ref.next=ref.next.next;
        size--;
        return deleted.val;
    }
    @Override
    public boolean remove(Object o) {
        if (o==null) {
            throw new NullPointerException("Object is: " + null);
        }
        Node ref = head;
        for (int i = 0; i < size(); i++) {
            ref = ref.next;
            if (ref.equals(o)) {
                ref.next=ref.next.next;
                size--;
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean contains(Object o) {
        if (o==null) {
            throw new NullPointerException("Object is: " + o);
        }
        Node ref = head;
        for (int i = 0; i < size(); i++) {
            ref = ref.next;
            if (ref.equals(o)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public int indexOf(Object o) {
        if (o==null) {
            throw new NullPointerException("Object is: " + o);
        }
        int index=0;
        Node ref = head;
        for (int i = 0; i < size(); i++) {
            ref = ref.next;
            if (ref.equals(o)) {
                index=i;
            }
        }
        return index;
    }
    @Override
    public int lastIndexOf(Object o) {
        if (o==null) {
            throw new NullPointerException("Object is: " + o);
        }
        int index=0;
        Node ref = tail;
        for (int i = size(); i > 0; i--) {
            ref = ref.next;
            if (ref.equals(o)) {
                index=i;
            }
        }
        return index;
    }
    @Override
    public void clear() {

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node ref=head;
        while (ref!=null) {
            sb.append(ref.val).append(" ");
            ref=ref.next;
        }
        sb.append("]");
        return sb.toString();
    }

}

