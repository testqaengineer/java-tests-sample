package ua.lvivskiy.p_harkavy.car.entity;

import java.util.Arrays;
import java.util.Objects;

public class IntList {

    private static final int DEFAULT_CAPACITY = 10;
    private int size=0;
    private int[] arr = new int[DEFAULT_CAPACITY];

    public int size() {
        return size;
    }

    public int get(int idx) {
        int result;
        if (idx<size) {
            result = arr[idx];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        return result;
    }

    public void add(int val) {
       if (size<arr.length) {
           arr[size]=val;
           size++;
       }
       else {
           int[] newArr=new int[size*3/2+1];
           System.arraycopy(arr, 0, newArr, 0, size);
           arr=newArr;
           arr[size]=val;
           size++;
       }
    }

    public void add(int idx, int val) {
        if (idx<0||idx > size()+1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size<arr.length) {
            System.arraycopy(arr, idx, arr, idx+1, size-idx);
            arr[idx]=val;
            size++;
        }
        else {
            int[] newArr=new int[size*3/2+1];
            System.arraycopy(arr, 0, newArr, 0, idx);
            System.arraycopy(arr, idx, newArr, idx+1, size-idx);
            newArr[idx]=val;
            arr=newArr;
            size++;
        }
    }

    public int remove (int idx) {
        if (idx<0) {
            throw new IllegalArgumentException();
        }
        if (idx>=size) {
            throw new IndexOutOfBoundsException();
        }
        int tmp=arr[idx];
        System.arraycopy(arr, idx+1, arr, idx, size-idx);
        size--;
        return tmp;
    }

    public void trimToSize() {
        while (size<arr.length) {
            size--;
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
