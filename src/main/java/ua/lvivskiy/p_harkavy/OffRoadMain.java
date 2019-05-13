package ua.lvivskiy.p_harkavy;

import ua.lvivskiy.p_harkavy.moonrider.entity.Moonrider;
import ua.lvivskiy.p_harkavy.moonrider.exception.MoonriderRefuelingException;


public class OffRoadMain {

    public static void main(String[] args) {
        Moonrider.MakeModelColor makeModelColor1 = new Moonrider.MakeModelColor("moonrider", "0", "metallic");
        Moonrider lunohod0 = new Moonrider(makeModelColor1, 60, 1000, 600);

        Moonrider.MakeModelColor makeModelColor2 = new Moonrider.MakeModelColor("moonrider", "0", "dark-orange");
        Moonrider lunohod1 = new Moonrider(makeModelColor2, 50, 1200, 500);

        Moonrider.MakeModelColor makeModelColor3 = new Moonrider.MakeModelColor("moonrider", "0", "bright-blue");
        Moonrider lunohod17 = new Moonrider(makeModelColor3, 50, 1200, 500);

        Moonrider.MakeModelColor makeModelColor4 = new Moonrider.MakeModelColor("moonrider", "0", "bright-blue");
        Moonrider lunohod2 = new Moonrider(makeModelColor4, 45, 1400, 400);

        Moonrider.MakeModelColor makeModelColor5 = new Moonrider.MakeModelColor("moonrider", "0", "x-rays");
        Moonrider lunohod3 = new Moonrider(makeModelColor5, 40, 1600, 450);

        /**
         * CONFLICT (add/add): Merge conflict in src/test/java/ua/lvivskiy/p_harkavy/car/entity/CarTest.java
         Auto-merging src/test/java/ua/lvivskiy/p_harkavy/car/entity/CarTest.java
         Auto-merging src/main/java/ua/lvivskiy/v_dembovskiy/car/exeption/IgnitionOnException.java
         CONFLICT (content): Merge conflict in src/main/java/ua/lvivskiy/v_dembovskiy/car/exeption/IgnitionOnException.java
         Auto-merging src/main/java/ua/lvivskiy/v_dembovskiy/RacingMain.java
         CONFLICT (content): Merge conflict in src/main/java/ua/lvivskiy/v_dembovskiy/RacingMain.java
         Removing src/main/java/ua/lvivskiy/v_dembovskiy/Car.java
         Auto-merging .idea/workspace.xml
         CONFLICT (content): Merge conflict in .idea/workspace.xml
         Auto-merging .idea/misc.xml
         CONFLICT (content): Merge conflict in .idea/misc.xml
         Automatic merge failed; fix conflicts and then commit the result.
         **/

        try {
            lunohod0.refuel(1);
        } catch (MoonriderRefuelingException e) {
            lunohod0.setIgnitionOn(false);
            lunohod0.refuel(1);
        }

        //завести, и заставить проехать разные расстояния,

        lunohod0.startEngine(true);
        lunohod0.ride(400);


    }


}
