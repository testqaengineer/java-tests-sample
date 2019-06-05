package ua.lvivskiy.v_dembovskiy.car.entity;

import java.util.Arrays;
import java.util.Objects;

public class IntList {

    public static final int DEFAULT_CAPACITY = 10;

    private int size = 0;

    private int[] arr = new int[DEFAULT_CAPACITY];

    public void add(int val) {
        if (size < arr.length) {
            arr[size] = val;
            size++;
        } else {
            int[] arrNew = new int[(int) (size * 1.5)];
            for (int a = 0; a < arr.length; a++) {
                arrNew[a] = arr[a];
            }
            arr = arrNew;
            arr[size] = val;
            size++;
        }
        //System.out.println(size);
    }

    public void add(int idx, int val) {
        if (idx < 0) {
            throw new IllegalArgumentException("The index can`t be below 0");
        }
        if (size < arr.length) {
            int temp = arr[idx];
            for (int a = 0; a < arr.length - idx; a++) {
                arr[size + 1 - a] = arr[size - a];
            }
            arr[idx + 1] = temp;
            arr[idx] = val;
        } else {
            int[] arrNew = new int[(int) (size * 1.5)];
            for (int a = 0; a < arr.length; a++) {
                arrNew[a] = arr[a];
            }
            arr = arrNew;
            size++;

            int temp = arr[idx];
            for (int a = 0; a < arr.length - idx; a++) {
                arr[size + 1 - a] = arr[size - a];
            }
            arr[idx + 1] = temp;
            arr[idx] = val;
        }
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
        if (idx > arr.length) {
            throw new IndexOutOfBoundsException("The idx is more than array size!");
        }
        return arr[idx];

    }

    public int size() {
        return size;
    }

    public void trimToSize() {
        if (arr.length > size) {
            int[] arrNew = new int[size];
            for (int a = 0; a < size; a++) {
                arrNew[a] = arr[a];
            }
            arr = arrNew;
            size = arrNew.length;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntList intList = (IntList) o;
        return size == intList.size &&
                Arrays.equals(arr, intList.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arr);
        return result;


    }


}
