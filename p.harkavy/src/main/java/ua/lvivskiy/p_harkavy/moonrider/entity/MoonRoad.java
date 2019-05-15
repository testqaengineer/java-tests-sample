package ua.lvivskiy.p_harkavy.moonrider.entity;

import java.util.HashMap;

public class MoonRoad {
    private int distance;

   static {
       HashMap<String, Double> roadTypes=new HashMap<>();
       roadTypes.put("Gravel_moon_road", 1.6);
       roadTypes.put("Dirt_moon_road", 1.2);
       roadTypes.put("MoonHighway", 0.9);
       roadTypes.put("Forest_moon_road", 1.4);
   }

    private float type;

    public MoonRoad(int distance, float type) {
        this.distance = distance;
        this.type = type;
    }

    public int getDistance() {
        return distance;
    }

    public float getType() {
        return type;
    }

}
