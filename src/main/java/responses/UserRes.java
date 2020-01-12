package responses;

import lombok.Getter;

import java.util.Objects;

@Getter
public class UserRes {
    Integer id;
    String email;
    String firstName;
    String lastName;
    String avatar;

    public UserRes(Integer id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public UserRes() {
        this.id = 2;
        this.email = "janet.weaver@reqres.in";
        this.firstName = "Janet";
        this.lastName = "Weaver";
        this.avatar = "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRes userRes = (UserRes) o;
        return Objects.equals(id, userRes.id) &&
                Objects.equals(email, userRes.email) &&
                Objects.equals(firstName, userRes.firstName) &&
                Objects.equals(lastName, userRes.lastName) &&
                Objects.equals(avatar, userRes.avatar);
    }
}
