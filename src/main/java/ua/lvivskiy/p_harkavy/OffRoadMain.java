package ua.lvivskiy.p_harkavy;

import ua.lvivskiy.p_harkavy.lunohod.entity.Lunohod;

public class OffRoadMain {

    public static void main(String[] args) {
        Lunohod.MakeModelColor makeModelColor1 = new Lunohod.MakeModelColor("lunohod", "0", "metallic");
        Lunohod lunohod0 = new Lunohod (makeModelColor1, 60, 1000, 600);

        Lunohod.MakeModelColor makeModelColor2 = new Lunohod.MakeModelColor("lunohod", "0", "dark-orange");
        Lunohod lunohod1 = new Lunohod (makeModelColor2, 50, 1200, 500);

        Lunohod.MakeModelColor makeModelColor3 = new Lunohod.MakeModelColor("lunohod", "0", "bright-blue");
        Lunohod lunohod17 = new Lunohod (makeModelColor3, 50, 1200, 500);

        Lunohod.MakeModelColor makeModelColor4 = new Lunohod.MakeModelColor("lunohod", "0", "cosmic");
        Lunohod lunohod2 = new Lunohod (makeModelColor4, 45, 1400, 400);

        Lunohod.MakeModelColor makeModelColor5 = new Lunohod.MakeModelColor("lunohod", "0", "x-rays");
        Lunohod lunohod3 = new Lunohod (makeModelColor5, 40, 1600, 450);

    }




}
