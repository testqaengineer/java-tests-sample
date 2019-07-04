package ua.lvivskiy.v_dembovskiy.test_package;

import java.util.Objects;

public class NesetedObj {

    private String prop1;
    private PropObj propObj;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public PropObj getPropObj() {
        return propObj;
    }

    public void setPropObj(PropObj propObj) {
        this.propObj = propObj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NesetedObj that = (NesetedObj) o;
        return Objects.equals(prop1, that.prop1) &&
                Objects.equals(propObj, that.propObj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prop1, propObj);
    }
}
