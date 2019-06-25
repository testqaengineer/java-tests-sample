package ua.lvivskiy;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * TODO: watch https://www.youtube.com/watch?v=AxL5LgoQyNs and read about changes in Java 8
 * TODO: read about Java9 CompactString
 * testqaengineerautomation@gmail.com  miramusic5555557
 */
public class Samples {

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

    public static void main(String[] args) {
    }
}
