package ru.rogzy.api.net;

import lombok.Data;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Data
public class NetResponse<T> {
    int code;
    Boolean isSuccessful;
    Headers headers;
    T body;
    okhttp3.Response raw;
    ResponseBody errorBody;

    public NetResponse(Response<T> response) {
        code = response.code();
        isSuccessful = response.isSuccessful();
        headers = response.headers();
        if (response.isSuccessful()) {
            body = response.body();
        } else {
            raw = response.raw();
            errorBody = response.errorBody();
        }
    }
}
