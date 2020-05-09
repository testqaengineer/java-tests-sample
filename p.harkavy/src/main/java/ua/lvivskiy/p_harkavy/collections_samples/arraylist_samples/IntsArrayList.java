package ua.lvivskiy.p_harkavy.collections_samples.arraylist_samples;

import java.util.Arrays;

class IntsArrayList {

    int[] data = {};

    void add(int elem) {
       add(data.length, elem);
    }

    void add(int index, int elem) {
        int[] tmpArr = new int[data.length+1];
        System.arraycopy(data, 0, tmpArr, 0, index);
        System.arraycopy(data, index, tmpArr, index+1, data.length-index);
        tmpArr[index+1]= elem;
        data=tmpArr;
    }

    void remove() {
        remove(data.length-1);
    }

    private void remove(int index) {
        int[] tmp = new int[data.length-1];
        System.arraycopy(data, 0, tmp, 0, index);
        System.arraycopy(data, index+1, tmp, index, data.length-(index+1));
        data=tmp;
    }

    /*public static void main(String[] args) {
        IntsArrayList arrList = new IntsArrayList();
        System.out.println(Arrays.toString(arrList.data));
        for (int i=0; i<12; i++) {
            arrList.data[i]=i;
        }
        System.out.println(Arrays.toString(data));
    }*/

}
