package ua.lvivskiy.p_harkavy.collections_samples.arraylist_samples;

import java.util.Arrays;
import java.util.Objects;

public class IntsArrayListWithSize {

    private static final int DEFAULT_CAPACITY = 10;
    private int size=0;
    private int[] arr = new int[DEFAULT_CAPACITY];

    int size() {
        return size;
    }

    int get(int idx) {
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
           int[] tmpArr=new int[size*3/2+1];
           System.arraycopy(arr, 0, tmpArr, 0, size);
           arr=tmpArr;
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
            int[] tmpArr=new int[size*3/2+1];
            System.arraycopy(arr, 0, tmpArr, 0, idx);
            System.arraycopy(arr, idx, tmpArr, idx+1, size-idx);
            tmpArr[idx]=val;
            arr=tmpArr;
            size++;
        }
    }

    int remove (int idx) {
        if (idx<0) {
            throw new IllegalArgumentException();
        }
        if (idx>=size) {
            throw new IndexOutOfBoundsException();
        }
        int tmpArr=arr[idx];
        System.arraycopy(arr, idx+1, arr, idx, size-idx);
        size--;
        return tmpArr;
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
        IntsArrayListWithSize intsArrayListWithSize = (IntsArrayListWithSize) o;
        return size == intsArrayListWithSize.size &&
                Arrays.equals(arr, intsArrayListWithSize.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

}
