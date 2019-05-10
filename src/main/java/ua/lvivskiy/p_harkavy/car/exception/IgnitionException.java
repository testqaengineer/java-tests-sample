package ua.lvivskiy.p_harkavy.car.exception;

public class IgnitionException extends Exception { //Don't use Throwable here!

    public IgnitionException() {
    }

    public IgnitionException(String s) {
        super(s);
    }
}
