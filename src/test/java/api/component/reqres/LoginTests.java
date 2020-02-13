package api.component.reqres;

import com.google.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.rogzy.api.aut.reqres.login.LoginRequest;
import ru.rogzy.api.aut.reqres.login.LoginResponse;
import ru.rogzy.api.core.annotations.api.Api;
import ru.rogzy.api.core.annotations.api.Success;
import ru.rogzy.api.core.annotations.api.Unsuccess;
import ru.rogzy.api.net.NetSteps;
import ru.rogzy.api.retrofit.LoginRetrofit;
import ru.rogzy.api.util.UtilSteps;


@Api
public class LoginTests {

    @Inject
    UtilSteps utilSteps;

    @Test
    @DisplayName("Успешная регистрация")
    void successfulLoginTest(
            LoginRetrofit api,
            NetSteps steps,
            @Success LoginResponse expected,
            @Success LoginRequest request
    ) {
        Response<LoginResponse> actual = steps.sendRequest(api.login(request));
        utilSteps.checkResponse(actual, expected);
    }

    @Test
    @DisplayName("Неудачная регистрация")
    void unsuccessfulLoginTest(
            LoginRetrofit api,
            NetSteps steps,
            @Unsuccess LoginResponse expected,
            @Unsuccess LoginRequest request
    ) {
        Response<LoginResponse> actual = steps.sendRequest(api.login(request));
        utilSteps.checkBadResponse(actual, expected);
    }
}
