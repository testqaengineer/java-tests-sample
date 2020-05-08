package ua.lvivskiy;

import java.util.*;

/**
 * TODO: equals и hashCode() - зачем нужны, как взаимосвязаны. Повторить!
 * TODO: Выучить иерархию коллекций, уметь рисовать основные классы и интерфейсы по памяти
 * http://tutorials.jenkov.com/java-collections/index.html
 * TODO: Реализовать самостоятельно дерево и его методы add(Integer i), size():
 * public class IntsTree implements Collection<Integer> {}
 * TODO: SOLID принципы (прочитать, быть готовым задавать вопросы)
 * https://amitshahi.dev/blog/2019-01-26-SOLID-Principles/
 * testqaengineerautomation@gmail.com  miramusic5555557
 */

public class J_NineLesson {

    public static void main(String[] args) {

        /*System.out.println(int.class);
        System.out.println(Integer.class);*/

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(0);
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Queue<Integer> integerQueue = new ArrayDeque<>();
        integerQueue.add(0);
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);

        List<Collection<Integer>> metaCollections = new ArrayList<>();
        metaCollections.add(integerSet);
        metaCollections.add(arrayList);
        metaCollections.add(linkedList);
        metaCollections.add(integerQueue);

        for (Collection<Integer> c : metaCollections) {
            System.out.println(count(c, 2));
        }

        Object a = new Object();
        Object b = null;

        System.out.println(a.equals(b)); //false
        System.out.println(b.equals(a)); //NPE

    }

    private static long count(Collection<Integer> ints, int treshold) {
        long count = 0;
        for (Integer i : ints) {
            if (i > treshold) {
                count++;
            }
        }
        return count;
    }





}
