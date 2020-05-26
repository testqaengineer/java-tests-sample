package ua.lvivskiy.p_harkavy.equalsHash;

import java.util.Objects;

public class MyClass {

    private Long l;
    private String s;

    public MyClass(Long l, String s) {
        this.l = l;
        this.s = s;
    }

    public Long getL() {
        return l;
    }

    public void setL(Long l) {
        this.l = l;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof MyClass) {
            return this.l.equals(((MyClass) o).l)&& this.s.equals(((MyClass) o).s);
        }
        /*MyClass m = (MyClass) o;
        return this.l.equals(m.l)&& this.s.equals(m.s);*/
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(l, s);
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return Objects.equals(l, myClass.l) &&
                Objects.equals(s, myClass.s);
    }*/
}
