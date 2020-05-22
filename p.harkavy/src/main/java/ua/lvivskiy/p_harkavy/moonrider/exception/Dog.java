package ua.lvivskiy.p_harkavy.moonrider.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.TreeSet;

public class Dog {

    private String name;
    private boolean isCollarPutOn;
    private boolean isLeashPutOn;
    private boolean isMuzzlePutOn;

    private Dog(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws DogIsNotReadyException {
        Dog dog = new Dog("Bobik");
        dog.putCollar();
        dog.putLeash();
        dog.putMuzzle();
        dog.walk();

        Set<String> treeSet = new TreeSet<>();
        /*try {
            File file = new File("path");
            FileInputStream fis = new FileInputStream(file);
            String s = "inside";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(s);
        }

        Integer.parseInt()

        Map mp1 = new HashMap<String, String>();
        Map mp2 = new LinkedHashMap<String, String>();
        Map mp3 = new Hashtable();
        Map mp4 = new TreeMap();
        Map mp5 = new WeakHashMap();
        */
    }

    private void putCollar() {

        System.out.println("Ошейник надет!");
        this.isCollarPutOn = true;
    }

    private void putLeash() {

        System.out.println("Поводок надет!");
        this.isLeashPutOn = true;
    }

    private void putMuzzle() {
        System.out.println("Намордник надет!");
        this.isMuzzlePutOn = true;
    }

    private void walk() throws DogIsNotReadyException {

        System.out.println("Собираемся на прогулку!");
        if (isCollarPutOn && isLeashPutOn && isMuzzlePutOn) {
            System.out.println("Ура, идем гулять! " + name + " очень рад!");
        } else {
            throw new DogIsNotReadyException("Собака " + name + " не готова к прогулке! Проверьте экипировку!");
        }
    }

}