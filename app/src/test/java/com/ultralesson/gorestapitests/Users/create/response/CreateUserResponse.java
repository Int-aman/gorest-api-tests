package com.ultralesson.gorestapitests.Users.create.response;

import com.ultralesson.gorestapitests.Users.create.CreateUserRequestBody;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class CreateUserResponse {

    @Setter  // setter only for statusCode
    private int statusCode;

    private String meta;
    private Data data;

    public void assertUser(CreateUserRequestBody requestBody) {
        assertEquals(this.getStatusCode(), 201);
        assertNotNull(this.getData().getId());
        assertEquals(this.getData().getEmail(), requestBody.getEmail());
        assertEquals(this.getData().getName(), requestBody.getName());
        assertEquals(this.getData().getGender(), requestBody.getGender());
        assertEquals(this.getData().getStatus(), requestBody.getStatus());
    }
}
