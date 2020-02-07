package ru.rogzy.api.aut.reqres.login;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import ru.rogzy.api.aut.reqres.StateEnum;
import ru.rogzy.api.core.expceptions.CoreException;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoginResponse {
    String token;
    String error;

    public LoginResponse(StateEnum stateEnum) {
        switch (stateEnum) {
            case success:
                this.token = "QpwL5tke4Pnpja7X4";
                this.error = null;
                break;
            case unsuccess:
                this.token = null;
                this.error = "Missing password";
                break;
            default:
                throw new CoreException("Не целевое использование");
        }
    }
}
