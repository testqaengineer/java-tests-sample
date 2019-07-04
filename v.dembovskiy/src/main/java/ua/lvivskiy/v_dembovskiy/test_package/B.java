package ua.lvivskiy.v_dembovskiy.test_package;

import java.util.Objects;

public class B {
    private A prop2;
    private String prop1;

    public A getProp2() {
        return prop2;
    }

    public void setProp2(A prop2) {
        this.prop2 = prop2;
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B b = (B) o;
        return Objects.equals(prop2, b.prop2) &&
                Objects.equals(prop1, b.prop1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prop2, prop1);
    }
}
