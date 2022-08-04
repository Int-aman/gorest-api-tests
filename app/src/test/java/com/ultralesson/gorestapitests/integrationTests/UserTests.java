package com.ultralesson.gorestapitests.integrationTests;

import com.ultralesson.gorestapitests.Users.UsersClient;
import com.ultralesson.gorestapitests.Users.create.CreateUserRequestBody;
import com.ultralesson.gorestapitests.Users.create.response.CreateUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class UserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldCreateAndGetUser(){

        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Rama Ramakrishna").gender("male")
                .email(email).status("active").build();

        //Act
        int id = usersClient.createUser(requestBody).getData().getId();

        //Assert
        usersClient.getUser(id).assertUser(requestBody);
    }

}
