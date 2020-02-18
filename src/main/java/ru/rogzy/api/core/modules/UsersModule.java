package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ru.rogzy.api.aut.reqres.StateEnum;
import ru.rogzy.api.aut.reqres.user.create.CreateUserRequest;
import ru.rogzy.api.aut.reqres.user.create.CreateUserResponse;
import ru.rogzy.api.aut.reqres.user.edit.EditUserRequest;
import ru.rogzy.api.aut.reqres.user.edit.EditUserResponse;
import ru.rogzy.api.aut.reqres.user.get_list.GetListUsersResponse;
import ru.rogzy.api.aut.reqres.user.get_obj.GetUserSingleResponse;
import ru.rogzy.api.aut.reqres.user.get_obj.UserData;
import ru.rogzy.api.aut.reqres.user.update.UpdateUserRequest;
import ru.rogzy.api.aut.reqres.user.update.UpdateUserResponse;
import ru.rogzy.api.core.annotations.api.Delay;
import ru.rogzy.api.core.annotations.api.Simple;

public class UsersModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    //requests

    @Provides
    public CreateUserRequest getCreateUserRequest() {
        return new CreateUserRequest();
    }

    @Provides
    public UpdateUserRequest getUpdateUserRequest() {
        return new UpdateUserRequest();
    }

    @Provides
    public EditUserRequest getEditUserRequest() {
        return new EditUserRequest();
    }

    //responses

    @Provides
    public CreateUserResponse getCreateUserResponse() {
        return new CreateUserResponse("Bob", "Unemployed");
    }

    @Provides
    public UpdateUserResponse getUpdateUserResponse() {
        return new UpdateUserResponse("John", "Doctor");
    }

    @Provides
    public GetUserSingleResponse getUserSingleResponse() {
        return new GetUserSingleResponse(new UserData());
    }

    @Provides
    @Delay
    public GetListUsersResponse getListUsersResponseWithDelay() {
        return new GetListUsersResponse(StateEnum.DELAY);
    }

    @Provides
    @Simple
    public GetListUsersResponse getListUsersResponse() {
        return new GetListUsersResponse(StateEnum.SIMPLE);
    }

    @Provides
    public EditUserResponse editUserResponse() {
        return new EditUserResponse("Carl", "Engineer");
    }
}
