package ru.rogzy.api.aut.models.user.update;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class UpdateUserResponse {
    String name;
    String job;
    @EqualsAndHashCode.Exclude
    String createdAt;

    public UpdateUserResponse(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
