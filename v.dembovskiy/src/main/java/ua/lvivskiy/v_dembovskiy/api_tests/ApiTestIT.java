package ua.lvivskiy.v_dembovskiy.api_tests;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;


public class ApiTestIT {


    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://swapi.co/api/";
    }

    @Test
    public void getPlanet_1FirstExample() throws IOException {
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json");
        Response response = httpRequest.get("planets/1/");
        ObjectMapper objectMapper = new ObjectMapper();
        Planet1 parsed = objectMapper.readValue(response.getBody().asString(), new TypeReference<Planet1>() {});

        Planet1 created = new Planet1();
        created.setName("Tatooine");
        created.setRotation_period("23");
        created.setOrbital_period("304");
        created.setDiameter("10465");
        created.setClimate("arid");
        created.setGravity("1 standard");
        created.setTerrain("desert");
        created.setSurface_water("1");
        created.setPopulation("200000");
        String[] residents = {"https://swapi.co/api/people/1/",
                "https://swapi.co/api/people/2/",
                "https://swapi.co/api/people/4/",
                "https://swapi.co/api/people/6/",
                "https://swapi.co/api/people/7/",
                "https://swapi.co/api/people/8/",
                "https://swapi.co/api/people/9/",
                "https://swapi.co/api/people/11/",
                "https://swapi.co/api/people/43/",
                "https://swapi.co/api/people/62/"};
        created.setResidents(residents);
        String[] films = {"https://swapi.co/api/films/5/",
                "https://swapi.co/api/films/4/",
                "https://swapi.co/api/films/6/",
                "https://swapi.co/api/films/3/",
                "https://swapi.co/api/films/1/"};
        created.setFilms(films);
        created.setCreated("2014-12-09T13:50:49.641000Z");
        created.setEdited("2014-12-21T20:48:04.175778Z");
        created.setUrl("https://swapi.co/api/planets/1/");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(parsed, created);

//        JSONObject jsonObject = new JSONObject(response.getBody().asString());
//        Assert.assertEquals(jsonObject.getString("rotation_period"), "23");
//        Assert.assertEquals(jsonObject.getString("orbital_period"), "304");
//        Assert.assertEquals(jsonObject.getString("diameter"), "10465");
//        Assert.assertEquals(jsonObject.getString("gravity"), "1 standard");
//        Assert.assertEquals(jsonObject.getString("terrain"), "desert");
//        Assert.assertEquals(jsonObject.getString("surface_water"), "1");
//        Assert.assertEquals(jsonObject.getString("population"), "200000");

        System.out.println("IT TESTS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }



    @Test
    public void getPlanet_1SecondExample() {
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json");
        ValidatableResponse response = httpRequest.get("planets/1/").then()
                .statusCode(200).assertThat()
                .body("name", equalTo("Tatooine"),
                        "rotation_period", equalTo("23"),
                        "orbital_period", equalTo("304"),
                        "diameter", equalTo("10465"),
                        "gravity", equalTo("1 standard"),
                        "terrain", equalTo("desert"),
                        "surface_water", equalTo("1"),
                        "population", equalTo("200000"));

    }

    @Test
    public void getPlanet_1ThirdExample() {
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json");
        ValidatableResponse response = httpRequest.given().log().all().when().get("planets/1/").then()
                .statusCode(200).assertThat()
                .body("name", equalTo("Tatooine"),
                        "rotation_period", equalTo("23"),
                        "orbital_period", equalTo("304"),
                        "diameter", equalTo("10465"),
                        "gravity", equalTo("1 standard"),
                        "terrain", equalTo("desert"),
                        "surface_water", equalTo("1"),
                        "population", equalTo("200000"));
    }

    @Test
    public void getAvailableResources() throws JSONException {
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json");
        Response response = httpRequest.get();
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonObject.getString("people"), "https://swapi.co/api/people/");
        Assert.assertEquals(jsonObject.getString("planets"), "https://swapi.co/api/planets/");
        Assert.assertEquals(jsonObject.getString("films"), "https://swapi.co/api/films/");
        Assert.assertEquals(jsonObject.getString("species"), "https://swapi.co/api/species/");
        Assert.assertEquals(jsonObject.getString("vehicles"), "https://swapi.co/api/vehicles/");
        Assert.assertEquals(jsonObject.getString("starships"), "https://swapi.co/api/starships/");
    }

    @Test
    public void getPeople1() throws JSONException {
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json");
        Response response = httpRequest.get("people/1/");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonObject.getString("name"), "Luke Skywalker");
        Assert.assertEquals(jsonObject.getString("gender"), "male");
    }

    @Test
    public void getFilm1() throws JSONException {
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json");
        Response response = httpRequest.get("films/1/");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonObject.getString("title"), "A New Hope");
        Assert.assertEquals(jsonObject.getString("director"), "George Lucas");
    }

    @Test
    public void getVehicles1() throws JSONException {
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json");
        Response response = httpRequest.get("vehicles/4/");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonObject.getString("name"), "Sand Crawler");
        Assert.assertEquals(jsonObject.getString("crew"), "46");
    }

    @Test
    public void getSpecies1() throws JSONException {
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json");
        Response response = httpRequest.get("species/3/");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonObject.getString("name"), "Wookiee");
        Assert.assertEquals(jsonObject.getString("average_height"), "210");
    }

    @Test
    public void getPlanets1() throws JSONException {
        RequestSpecification httpRequest = RestAssured.given().contentType("application/json");
        Response response = httpRequest.get("planets/1/");
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(jsonObject.getString("climate"), "arid");
        Assert.assertEquals(jsonObject.getString("gravity"), "1 standard");
    }


}







