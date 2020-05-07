package ua.lvivskiy;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.lang.reflect.Array;
import java.util.*;

/**
 * TODO: read about String	https://www.baeldung.com/java-string-pool and
 * http://javastudy.ru/interview/strings/
 * TODO: StringBuffer and StringBuilder practice and StringJoiner
 * testqaengineerautomation@gmail.com  miramusic5555557
 */

public class B_FirstLessonPart2 {

        public static void main(String[] args) {
        }

        /*String s = "234";
        new Thread(() -> {
            stringBuilder.append("1").append("2");
        }).start();
        new Thread(() -> {
            stringBuilder.append("3");
        }).start();*/

    private static void stringPool() {
        String s = "abc" + "cda"; //inserted into pool

        String s2 = new String("abc"); // not in pool

        s2.intern(); //added to pool, now s2 contains link to 's' string from pool

        String a1 = new String("abc");
        String a2 = new String("abc");

        System.out.println(a1 == a2); // false
        System.out.println(a1.equals(a2)); // true

        String b1 = "abc";
        String b2 = "abc";

        System.out.println(b1 == b2); // true
    }

    private static void joinSample() {
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("first");
        joiner.add("second");
        joiner.add("third");

        System.out.println(joiner.toString());
    }

    private static void buildingStrings() {
        StringBuilder sb = new StringBuilder("["); //StringBuilder is NOT thread safe
        sb.append("a, ").append("b, ").append("c").append("]");

        System.out.println(sb.toString()); // [a, b, c]

        StringBuffer sf = new StringBuffer("["); //Is thread safe! But slower, then StringBuilder
        sf.append("a, ").append("b, ").append("c").append("]");

        System.out.println(sf.toString()); // [a, b, c]
    }

    private static void overflowExample() {
        int a = 127;

        System.out.println((byte) (a + 3)); // -126
    }

    private static void printArrays() {
        String str = "str";

        byte[] strBytes = str.getBytes();

        System.out.println(strBytes); // [I@610455d6
        System.out.println(Arrays.toString(strBytes)); // [115, 116, 114]
    }

}
