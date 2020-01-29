package ru.rogzy.api.core.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ru.rogzy.api.aut.models.user.create.CreateUserRequest;
import ru.rogzy.api.aut.models.user.edit.EditUserRequest;
import ru.rogzy.api.aut.models.user.update.UpdateUserRequest;

public class RequestModule extends AbstractModule {

    @Override
    protected void configure() {
    }

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
}
