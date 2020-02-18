package ru.rogzy.api.net;

import io.qameta.allure.okhttp3.AllureOkHttp3;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.rogzy.api.config.ApiCfg;
import ru.rogzy.api.core.expceptions.CoreException;

import java.io.IOException;

@NoArgsConstructor
@FieldDefaults(makeFinal = true)
public class NetSteps {

    public <T> Response<T> sendRequest(Call<T> call) {
        try {
            return call.execute();
        } catch (IOException e) {
            throw new CoreException("Ошибка при обращение к API");
        }
    }

    public <T> T createRetrofit(String baseUrl, OkHttpClient okHttpClient, Class<T> zClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(zClass);
    }

    public <T> T createRetrofit(ApiCfg cfg, Class<T> zClass) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        AllureOkHttp3 allureOkHttp3 = new AllureOkHttp3();
        if (cfg.debugMode()) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(allureOkHttp3)
                .build();
        return createRetrofit(cfg.apiUrl(), okHttpClient, zClass);
    }


}
