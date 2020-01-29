package reqres;

import com.google.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.rogzy.api.aut.models.user.create.CreateUserRequest;
import ru.rogzy.api.aut.models.user.create.CreateUserResponse;
import ru.rogzy.api.aut.models.user.delete.DeleteUserResponse;
import ru.rogzy.api.aut.models.user.edit.EditUserRequest;
import ru.rogzy.api.aut.models.user.edit.EditUserResponse;
import ru.rogzy.api.aut.models.user.get_list.GetListUsersResponse;
import ru.rogzy.api.aut.models.user.get_obj.GetUserSingleResponse;
import ru.rogzy.api.aut.models.user.update.UpdateUserRequest;
import ru.rogzy.api.aut.models.user.update.UpdateUserResponse;
import ru.rogzy.api.core.annotations.Api;
import ru.rogzy.api.net.NetSteps;
import ru.rogzy.api.retrofit.UsersRetrofit;
import ru.rogzy.api.util.UtilSteps;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Api
class ReqResTests {

    @Inject
    UtilSteps utilSteps;

    @Test
    @Tag("qa")
    @DisplayName("Проверка создание нового ползователя")
    void checkCreateUser(UsersRetrofit api,
                         NetSteps steps,
                         CreateUserRequest request,
                         CreateUserResponse expected) {
        Response<CreateUserResponse> actual = steps.sendRequest(api.createUser(request));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Проверка изменения всех данных о ползователе")
    void checkUpdateUser(UsersRetrofit api,
                         NetSteps steps,
                         UpdateUserRequest request,
                         UpdateUserResponse expected) {
        Response<UpdateUserResponse> actual = steps.sendRequest(api.updateUser(1, request));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Проверка изменения некоторых данных  ползователя")
    void checkEditUser(UsersRetrofit api,
                         NetSteps steps,
                       EditUserRequest request,
                       EditUserResponse expected) {
        Response<EditUserResponse> actual = steps.sendRequest(api.editUser(1, request));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Проверка удаления ползователя")
    void checkDeleteUser(UsersRetrofit api, NetSteps steps) {
        Response<DeleteUserResponse> actual = steps.sendRequest(api.deleteUser(1));
        utilSteps.checkResponse(actual);
    }

    @Test
    @DisplayName("Проверка конкретного ползователей")
    void checkSingleUser(UsersRetrofit api,
                         NetSteps steps,
                         GetUserSingleResponse expected) {
        Response<GetUserSingleResponse> actual = steps.sendRequest(api.getUser(2));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Проверка не существующего конкретного ползователей")
    void checkNotExistSingleUser(UsersRetrofit api,
                                 NetSteps steps,
                                 GetUserSingleResponse expected) {
        Response<GetUserSingleResponse> actual = steps.sendRequest(api.getUser(23));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Проверка отображения списка ползователей")
    void checkListUser(UsersRetrofit api,
                       NetSteps steps,
                       GetListUsersResponse expected) {
        Response<GetListUsersResponse> actual = steps.sendRequest(api.getUsers(2));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Проверка корректности задержки")
    void checkListUserWithDelay(UsersRetrofit api,
                       NetSteps steps,
                       GetListUsersResponse expected) {
        long start = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        Response<GetListUsersResponse> actual = steps.sendRequest(api.getUsersWithDelay(2));
        long end = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        utilSteps.checkResponse(actual, expected);
        utilSteps.checkTimeout(start, end, 2);
    }

}
