package ua.lvivskiy.v_dembovskiy.car.entity;



import com.jayway.restassured.RestAssured;


import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.*;




public class API_Test {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://swapi.co/api/";

    }

    @Test
    public void getResources(){
        RequestSpecification httpRequest = RestAssured.given()
                .contentType("application/json");
        Response response = httpRequest.get("people/1/");
        String r = response.getBody().asString();
        System.out.println(r);


    }






}
