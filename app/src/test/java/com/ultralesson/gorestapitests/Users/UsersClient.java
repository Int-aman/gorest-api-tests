package com.ultralesson.gorestapitests.Users;

import com.ultralesson.gorestapitests.Users.create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public Response createUser(CreateUserRequestBody body) {
        return
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer 66d34c119ac32cbdec43d00fe589f63d3cf04985c015ca42f724735d8c1afcbf")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v1/users");
    }

    public Response getAllUsers() {
        return given()
                .when()
                    .get("https://gorest.co.in/public/v1/users");
    }
}
