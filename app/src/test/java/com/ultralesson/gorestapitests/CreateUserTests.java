package com.ultralesson.gorestapitests;

import com.ultralesson.gorestapitests.Users.UsersClient;
import com.ultralesson.gorestapitests.Users.create.CreateUserRequestBody;
import com.ultralesson.gorestapitests.Users.create.response.CreateUserResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.*;

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

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Rama Ramakrishna").gender("male")
                .email(email).status("active").build();

        //Act

        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);

        //Assert

        assertEquals(createUserResponse.getStatusCode(), 201);
        assertNotNull(createUserResponse.getData().getId());
        assertEquals(createUserResponse.getData().getEmail(), requestBody.getEmail());
        assertEquals(createUserResponse.getData().getName(), requestBody.getName());

    }

    @Test
    public void shouldFemaleCreateUser(){

        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Priyanka Singh").gender("female")
                .email(email).status("active").build();
        //Act
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);

        //Assert
        assertEquals(createUserResponse.getStatusCode(), 201);
        assertNotNull(createUserResponse.getData().getId());
        assertEquals(createUserResponse.getData().getEmail(), requestBody.getEmail());
        assertEquals(createUserResponse.getData().getName(), requestBody.getName());
    }

}
