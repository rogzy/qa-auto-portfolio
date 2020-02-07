package ru.rogzy.api.aut.reqres.user.create;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
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
        this.id = null;
        this.createdAt = null;
    }

}
