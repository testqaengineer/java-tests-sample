package ua.lvivskiy.p_harkavy.lunohod.entity;

public class Lunohod {


    // ДЗ1:
    // Написать класс Lunohod (model, color, fuel consumption, odo(одометр), curr fuel level, tank volume, ignition (on/off))
    // машины должны ездить(только если заведены), методы: turnOn, turnOff, ride(distance), refuel(liters)
    // Конструкторы должны быть с перегрузкой (сделать возможность создавать с дефолтными tank fuel volume и fuel consumption
    // Создать 5 машинок (в main-е), заправить их, завести, и заставить проехать разные расстояния,
    // Должно быть 3 класса - Car и OffRoadMain и класс с исключениями
    // Доделать класс Car методы (refuel, ride, startEngine, stopEngine) c собственніми исключениями (Метод ride должен
    // бросать исключение (подумать, какое - checked или unchecked, посмотреть иерархию,
    // почитать про них, посмотреть головача на ютубе, (если не хватило бензина на всю дистанцию)

    // ДЗ2:
    // 1. Изучить возможные библиотеки для юнит тестов, все самые используемые, разницу тестНЖ и ДжиЮнит (дифф 4 и 5 версии)
    // 2. Жизненный цикл мавен детально изучить, прописывание скоупов в поме
    // 2. Покрыть юниттестами Car Тесты не должны зависеть один от другого и от порядка выполнения.
    //

    /** java doc how to
     *  AltInsert hotKeys which add constructor
     *  psvm and Enter this is hotKeys which add main method
     */

    private final String make;
    private String model;
    private String color;
    private int fuelConsump;
    private int distance;
    private final int tank_volame;

    /**- если это entity или DTO - то в конструктор можно хоть 20 параметров. Иначе получается,
     * что бы создать один контейнер, создаём ещё один контейнер
     - если это специфиеский метод (или конструктор не entity/DTO), в который нужно много всего -
     то тогда да, есть смысл написать контейнер.
     А вообще нужно задуматься, как написать, что бы было наиболее понятно и соответствовало общеринятым нормам**/

    public static class MakeModelColor {
        String make;
        String model;
        String color;

        public MakeModelColor(String make, String model, String color) {
            this.make = make;
            this.model = model;
            this.color = color;
        }
    }

    public Lunohod(MakeModelColor makeModelColor, int fuelConsump, int distance, int tank_volame) {
        this.make=makeModelColor.make;
        this.model=makeModelColor.model;
        this.color=makeModelColor.color;
        this.fuelConsump = fuelConsump;
        this.distance = distance;
        this.tank_volame = tank_volame;
    }


}
