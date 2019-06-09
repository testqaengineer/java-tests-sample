package ua.lvivskiy.v_dembovskiy.car.entity;

import java.util.Arrays;
import java.util.Objects;

public class IntList {

    public static final int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private int[] arr = new int[DEFAULT_CAPACITY];
    private int[] newArr;

    public IntList() {
    }

    public IntList(int size) {
        this.arr = new int[size];
    }

    public void add(int val) {
        if (size < arr.length) {
            arr[size] = val;
            size++;
        } else {
            arr = resize(arr);
            arr[size] = val;
            size++;
        }
    }

    private int[] resize(int[] arr) {
        int[] newArr = new int[size * 3 / 2 + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);

        return newArr;
    }

    public void add(int idx, int val) {
        if (idx < 0) {
            throw new IllegalArgumentException("The index can`t be below 0");
        }
        if (idx > size+1) {
            throw new ArrayIndexOutOfBoundsException("The index can`t be below " + idx);
        }
        if (size == arr.length) {
            arr = resize(arr);
        }
        for (int a = 0; a < size - idx+1; a++) {
            arr[size + 1 - a] = arr[size - a];
        }
        arr[idx] = val;
        size++;
    }


    public void remove(int idx) {
        if (idx > arr.length) {
            throw new IndexOutOfBoundsException("The idx is more than array size!");
        }
        for (int a = 0; a < arr.length - idx - 1; a++) {
            arr[idx + a] = arr[idx + 1 + a];
        }
        size--;
    }


    public int get(int idx) {
        if (idx >= size) {
            throw new IndexOutOfBoundsException("The idx is more than array size!");
        }
        return arr[idx];

    }

    public int size() {
        return size;
    }

    public void trimToSize() {
        if (arr.length > size) {
            int[] newArr = new int[size];
            System.arraycopy(arr, 0, newArr, 0, newArr.length);
            arr = newArr;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntList intList = (IntList) o;

        return size == intList.size && Arrays.equals(arr, intList.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arr);

        return result;
    }

    @Override
    public String toString() {

        return "IntList{" +
                "size=" + size +
                ", arr=" + Arrays.toString(arr) +
                ", newArr=" + Arrays.toString(newArr) +
                '}';
    }


}
