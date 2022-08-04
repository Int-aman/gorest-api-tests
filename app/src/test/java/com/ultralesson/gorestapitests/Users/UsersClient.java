package com.ultralesson.gorestapitests.Users;

import com.ultralesson.gorestapitests.Users.create.CreateUserRequestBody;
import com.ultralesson.gorestapitests.Users.create.response.CreateUserErrorResponse;
import com.ultralesson.gorestapitests.Users.create.response.CreateUserResponse;
import com.ultralesson.gorestapitests.Users.get.GetUserResponse;
import com.ultralesson.gorestapitests.Users.getAll.GetAllUsersResponse;
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

    public GetAllUsersResponse getAllUsers() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response
                .then()
                    .log().body();

        int statusCode = response.statusCode();

        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatusCode(statusCode);

        return getAllUsersResponse;
    }

    public GetUserResponse getUser(int id){
        Response response =
                given()
                    .pathParam("id", id)
                .when()
                    .get("https://gorest.co.in/public/v1/users/{id}");

        response.
                then()
                    .log().body();

        int statusCode = response.statusCode();

        GetUserResponse getUserResponse = response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(statusCode);
        return getUserResponse;
    }
}
