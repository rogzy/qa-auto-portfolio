package ru.rogzy.api.net;

import lombok.Data;
import okhttp3.Headers;
import retrofit2.Response;

import java.io.IOException;

@Data
public class NetResponse<T> {
    int code;
    Boolean isSuccessful;
    Headers headers;
    T body;
    okhttp3.Response raw;
    String errorBody;

    public NetResponse(Response<T> response) {
        code = response.code();
        isSuccessful = response.isSuccessful();
        headers = response.headers();
        if (response.isSuccessful()) {
            body = response.body();
        } else {
            raw = response.raw();
            try {
                errorBody = response.errorBody() != null ? response.errorBody().string() : "";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
