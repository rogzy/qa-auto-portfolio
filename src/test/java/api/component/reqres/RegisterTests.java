package api.component.reqres;

import com.google.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.rogzy.api.aut.reqres.register.RegisterRequest;
import ru.rogzy.api.aut.reqres.register.RegisterResponse;
import ru.rogzy.api.core.annotations.api.Api;
import ru.rogzy.api.core.annotations.api.Success;
import ru.rogzy.api.core.annotations.api.Unsuccess;
import ru.rogzy.api.net.NetSteps;
import ru.rogzy.api.retrofit.RegisterRetrofit;
import ru.rogzy.api.util.UtilSteps;

@Api
public class RegisterTests {

    @Inject
    UtilSteps utilSteps;

    @Test
    @DisplayName("Успешная регистрация")
    void successfulRegistrationTest(
            RegisterRetrofit api,
            NetSteps steps,
            @Success RegisterResponse expected,
            @Success RegisterRequest request
    ) {
        Response<RegisterResponse> actual = steps.sendRequest(api.registration(request));
        utilSteps.checkResponse(actual, expected);
    }

    @Test

    @DisplayName("Неудачная регистрация")
    void unsuccessfulRegistrationTest(
            RegisterRetrofit api,
            NetSteps steps,
            @Unsuccess RegisterResponse expected,
            @Unsuccess RegisterRequest request
    ) {
        Response<RegisterResponse> actual = steps.sendRequest(api.registration(request));
        utilSteps.checkBadResponse(actual, expected);
    }
}
