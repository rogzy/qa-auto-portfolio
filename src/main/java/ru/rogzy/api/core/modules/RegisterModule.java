package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ru.rogzy.api.aut.reqres.StateEnum;
import ru.rogzy.api.aut.reqres.register.RegisterRequest;
import ru.rogzy.api.aut.reqres.register.RegisterResponse;
import ru.rogzy.api.core.annotations.api.Success;
import ru.rogzy.api.core.annotations.api.Unsuccess;

public class RegisterModule extends AbstractModule {
    @Override
    protected void configure() {
    }
    
    @Provides
    @Success
    RegisterRequest getSuccessRegisterRequest() {
        return new RegisterRequest(StateEnum.SUCCESS);
    }

    @Provides
    @Unsuccess
    RegisterRequest getUnsuccessRegisterRequest() {
        return new RegisterRequest(StateEnum.UNSUCCESS);
    }

    @Provides
    @Success
    RegisterResponse getSuccessRegisterResponse() {
        return new RegisterResponse(StateEnum.SUCCESS);
    }


    @Provides
    @Unsuccess
    RegisterResponse getUnsuccessRegisterResponse() {
        return new RegisterResponse(StateEnum.UNSUCCESS);
    }
}
