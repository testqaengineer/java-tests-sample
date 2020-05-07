package ua.lvivskiy.p_harkavy.APITests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ApiTestsSwapiCo {



    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://swapi.co/api/";

    }

    @Test
    public void getPlanet1() throws JSONException {
        RequestSpecification httpRequest = RestAssured.
                given().contentType("application/json");
        Response response = httpRequest.request(Method.GET, "planets/1/");
        JSONObject jsonObject=new JSONObject(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonObject.getString("climate"), "arid");
        Assert.assertEquals(jsonObject.getString("population"), "200000");
        System.out.println("Response Body is =>  " + jsonObject);

        JSONArray jsonArray=new JSONArray(response.getBody().asString());
        System.out.println("Response Body is =>  " + jsonArray);

    }


}
