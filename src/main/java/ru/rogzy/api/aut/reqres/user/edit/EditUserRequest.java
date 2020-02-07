package ru.rogzy.api.aut.reqres.user.edit;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EditUserRequest {
    String name;
    String job;

    public EditUserRequest() {
        this.name = "Carl";
        this.job = "Engineer";
    }

    public EditUserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
