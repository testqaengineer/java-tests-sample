package ua.lvivskiy.p_harkavy.solid_samples;

public class GeometricService {

    public void printArea(Figure f) {
        System.out.println(f.area());
    }

    int compareArea(Figure f1, Figure f2) {
        return f1.area() == f2.area()
                ? 0
                : (int) (f1.area() - f2.area());
    }


}
