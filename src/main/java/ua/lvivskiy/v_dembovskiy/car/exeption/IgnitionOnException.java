package ua.lvivskiy.v_dembovskiy.car.exeption;

public class IgnitionOnException extends Exception { //Don't use Throwable here!

    public IgnitionOnException() {

    }

    public IgnitionOnException(String s) {

        super(s);
    }
}

