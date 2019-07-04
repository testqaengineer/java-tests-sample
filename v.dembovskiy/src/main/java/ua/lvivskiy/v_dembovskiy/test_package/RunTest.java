package ua.lvivskiy.v_dembovskiy.test_package;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.lvivskiy.v_dembovskiy.car.entity.Car;

import java.io.IOException;
import java.util.List;

public class RunTest {


    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<B> listB = objectMapper.readValue("[\n" +
                "{\n" +
                "\"prop1\": \"a\",\n" +
                "\"prop2\": {\n" +
                "\"key1\":\"val1\",\n" +
                "\"key2\":\"val2\"\n" +
                "}\n" +
                "}\n" +
                "]", new TypeReference<List<B>>() {});

        String val = listB.get(0).getProp2().getKey2();
        System.out.println(val);

        B parsed = listB.get(0);
        B created = new B();
        created.setProp1("a");
        A a = new A();
        a.setKey1("val1");
        a.setKey2("val2");
        created.setProp2(a);
        System.out.println(parsed.equals(created));

        MainClass mainClass = objectMapper.readValue("{\n" +
                "\"objects\": [\n" +
                "{\n" +
                "\"a\": \"b\",\n" +
                "\"c\": 1 \n" +
                "},\n" +
                "{\n" +
                "\"a\": \"d\",\n" +
                "\"c\": 1 \n" +
                "}\n" +
                "],\n" +
                "\"nesetedObj\": {\n" +
                "\"prop1\": \"prop2\",\n" +
                "\"propObj\": {\n" +
                "\"nestedProp\": \"val\",\n" +
                "\"flag\": true,\n" +
                "\"absent\": null\n" +
                "}\n" +
                "}\t\n" +
                "}", MainClass.class);

        Boolean flag = mainClass.getNesetedObj().getPropObj().getFlag();

        System.out.println(flag);





    }
}
