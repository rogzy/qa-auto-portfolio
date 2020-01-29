package ru.rogzy.api.aut.models.user.get_obj;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class UserData {
    Integer id;
    String email;
    String firstName;
    String lastName;
    String avatar;

    public UserData(Integer id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public UserData() {
        this.id = 2;
        this.email = "janet.weaver@reqres.in";
        this.firstName = "Janet";
        this.lastName = "Weaver";
        this.avatar = "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg";
    }
}
