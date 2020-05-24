package ua.lvivskiy.p_harkavy.sobes;

import java.util.*;
import java.util.stream.IntStream;

class EasyTasks {

    //https://stackoverflow.com/questions/41520654/
    // an-efficient-way-to-convert-listinteger-to-int-array-without-iteration/41528117

    //https://stackoverflow.com/questions/6589744/how-to-return-a-list-of-keys-from-a-hash-map

    //если число кратно 5 напечатать 5 если 3 то 3 если 15 то 35 в других случаях 0
    void cratnost(int chislo) {
        if (chislo==0||chislo==1||chislo==2||chislo==4) {
            System.out.println(0);
            return;
        }
        if ((chislo % 15 != 0) && (chislo % 5 != 0) && (chislo % 3 != 0)) {
            System.out.println(0);
            return;
        }
        if (chislo % 15 == 0) {
            System.out.println(35);
            return;
        }
        if (chislo % 5 == 0) {
            System.out.println(5);
            return;
        }
        if (chislo % 3 == 0) {
            System.out.println(3);
        }
    }

    // 7.2 - есть массив интов -
    // 7.2.1 создать новый массив содержащий уникальные значения,
    // 7.2.2 создать новый массив содержащий уникальные значения в том же самом
    // порядке что и в старом массиве
    // https://stackoverflow.com/questions
    // /1128723/how-do-i-determine-whether-an-array-contains-a-particular-value-in-java
    // 7.2.1
    int[] arrUnicUsingMyStupidMethod (int[] originalArr) {
        Map<Integer, Integer> mp = new HashMap<>();
        System.out.println("length originalArr = " + originalArr.length);
        for (int i : originalArr) {
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            } else {
                mp.put(i, 1);
            }
        }
        List<Integer> myList = new ArrayList<>(mp.keySet());
        int[] resArray = new int[myList.size()];
        for (int i=0; i<myList.size(); i++) {
            int val = myList.get(i);
            resArray[i] = val;
        }
        System.out.println("length resultArr = " + resArray.length);
        System.out.println(Arrays.toString(resArray));
        return resArray;
    }
    int[] arrWithUnicValue(int[] originalArr) {
        Map<Integer, Integer> mp = new HashMap<>();
        System.out.println("length originalArr = " + originalArr.length);
        for (int i1 : originalArr) {
            if (mp.containsKey(i1)) {
                mp.put(i1, mp.get(i1) + 1);
            } else {
                mp.put(i1, 1);
            }
        }
        List<Integer> myList = new ArrayList<>(mp.keySet());
        int[] resArray = myList.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("length resultArr = " + resArray.length);
        System.out.println(Arrays.toString(resArray));
        return resArray;
    }
    //7.2.2
    int[] arrUnicWithJava8 (int[] originalArr) {
        System.out.println("length originalArr = " + originalArr.length);
        int[] noDuplicates = IntStream.of(originalArr).distinct().toArray();
        System.out.println("length resultArr = " + noDuplicates.length);
        System.out.println(Arrays.toString(noDuplicates));
        return noDuplicates;
    }
    int[] arrUnicValueInSameOrder(int[] originalArr) {
        Integer[] integ = Arrays.stream(originalArr).boxed().toArray( Integer[]::new );
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(integ));
        System.out.println("length resultArr = " + set.size());
        System.out.println("length resultArr = " + set.toArray());
        Integer[] resArray = new Integer[set.size()];
        int[] intArray = Arrays
                .stream(set.toArray(resArray))
                .mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(intArray));
        return intArray;
    }


    /*7.3 - есть два массива одинаковых по длине и по-содержимому - каждый из них
    рандомно перемешивают, из одного из них удаляют 1 элемент в любом месте.
    Написать алгоритм вычисляющий удалённое число с использованием одного из
    широко-используемых контейнеров*/
    boolean removedElement (int[] firstArr, int[] secondArr) {
        Map<Integer, Integer> mp1 = new HashMap<>();
        System.out.println("length originalArr = " + firstArr.length);
        for (int i1 : firstArr) {
            if (mp1.containsKey(i1)) {
                mp1.put(i1, mp1.get(i1) + 1);
            } else mp1.put(i1, 1);
        }
        //List<Integer> myList1 = new ArrayList<>(mp1.keySet());
        Map<Integer, Integer> mp2 = new HashMap<>();
        System.out.println("length originalArr = " + secondArr.length);
        for (int i = 0; i < secondArr.length; i++) {
            if (mp2.containsKey(secondArr[i])) {
                mp2.put(secondArr[i], mp2.get(secondArr[i]) + 1);
            } else mp2.put(secondArr[i], 1);
        }
        if (  mp1.entrySet().containsAll(mp2.entrySet())
                && mp2.entrySet().containsAll(mp1.entrySet()) ) {
            return true;
        }
        return false;
    }

}
    //https://www.it-swarm.xyz/ru/java/massiv-unikalnyh-elementov/1071341532/
    /*public int[] arrUnicUsingSet (int[] originalArr) {
        System.out.println("length originalArr = " + originalArr.length);
        Set<Integer> set = new LinkedHashSet<Integer>(Arrays.asList(originalArr));
        System.out.println("length resultArr = " + set.toArray().length);
        System.out.println(Arrays.toString(set.toArray()));
        return set.toArray();
    }*/
    // since java 9
    // private static final Set<Integer> VALUES = Set.of(mp.keySet())
    // ???
    //final Set<Integer> VALUES = new HashSet<Integer>(mp.keySet());





