package com.ahlan.api;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPatch {
    String GetPatch = "https://mern-backend-8881.herokuapp.com/products/630504187207f2c541e470e3";

    @Test
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("name", "Ahlan");
        request.put("category", "SQA DIKA");
        request.put("price", 9000);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://mern-backend-8881.herokuapp.com/products/630504187207f2c541e470e3")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void testValidasiPatch() {
        given()
                .get(GetPatch)
                .then()
                .statusCode(200)
                .body("name", equalTo("Ahlan"))
                .body("category", equalTo("SQA DIKA"))
                .body("price", equalTo(9000));
    }
}
