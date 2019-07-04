package ua.lvivskiy.v_dembovskiy.test_package;

import java.util.Objects;

public class PropObj {

    private String nestedProp;
    private Boolean flag;
    private String absent;

    public String getNestedProp() {
        return nestedProp;
    }

    public void setNestedProp(String nestedProp) {
        this.nestedProp = nestedProp;
    }

    public String getAbsent() {
        return absent;
    }

    public void setAbsent(String absent) {
        this.absent = absent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropObj propObj = (PropObj) o;
        return Objects.equals(nestedProp, propObj.nestedProp) &&
                Objects.equals(flag, propObj.flag) &&
                Objects.equals(absent, propObj.absent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nestedProp, flag, absent);
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
