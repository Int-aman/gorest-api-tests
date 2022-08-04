package com.ultralesson.gorestapitests;

import com.ultralesson.gorestapitests.Users.UsersClient;
import com.ultralesson.gorestapitests.Users.create.CreateUserRequestBody;
import com.ultralesson.gorestapitests.Users.create.response.CreateUserErrorResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateUserNegativeTests {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //Arrange
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Priyanka Singh").gender("female")
                .email("p.singh1yahoo.com").status("active").build();
        //Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingResponse(requestBody);

        //Assert
        assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("email", "is invalid");

    }

    @Test
    public void shouldNotAllowWithBlankGenderAndStatus(){
        //Arrange
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Priyanka Singh").gender("")
                .email("p.singh1yahoo@com").status("").build();
        //Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingResponse(requestBody);

        //Assert
        assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("gender", "can't be blank, can be male or female");
        errorResponse.assertHasError("status", "can't be blank");
    }
}
