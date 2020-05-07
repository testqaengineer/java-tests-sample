package ua.lvivskiy.p_harkavy.json_practice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonPractice {

    public static void main(String[] args) throws JSONException {

        String jsonExample1= "{\n" +
                "            \"objects\": [\n" +
                "            {\n" +
                "                \"a\": \"b\",\n" +
                "                    \"c\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"a\": \"d\",\n" +
                "                    \"c\": 1\n" +
                "            }\n" +
                "        ],\n" +
                "            \"nesetedObj\": {\n" +
                "            \"prop1\": \"prop2\",\n" +
                "                    \"propObj\": {\n" +
                "                \"nestedProp\": \"val\",\n" +
                "                        \"flag\": true,\n" +
                "                        \"absent\": null\n" +
                "            }\n" +
                "        }\n" +
                "        }";

        try {
            JSONObject jsonObject = new JSONObject(jsonExample1);
            JSONArray jsonArray=jsonObject.getJSONArray("objects");
            System.out.println(jsonArray);
        }
        catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }

        String jsonExample2= "[\n" +
                "        {\n" +
                "            \"prop1\": \"a\",\n" +
                "                \"prop2\": {\n" +
                "            \"key1\":\"val1\",\n" +
                "                    \"key2\":\"val2\"\n" +
                "        }\n" +
                "        }\n" +
                "]";

        JSONArray jsonArray = new JSONArray(jsonExample2) ;
        String val2=jsonArray
                .getJSONObject(0)
                .getJSONObject("prop2")
                .getString("key2");
        System.out.println(val2);

                //val2.equals("val2") == true
        //JSONArray jsonArray=jsonObject.getJSONArray("ob");

        /*
        1. Посмотреть структуру body json-а, сделать такой
        же класс со equals() и hashcode()
        2. Использоваь objectMapper() для того, что бы из json-а
        получить проинициализированные объекты3.
        3. В тестах получать 1 объект
        с помощью objectMapper-а, а 1 объект созадём руками4.
        4. Сравнить объекты 1-м ассертом, пример
        assertEquals(objectParsedWithObjectMapper, objectCreatedManualy)
        5. Для Паши -> первый джсон разобрать с помощью objectMapper-а
        6. Для Вовы -> вытащить руками из первого json-а `flag
        */



    }


}
