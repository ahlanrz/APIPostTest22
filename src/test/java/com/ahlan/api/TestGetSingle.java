package com.ahlan.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGetSingle {
    String GetSingle = "https://mern-backend-8881.herokuapp.com/products/62e210f1f0e24546b900e05f";

    @Test
    public void testStatusCodeGetList() {
        Response response = RestAssured.get(GetSingle);

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int actual = response.getStatusCode();
        Assert.assertEquals(actual, 200);
    }

    @Test
    public void testValidasiGetSingle() {
        given()
                .get(GetSingle)
                .then()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("category", equalTo("katalon"))
                .body("price", equalTo(3000));
    }
}
