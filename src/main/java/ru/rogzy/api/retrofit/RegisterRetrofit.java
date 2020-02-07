package ru.rogzy.api.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.rogzy.api.aut.reqres.register.RegisterRequest;
import ru.rogzy.api.aut.reqres.register.RegisterResponse;

public interface RegisterRetrofit {

    String REGISTER = "register";

    @POST(REGISTER)
    Call<RegisterResponse> registration(@Body RegisterRequest request);
}
