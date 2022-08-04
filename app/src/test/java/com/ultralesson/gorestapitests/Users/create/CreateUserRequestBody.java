package com.ultralesson.gorestapitests.Users.create;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestBody {

    private String name;
    private String gender;
    private String email;
    private String status;

    // Using lombok @builder instead of constructor and @getter for getter functions

}
