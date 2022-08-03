package com.ultralesson.gorestapitests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldMaleCreateUser(){
        //Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna17@yahoo.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Act
        createUser(body)
                .then()
                .log().body()
                .statusCode(201)
        //Assert
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("tenali.ramakrishna17@yahoo.com"))
                .body("name", Matchers.equalTo("Tenali Ramakrishna"));
    }
    @Test
    public void shouldFemaleCreateUser(){
        String body = "{\n" +
                "    \"name\": \"Priyanka singh\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"psingh5@yahoo.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        createUser(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("psingh5@yahoo.com"))
                .body("name", Matchers.equalTo("Priyanka singh"));
    }
    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 66d34c119ac32cbdec43d00fe589f63d3cf04985c015ca42f724735d8c1afcbf")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }


}
