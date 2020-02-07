package ru.rogzy.api.util;

import org.assertj.core.api.SoftAssertions;
import retrofit2.Response;
import ru.rogzy.api.net.NetResponse;

public class UtilSteps {

    public <T> NetResponse<T> checkResponse(Response<T> response, T expected) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.isSuccessful()).isTrue();
        softAssertions.assertThat(response.body()).isEqualTo(expected);
        softAssertions.assertAll();
        return new NetResponse<>(response);
    }

    public <T> NetResponse<T> checkBadResponse(Response<T> response, T expected) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.isSuccessful()).isFalse();
        softAssertions.assertThat(response.errorBody()).isNotNull();
        softAssertions.assertAll();
        return new NetResponse<>(response);
    }

    public <T> NetResponse<T> checkResponse(Response<T> response) {
        return checkResponse(response, null);
    }
}
