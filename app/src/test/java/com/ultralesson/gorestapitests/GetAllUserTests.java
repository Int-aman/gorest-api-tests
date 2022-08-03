package com.ultralesson.gorestapitests;

import com.ultralesson.gorestapitests.Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllUserTests {
    // 1.Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldGetAllUsers(){

    //BDD syntax

    //2.Act
        usersClient.getAllUsers()
                .then()
    // 3.Assert
                    .statusCode(200)
                    .body("data",Matchers.hasSize(10)) //limit changed
                    .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                    .log().body();
    }
}
