package ua.lvivskiy.v_dembovskiy.test_package;

import java.util.Objects;

public class First {
    private String a;
    private int c;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        First first = (First) o;
        return c == first.c &&
                Objects.equals(a, first.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, c);
    }
}
