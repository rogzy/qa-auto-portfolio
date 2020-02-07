package ru.rogzy.api.aut.reqres.user.edit;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EditUserResponse {
    String name;
    String job;
    @EqualsAndHashCode.Exclude
    String createdAt;

    public EditUserResponse(String name, String job) {
        this.name = name;
        this.job = job;
        this.createdAt = null;
    }
}
