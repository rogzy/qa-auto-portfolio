package api.component.reqres;

import com.google.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.rogzy.api.aut.reqres.user.create.CreateUserRequest;
import ru.rogzy.api.aut.reqres.user.create.CreateUserResponse;
import ru.rogzy.api.aut.reqres.user.delete.DeleteUserResponse;
import ru.rogzy.api.aut.reqres.user.edit.EditUserRequest;
import ru.rogzy.api.aut.reqres.user.edit.EditUserResponse;
import ru.rogzy.api.aut.reqres.user.get_list.GetListUsersResponse;
import ru.rogzy.api.aut.reqres.user.get_obj.GetUserSingleResponse;
import ru.rogzy.api.aut.reqres.user.update.UpdateUserRequest;
import ru.rogzy.api.aut.reqres.user.update.UpdateUserResponse;
import ru.rogzy.api.core.annotations.api.Api;
import ru.rogzy.api.core.annotations.api.Delay;
import ru.rogzy.api.core.annotations.api.Simple;
import ru.rogzy.api.net.NetSteps;
import ru.rogzy.api.retrofit.UsersRetrofit;
import ru.rogzy.api.util.UtilSteps;

@Api
class UsersTests {

    @Inject
    UtilSteps utilSteps;

    @Test
    @DisplayName("Создание нового пользователя")
    void checkCreateUser(UsersRetrofit api,
                         NetSteps steps,
                         CreateUserRequest request,
                         CreateUserResponse expected) {
        Response<CreateUserResponse> actual = steps.sendRequest(api.createUser(request));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Изменение всех данных о пользователе")
    void checkUpdateUser(UsersRetrofit api,
                         NetSteps steps,
                         UpdateUserRequest request,
                         UpdateUserResponse expected) {
        Response<UpdateUserResponse> actual = steps.sendRequest(api.updateUser(1, request));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Изменение некоторых данных пользователя")
    void checkEditUser(UsersRetrofit api,
                         NetSteps steps,
                       EditUserRequest request,
                       EditUserResponse expected) {
        Response<EditUserResponse> actual = steps.sendRequest(api.editUser(1, request));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Удаления пользователя")
    void checkDeleteUser(UsersRetrofit api, NetSteps steps) {
        Response<DeleteUserResponse> actual = steps.sendRequest(api.deleteUser(1));
        utilSteps.checkResponse(actual);
    }

    @Test
    @DisplayName("Получение информации о конкретном пользователе")
    void checkSingleUser(UsersRetrofit api,
                         NetSteps steps,
                         GetUserSingleResponse expected) {
        Response<GetUserSingleResponse> actual = steps.sendRequest(api.getUser(2));
        utilSteps.checkResponse(actual, expected);
    }

    @Test

    @DisplayName("Получение информации о не существующем пользователе")
    void checkNotExistSingleUser(UsersRetrofit api,
                                 NetSteps steps,
                                 GetUserSingleResponse expected) {
        Response<GetUserSingleResponse> actual = steps.sendRequest(api.getUser(23));
        utilSteps.checkBadResponse(actual, expected);
    }

    @Test
    @DisplayName("Получение информации о списке пользователей на указанной странице")
    void checkListUser(UsersRetrofit api,
                       NetSteps steps,
                       @Simple GetListUsersResponse expected) {
        Response<GetListUsersResponse> actual = steps.sendRequest(api.getUsers(2));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Получение информации о списке пользователей с задержкой")
    void checkListUserWithDelay(UsersRetrofit api,
                       NetSteps steps,
                       @Delay GetListUsersResponse expected) {
        Response<GetListUsersResponse> actual = steps.sendRequest(api.getUsersWithDelay(2));
        utilSteps.checkResponse(actual, expected);
    }

}
