package ua.lvivskiy.p_harkavy.sobes;

import org.junit.Before;
import org.junit.Test;

public class EasyTasksTest {



    // 7.1  // 7.2
    private int[] arr =
            {72, 0, 0, 6, 6, 1, 1, -99, 4, 5, 6, 2, 72, 3, 14, 15, 6, 16, 35, -3, -5, -15};
    private EasyTasks et;

    // 7.3
    private int[] firstArr =
            {2, 0, 57, 6, 67, 1, 11, -99, 43, 51, 60, 20, 72, 33, 67, -3, -5, -15};
    private int[] secondArr =
            {2, 0, 57, 6, 67, 1, 11, -99, 43, 51, 60, 20, 72, 33, 67, -3, -5, -15};

    @Before
    public void setup() {
        et = new EasyTasks();
    }

    @Test
    public void checkCorrectnessCratnost() {
        for (int i1 : arr) {
            et.cratnost(i1);
        }
    }

    @Test
    public void checkArrUsingMyStupidMethod() {
        et.arrUnicUsingMyStupidMethod(arr);
    }

    @Test
    public void checkCorrectnessArrsOld() {
        et.arrWithUnicValue(arr);
    }

    @Test
    public void checkCorrectnessArrsNewWithJava8() {
        et.arrUnicWithJava8(arr);
    }

    @Test
    public void checkTheSameOrNoArrays() {
        Boolean isTheSame = et.removedElement(firstArr, secondArr);
        System.out.println(isTheSame);
    }







    interface Operationable {
        int calculate(int x, int y);
    }

    private int a;
    private int b;

    private int trigonometr(Operationable operation6) {
        if (operation6.calculate(a, b) >= 100) {
            return 100;
        }
        return operation6.calculate(a, b);
    }

    @Test
    public void checkLambda() {

        Operationable operation1 // link to func interface
                = (x, y) -> x + y; // expression with lambda and arguments of func interface
        Operationable operation2 = (x, y) -> x * y;
        Operationable operation3 = (x, y) -> x * x + y;
        Operationable operation4 = (x, y) -> x * x * y;
        Operationable operation5 = (x, y) -> x * y + (x + y);

        int result1 = operation1.calculate(10, 20);
        int result2 = operation2.calculate(10, 20);
        int result3 = operation3.calculate(10, 20);
        int result4 = operation4.calculate(10, 20);
        int result5 = operation5.calculate(10, 20);
        int result6 = trigonometr((n, m) -> ((10 + 20) * 20) / (10 * 20 - 20));


        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
    }

}