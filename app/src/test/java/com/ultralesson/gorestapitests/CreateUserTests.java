package com.ultralesson.gorestapitests;

import com.ultralesson.gorestapitests.Users.UsersClient;
import com.ultralesson.gorestapitests.Users.create.CreateUserRequestBody;
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
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String name = "Rama Ramakrishna";
        String gender = "male";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        //Act
        usersClient.createUser(requestBody)
                .then()
                    .log().body()
                    .statusCode(201)
        //Assert
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email))
                .body("data.name", Matchers.equalTo("Rama Ramakrishna"));
    }

    @Test
    public void shouldFemaleCreateUser(){

        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String name = "Priyanka Singh";
        String gender = "female";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        //Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email))
                .body("data.name", Matchers.equalTo(name));
    }

}
