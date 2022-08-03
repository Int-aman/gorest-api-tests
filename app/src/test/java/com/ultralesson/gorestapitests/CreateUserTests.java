package com.ultralesson.gorestapitests;

import com.ultralesson.gorestapitests.Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class CreateUserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldMaleCreateUser(){
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        //Arrange
        String body = String.format("{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);

        //Act
        usersClient.createUser(body)
                .then()
                    .log().body()
                    .statusCode(201)
        //Assert
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email))
                .body("data.name", Matchers.equalTo("Tenali Ramakrishna"));
    }

    @Test
    public void shouldFemaleCreateUser(){
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "    \"name\": \"Priyanka Singh\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}", email);
        usersClient.createUser(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email))
                .body("data.name", Matchers.equalTo("Priyanka Singh"));
    }

}
