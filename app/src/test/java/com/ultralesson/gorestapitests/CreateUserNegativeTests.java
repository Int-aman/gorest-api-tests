package com.ultralesson.gorestapitests;

import com.ultralesson.gorestapitests.Users.UsersClient;
import com.ultralesson.gorestapitests.Users.create.CreateUserRequestBody;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        usersClient.create(requestBody)

        //Assert
                .then()
                    .statusCode(422)
                    .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                    .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}
