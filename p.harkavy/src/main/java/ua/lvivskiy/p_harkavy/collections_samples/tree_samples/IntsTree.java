package ua.lvivskiy.p_harkavy.collections_samples.tree_samples;

import java.util.Collection;
import java.util.Iterator;

public class IntsTree implements Collection<Integer> {

    private Node root;
    public static class Node {
        final Integer val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }

    @Override
    public boolean add(Integer i) {
        if (i==null) {
            throw new NullPointerException("Can not be NULL");
        }
        root = addRecursive(root, i);
        return true;
    }
    private Node addRecursive(Node psevdoRoot, Integer i) {
        if (psevdoRoot==null) {
            return new Node(i);
        }
        if (i>psevdoRoot.val) {
            psevdoRoot.right = addRecursive(psevdoRoot.right, i);
        }
        if (i<psevdoRoot.val) {
            psevdoRoot.left = addRecursive(psevdoRoot.left, i);
        }
        if (psevdoRoot.val.equals(i)) {
            return psevdoRoot;
        }
        return psevdoRoot;
    }

    boolean containsNode(int val) {
        return containsNodeRecursive(root, val);
    }
    private boolean containsNodeRecursive(Node current, int val) {
        if (current == null) {
            return false;
        }
        if (val == current.val) {
            return true;
        }
        return val < current.val
                ? containsNodeRecursive(current.left, val)
                : containsNodeRecursive(current.right, val);
    }

    @Override
    public int size() {
        return sizeRecursive(root);
    }
    private int count=0;
    private int sizeRecursive(Node current) {
        if (current != null) {
            count++;
            sizeRecursive(current.left);
            sizeRecursive(current.right);
            System.out.println(" " + current.val);
        }
        return count;
    }

    public boolean removeNode(int val) {
        removeRecursive(root, val);
        return true;
    }
    private Node removeRecursive(Node current, int val) {
        if (current == null) {
            return null;
        }
        if (current.val==val) {

            System.out.println(" " + current.val);
        }
        if (current.val<val) {
            current.right=removeRecursive(current.right, val);
            return current;
        }
        current.left=removeRecursive(current.right, val);
        return current;
    }









    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Integer[] toArray() {
        return new Integer[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

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
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Integer[] toArray(Object[] a) {
        return new Integer[0];
    }



    /*public static void main(String[] args) {
        IntsTree intTree = new IntsTree();
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
        intTree.add(88);
        intTree.add(99);
        intTree.add(41);
        intTree.add(51);
        intTree.add(45);
        intTree.add(0);


        if (intTree.containsNode(43)) {
            System.out.println(" EveryTHINK IS HUFINE )))!!! ");
        }
        intTree.size();
    }*/


}

