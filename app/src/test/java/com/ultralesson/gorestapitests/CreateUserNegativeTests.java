package com.ultralesson.gorestapitests;

import com.ultralesson.gorestapitests.Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateUserNegativeTests {
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //Arrange
        String body = "{\n" +
                "    \"name\": \"Priyanka Singh\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"email\": \"psingh1yahoo.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
                //Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }
}
