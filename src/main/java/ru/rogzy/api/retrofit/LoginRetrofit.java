package ru.rogzy.api.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.rogzy.api.aut.reqres.login.LoginRequest;
import ru.rogzy.api.aut.reqres.login.LoginResponse;

public interface LoginRetrofit {

    String LOGIN = "login";

    @POST(LOGIN)
    Call<LoginResponse> login(@Body LoginRequest request);
}
