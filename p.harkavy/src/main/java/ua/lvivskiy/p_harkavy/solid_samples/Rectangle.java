package ua.lvivskiy.p_harkavy.solid_samples;

public class Rectangle implements Figure {

    final int width;
    final int heigth;

    Rectangle(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        System.out.println("Created rectangle");

    }

    @Override
    public double area() {
        return heigth * width;
    }
}
