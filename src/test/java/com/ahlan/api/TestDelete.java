package com.ahlan.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class TestDelete {

    String Delete = "https://mern-backend-8881.herokuapp.com/products/6305040d7207f2c541e470e0";

    @Test
    public void testDelete(){
        when()
                .delete("GetDelete")
                .then()
                .statusCode(200)
                .log().all();

    }
    @Test
    public void testValidasiDelete() {
        given()
                .get(Delete)
                .then()
                .statusCode(200);
    }
}