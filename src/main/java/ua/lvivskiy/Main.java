package ua.lvivskiy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.sort;


public class Main {
    // public static void hackSalary(int a) {
    //     a=a+1000;
    //     System.out.println("Your salary is:" +a+ " dollars per month.");
    // }
    Random rnd = new Random();

    ArrayList<String> outputArray = new ArrayList<>();


    private static double[] concatArray(double[] n, double[] m) {
        if (n == null)
            return m;
        if (m == null)
            return n;
        double[] r = new double[n.length + m.length];
        System.arraycopy(n, 0, r, 0, n.length);
        System.arraycopy(m, 0, r, n.length, m.length);
        return r;
    }



    public static void main(String[] args) {

        int[][] a = {{1, 2, 3}, {4, 0, 0,},};
        System.out.println(Arrays.deepToString(a));
        System.out.println();
        System.out.println();

        double n[]={5, 76, 234, 79, 0,};
        double m[]={3, 56, 81, 99,};

        sort(concatArray(n, m));
        System.out.println( Arrays.toString(concatArray(n, m)));
        System.out.println();

        int[] anyNumbers = {2, 8, 11};
        int[] luckyNumbers = Arrays.copyOf(anyNumbers, 6);
        System.out.println(Arrays.toString(luckyNumbers));
        System.out.println();

        String[] weekday = new String[] { "Понедельник", "Вторник", "Среда" };
        // нам нужен массив с первого элемента
        String[] week = Arrays.copyOfRange(weekday, 1, 3); // вернёт Вторник и Среда
        // выводим результат
        System.out.println(Arrays.toString(week));
        System.out.println();
        System.out.println();



        int[] cats = new int[9];

            cats = new int[6];
            String result1 = String.valueOf(cats[3]);
            System.out.println(result1);
            System.out.println();
            cats[5] = 7;
            //String result2 = String.valueOf(cats[5]);
            System.out.println(cats[5]);
            System.out.println();

        // hackSalary(7000);

        int arr[] = {134, 500, 9, 75, 0, 1, 2, 14, 76, 82, 190, 78, 93, 44, 10000, 17, 3, 0, 87324};

        System.out.print(Arrays.toString(arr) + "->");
        for (int limit = arr.length - 1; limit >= 0; limit--) {
            for (int j = 0; j < limit; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.print(Arrays.toString(arr) + "->");
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = k - 1;
            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;
        }

        //DynamicArray dynArray = new DynamicArray();
        //System.out.println(Arrays.toString(dynArray.data));

        int[][] twoD = new int[3][4]; // объявили двухмерный массив
        int i, j, k = 0;

        for (i = 0; i < 3; i++)
            for (j = 0; j < 4; j++) {
                twoD[i][j] = k;
                k++;
            }

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 4; j++)
                System.out.print(twoD[i][j] + " ");
            System.out.println("\n");
        }

        System.out.println();
        System.out.println();

        int[][] two2D = new int[3][]; // память под первое измерение
        // далее резервируем память под второе измерение
        two2D[0] = new int[4];
        two2D[1] = new int[4];
        two2D[2] = new int[4];
        System.out.print(two2D[2][2] + " ");


        System.out.println();
        System.out.println();

        Integer[] Integer[] = {{1, 2, 3}, {4, 0, 0,},};
        System.out.println(Arrays.deepToString(Integer));
        System.out.print(Integer[1][2] + " ");
        System.out.print("\n");
        System.out.println(Arrays.deepToString(two2D));

        int v =5, b = 3;


    }

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

