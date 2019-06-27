package ua.lvivskiy.v_dembovskiy.sample.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class checkFileIT {


    @Before
    public void createNewFile() throws IOException {
        System.out.println(" IT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        File file = new File("C:\\Users\\Vladimir\\AppData\\Local\\Temp", "Hello.txt");
        Writer writer = new BufferedWriter(new FileWriter(file, true));
        writer.append("My new test");
        writer.close();
    }

    @Test
    public void checkFile() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Vladimir\\AppData\\Local\\Temp\\Hello.txt")));
        assertEquals("My new test", content);

    }

    @After
    public void deleteNewFile() {
        try {
            File file = new File("C:\\Users\\Vladimir\\AppData\\Local\\Temp\\Hello.txt");
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}