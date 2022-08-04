package com.ultralesson.gorestapitests;

import com.ultralesson.gorestapitests.Users.UsersClient;
import com.ultralesson.gorestapitests.Users.getAll.GetAllUsersResponse;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
        GetAllUsersResponse getAllUsersResponse = usersClient.getAllUsers();

    // 3.Assert
        assertEquals(getAllUsersResponse.getStatusCode(), 200);
        assertEquals(getAllUsersResponse.getDataList().size(), 10);
        assertTrue(getAllUsersResponse.hasMaleUser());
    }
}
