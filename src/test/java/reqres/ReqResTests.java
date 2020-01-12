package reqres;

import core.ReqResModule;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import requestes.CreateUserReq;
import requestes.UpdateUserReq;
import responses.*;
import retrofit.ReqResRetrofit;
import retrofit2.Call;
import retrofit2.Response;
import utils.AutSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("demo")
@IncludeModule(ReqResModule.class)
class ReqResTests {

    @Test
    @DisplayName("Проверка создание нового ползователя")
    void checkCreateUser(ReqResRetrofit api,
                         AutSteps steps,
                         CreateUserReq request,
                         CreateUserRes expected) {
        Call<CreateUserRes> call = api.createUser(request);
        Response<CreateUserRes> actual = steps.sendRequest(call);

        assertThat(actual.isSuccessful()).isTrue();
        assertThat(actual.body()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка обновления ползователя")
    void checkUpdateUser(ReqResRetrofit api,
                         AutSteps steps,
                         UpdateUserReq request,
                         UpdateUserRes expected) {
        Response<UpdateUserRes> actual = steps.sendRequest(api.updateUser(1, request));

        assertThat(actual.isSuccessful()).isTrue();
        assertThat(actual.body()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка удаления ползователя")
    void checkDeleteUser(ReqResRetrofit api, AutSteps steps) {
        Response<DeleteUserRes> response = steps.sendRequest(api.deleteUser(1));

        assertThat(response.isSuccessful()).isTrue();
    }

    @Test
    @DisplayName("Проверка конкретного ползователей")
    void checkSingleUser(ReqResRetrofit api,
                         AutSteps steps,
                         UserObjRes expected) {
        Response<UserObjRes> actual = steps.sendRequest(api.getUser(2));

        assertThat(actual.isSuccessful()).isTrue();
        assertThat(actual.body()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка отображения списка ползователей")
    void checkListUser(ReqResRetrofit api, AutSteps steps) {
        Response<UsersRes> response = steps.sendRequest(api.getUsers(2));

        assertThat(response.isSuccessful()).isTrue();
    }


}
