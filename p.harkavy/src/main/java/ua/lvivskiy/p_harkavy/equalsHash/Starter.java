package ua.lvivskiy.p_harkavy.equalsHash;

import java.util.HashSet;
import java.util.Set;

public class Starter {

    public static void main(String[] args) {
        MyClass m1 = new MyClass(2L, "Ab");
        MyClass m2 = new MyClass(2L, "Ab");
        MyClass m3 = new MyClass(2L, "Ab");
        MyClass m4 = new MyClass(2L, "Abc");

        MyClass m5 = null;

        // --- Contract equals
        //Reflection
        System.out.println("Reflection");
        System.out.println(m1.equals(m1));
        System.out.println("------------");
        //Simmetria
        System.out.println("Simmetria");
        System.out.println(m1.equals(m2));
        System.out.println(m2.equals(m1));
        System.out.println("------------");
        //Transitive
        System.out.println("Transitive");
        System.out.println(m1.equals(m2));
        System.out.println(m2.equals(m3));
        System.out.println(m1.equals(m3));
        System.out.println("------------");
        //Сonsistency
        System.out.println("Сonsistency");
        System.out.println(m2.equals(m3));
        System.out.println(m2.equals(m3));
        System.out.println("------------");
        //Сompare null
        System.out.println("СompareNull");
        System.out.println(m2.equals(null));
        System.out.println(m1.equals(m5));
        System.out.println("------------");

        //System.out.println(m2.compareTo(m3));

        /* Контракт hashCode
           Для реализации хэш-функции в спецификации языка определены следующие правила:
           вызов метода hashCode один и более раз над одним и тем же объектом
           должен возвращать одно и то же хэш-значение, при условии что поля объекта,
           участвующие в вычислении значения, не изменялись.
           вызов метода hashCode над двумя объектами должен всегда возвращать
           одно и то же число, если эти объекты равны (вызов метода equals для
           этих объектов возвращает true). вызов метода hashCode над двумя неравными
           между собой объектами должен возвращать разные хэш-значения.
           Хотя это требование и не является обязательным, следует учитывать,
           что его выполнение положительно повлияет на производительность работы хэш-таблиц.*/
        System.out.println(m1.hashCode());
        System.out.println(m1.hashCode());

        System.out.println(m2.hashCode());

        System.out.println(m4.hashCode());

        Set<MyClass> set = new HashSet<>();
        set.add(m1);
        set.add(m1);
        set.add(m2);
        set.add(m3);
        set.add(m4);
        System.out.println("SIZE = " + set.size());




    }
}
