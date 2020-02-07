package ru.rogzy.api.aut.reqres.user.create;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateUserRequest {
    String name;
    String job;

    public CreateUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public CreateUserRequest() {
        this.name = "Bob";
        this.job = "Unemployed";
    }
}
