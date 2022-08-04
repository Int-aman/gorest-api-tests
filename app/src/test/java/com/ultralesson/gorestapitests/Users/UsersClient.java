package com.ultralesson.gorestapitests.Users;

import com.ultralesson.gorestapitests.Users.create.CreateUserRequestBody;
import com.ultralesson.gorestapitests.Users.create.response.CreateUserErrorResponse;
import com.ultralesson.gorestapitests.Users.create.response.CreateUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingResponse(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }

    public Response create(CreateUserRequestBody body) {
        Response response =
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer 66d34c119ac32cbdec43d00fe589f63d3cf04985c015ca42f724735d8c1afcbf")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v1/users");

        response
                .then()
                    .log().body();
        return
                response;
    }

    public Response getAllUsers() {
        return given()
                .when()
                    .get("https://gorest.co.in/public/v1/users");
    }
}
