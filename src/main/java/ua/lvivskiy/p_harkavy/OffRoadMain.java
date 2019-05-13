package java.ua.lvivskiy.p_harkavy;

import java.ua.lvivskiy.p_harkavy.lunohod.entity.Lunohod;
import java.ua.lvivskiy.p_harkavy.lunohod.exception.LunohodRefuelingException;


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
        }
        catch (LunohodRefuelingException e) {
            lunohod0.setIgnitionOn(false);
            lunohod0.refuel(1);
        }

        //завести, и заставить проехать разные расстояния,

        lunohod0.startEngine(true);
        lunohod0.ride(400);






    }







}
