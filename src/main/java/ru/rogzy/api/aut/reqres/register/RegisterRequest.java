package ru.rogzy.api.aut.reqres.register;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import ru.rogzy.api.aut.reqres.StateEnum;
import ru.rogzy.api.core.expceptions.CoreException;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegisterRequest {
    String email;
    String password;

    public RegisterRequest(StateEnum stateEnum) {
        switch (stateEnum) {
            case success:
                this.email = "eve.holt@reqres.in";
                this.password = "pistol";
                break;
            case unsuccess:
                this.email = "sydney@fife";
                this.password = null;
                break;
            default:
                throw new CoreException("Не целевое использование");
        }
    }
}
