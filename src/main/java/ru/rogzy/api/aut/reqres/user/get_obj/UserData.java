package ru.rogzy.api.aut.reqres.user.get_obj;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserData {
    Integer id;
    String email;
    String firstName;
    String lastName;
    String avatar;

    public UserData() {
        this.id = 2;
        this.email = "janet.weaver@reqres.in";
        this.firstName = "Janet";
        this.lastName = "Weaver";
        this.avatar = "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg";
    }
}
