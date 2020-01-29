package ru.rogzy.api.aut.models.user.get_obj;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class GetUserSingleResponse {
    UserData data;
}
