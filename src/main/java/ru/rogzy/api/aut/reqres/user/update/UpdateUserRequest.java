package ru.rogzy.api.aut.reqres.user.update;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateUserRequest {
    String name;
    String job;

    public UpdateUserRequest() {
        this.name = "John";
        this.job = "Doctor";
    }

    public UpdateUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
