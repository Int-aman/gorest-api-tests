package com.ultralesson.gorestapitests;

import com.ultralesson.gorestapitests.Users.UsersClient;
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
                "    \"email\": \"tenali.ramakrishna23@yahoo.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
                .statusCode(201)
        //Assert
//                .body("id", Matchers.notNullValue())
//                .body("data", Matchers.hasItem("id",Matchers.notNullValue()))
                .body("data", Matchers.hasItem(Matchers.hasEntry("email", "tenali.ramakrishna23@yahoo.com")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("name", "Tenali Ramakrishna")));
//                .body("email", Matchers.equalTo("tenali.ramakrishna20@yahoo.com"))
//                .body("name", Matchers.equalTo("Tenali Ramakrishna"));
    }

    @Test
    public void shouldFemaleCreateUser(){
        String body = "{\n" +
                "    \"name\": \"Priyanka singh\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"psingh5@yahoo.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        new UsersClient().createUser(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("psingh5@yahoo.com"))
                .body("name", Matchers.equalTo("Priyanka singh"));
    }

}
