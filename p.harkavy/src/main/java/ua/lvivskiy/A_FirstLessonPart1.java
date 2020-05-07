package ua.lvivskiy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * TODO: watch JavaMemory https://www.youtube.com/watch?v=AxL5LgoQyNs
 * TODO: and read about changes in Java 8 9 etc. connected with memory
 * TODO: read about Java9 CompactString and all about JavaMemory
 * testqaengineerautomation@gmail.com  miramusic5555557
 */

public class A_FirstLessonPart1 {

    public static void main(String[] args) {

        /*byte b = 127;
        System.out.println(++b);*/

        /*byte b = 127;
        byte a = (byte) (b + 2);
        System.out.println(a); // -127*/

        /*int[][] a = {{1, 2, 3}, {4, 0, 0,},};
        System.out.println(Arrays.deepToString(a));
        System.out.println();
        System.out.println();*/

        /*double n[]={5, 76, 234, 79, 0,};
        double m[]={3, 56, 81, 99,};
        //sort(concatArray(n, m));
        System.out.println( Arrays.toString(concatArray(n, m)));
        System.out.println();*/

        /*int[] anyNumbers = {2, 8, 11};
        int[] luckyNumbers = Arrays.copyOf(anyNumbers, 6);
        System.out.println(Arrays.toString(luckyNumbers));
        System.out.println();*/

        /*String[] weekday = new String[] { "Понедельник", "Вторник", "Среда" };
        String[] week = Arrays.copyOfRange(weekday, 1, 3); // вернёт Вторник и Среда
        System.out.println(Arrays.toString(week));
        System.out.println();*/

        int[] cats = new int[9];
        String result1 = String.valueOf(cats[3]);
        System.out.println(result1);
        System.out.println();
        cats[5] = 7;
        String result2 = String.valueOf(cats[5]);
        System.out.println(result2);
        System.out.println();
    }
    /**
     * System.out.println("Start developing console app...");
     * int x;
     * try{
     * x = 6/0;
     * }
     * catch(ArithmeticException ex){
     * <p>
     * ex.printStackTrace();
     * System.out.println();
     * ex.getMessage();
     * System.out.println();
     * ex.getStackTrace();
     * System.out.println();
     * <p>
     * }
     * finally {
     * x=6;
     * System.out.println("x = " + x);
     * }
     */
}



