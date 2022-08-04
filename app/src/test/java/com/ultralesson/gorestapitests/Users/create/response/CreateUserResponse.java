package com.ultralesson.gorestapitests.Users.create.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserResponse {

    @Setter  // setter only for statusCode
    private int statusCode;

    private String meta;
    private Data data;
}
