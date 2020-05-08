package ua.lvivskiy.p_harkavy.solid_samples;

import java.util.HashMap;

class Square extends Rectangle implements Figure {

    Square(int width) {
        super(width, width);
        System.out.println(this.width + " " + this.heigth);
    }

    class C {
        public C() {
            System.out.println("Hi I am C");
        }
    }

}
