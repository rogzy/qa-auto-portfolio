package ru.rogzy.api.aut.models.user.create;

import lombok.Getter;

@Getter
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
