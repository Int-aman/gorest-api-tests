package com.ultralesson.gorestapitests;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;

public class SampleTests {
    @Test
    public void shouldGetAllUsers(){
        // 1.Arrange
        // 2.Act
        // 3.Assert

        //BDD syntax
        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .body("data",Matchers.hasSize(10)) //limit changed
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                .log().body();
    }
    @Test
    public void shouldCreateUser(){
        given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization","Bearer 66d34c119ac32cbdec43d00fe589f63d3cf04985c015ca42f724735d8c1afcbf")
                    .body("{\n" +
                            "    \"name\": \"Tenali Ramakrishna\",\n" +
                            "    \"gender\": \"male\",\n" +
                            "    \"email\": \"tenali.ramakrishna10@yahoo.com\",\n" +
                            "    \"status\": \"active\"\n" +
                            "}")
                .when()
                    .post("https://gorest.co.in/public/v2/users")
                .then()
                    .log().body()
                    .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("tenali.ramakrishna10@yahoo.com"))
                .body("name", Matchers.equalTo("Tenali Ramakrishna"));
    }
}
