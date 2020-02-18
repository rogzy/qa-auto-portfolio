package ru.rogzy.api.aut.reqres.login;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import ru.rogzy.api.aut.reqres.StateEnum;
import ru.rogzy.api.core.expceptions.CoreException;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoginRequest {
    String email;
    String password;

    public LoginRequest(StateEnum stateEnum) {
        switch (stateEnum) {
            case SUCCESS:
                this.email = "eve.holt@reqres.in";
                this.password = "cityslicka";
                break;
            case UNSUCCESS:
                this.email = "peter@klaven";
                this.password = null;
                break;
            default:
                throw new CoreException("Не целевое использование");
        }
    }
}
