package ua.lvivskiy.p_harkavy.solid_samples;

public class Circle implements Figure {

    private final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
