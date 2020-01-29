package ru.rogzy.api.aut.models.user.create;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class CreateUserResponse {
    String name;
    String job;
    @EqualsAndHashCode.Exclude
    String id;
    @EqualsAndHashCode.Exclude
    String createdAt;

    public CreateUserResponse(String name, String job) {
        this.name = name;
        this.job = job;
    }

}
