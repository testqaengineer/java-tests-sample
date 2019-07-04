package ua.lvivskiy.v_dembovskiy.test_package;

import java.util.Arrays;
import java.util.Objects;

public class MainClass {
    private Object objects[];
    private NesetedObj nesetedObj;


    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public NesetedObj getNesetedObj() {
        return nesetedObj;
    }

    public void setNesetedObj(NesetedObj nesetedObj) {
        this.nesetedObj = nesetedObj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainClass mainClass = (MainClass) o;
        return Arrays.equals(objects, mainClass.objects) &&
                Objects.equals(nesetedObj, mainClass.nesetedObj);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nesetedObj);
        result = 31 * result + Arrays.hashCode(objects);
        return result;
    }
}
