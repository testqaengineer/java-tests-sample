package ua.lvivskiy.p_harkavy.car.exception;

public class IgnitionOnException extends Exception { //Don't use Throwable here!




    public IgnitionOnException() {

    }

    public IgnitionOnException(String s) {

        super(s);
    }
}
