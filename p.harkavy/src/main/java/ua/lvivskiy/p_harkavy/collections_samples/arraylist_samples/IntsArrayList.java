package ua.lvivskiy.p_harkavy.collections_samples.arraylist_samples;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class IntsArrayList implements List<Integer> {

    private int[] data = new int[10];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    /*public int[] getData() {
        int[] copyData = new int[data.length];
        System.arraycopy(data, 0, copyData, 0, data.length);

        return copyData;
    }*/

    /*public void setData(int[] data) {
        this.data = data;
    }*/

    void add(int elem) {
        add(size(), elem);
    }

    void add(int index, int elem) {
        if (index < 0 || index > size() + 1) {
            throw new ArrayIndexOutOfBoundsException("IndexOutOfBounds:" + index);
        }
        if (size == data.length) {
            int[] tmpArr = new int[data.length * 3 / 2 + 1];
            System.arraycopy(data, 0, tmpArr, 0, index);
            System.arraycopy(data, index, tmpArr, index + 1, data.length - index);
            data = tmpArr;
        }
        data[index] = elem;
        size++;
    }

    void remove() {
        remove(data.length - 1);
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new ArrayIndexOutOfBoundsException("IndexOutOfBounds:" + index);
        }
        return data[index];
    }

    @Override
    public Integer remove(int index) {
        int[] tmp = new int[data.length - 1];
        int remvd = data[index];
        System.arraycopy(data, 0, tmp, 0, index);
        System.arraycopy(data, index + 1, tmp, index, data.length - index - 1);
        data = tmp;
        size--;
        return remvd;
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
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

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
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return null;
    }


}
