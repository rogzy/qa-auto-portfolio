package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ru.rogzy.api.aut.reqres.StateEnum;
import ru.rogzy.api.aut.reqres.login.LoginRequest;
import ru.rogzy.api.aut.reqres.login.LoginResponse;
import ru.rogzy.api.core.annotations.Success;
import ru.rogzy.api.core.annotations.Unsuccess;

public class LoginModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Success
    LoginRequest getSuccessLoginRequest() {
        return new LoginRequest(StateEnum.success);
    }

    @Provides
    @Unsuccess
    LoginRequest getUnsuccessLoginRequest() {
        return new LoginRequest(StateEnum.unsuccess);
    }

    @Provides
    @Success
    LoginResponse getSuccessLoginResponse() {
        return new LoginResponse(StateEnum.success);
    }


    @Provides
    @Unsuccess
    LoginResponse getUnsuccessLoginResponse() {
        return new LoginResponse(StateEnum.unsuccess);
    }
}
