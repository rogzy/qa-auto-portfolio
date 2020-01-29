package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ru.rogzy.api.aut.models.user.create.CreateUserResponse;
import ru.rogzy.api.aut.models.user.edit.EditUserResponse;
import ru.rogzy.api.aut.models.user.get_list.GetListUsersResponse;
import ru.rogzy.api.aut.models.user.get_obj.GetUserSingleResponse;
import ru.rogzy.api.aut.models.user.get_obj.UserData;
import ru.rogzy.api.aut.models.user.update.UpdateUserResponse;

public class ResponseModule extends AbstractModule {

    @Override
    protected void configure() {
    }

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
    public GetListUsersResponse getListUsersResponse() {
        return new GetListUsersResponse();
    }

    @Provides
    public EditUserResponse editUserResponse() {
        return new EditUserResponse("Carl", "Engineer");
    }
}
