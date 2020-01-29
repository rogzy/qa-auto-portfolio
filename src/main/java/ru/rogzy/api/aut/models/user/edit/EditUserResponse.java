package ru.rogzy.api.aut.models.user.edit;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class EditUserResponse {
    String name;
    String job;
    @EqualsAndHashCode.Exclude
    String createdAt;

    public EditUserResponse(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
