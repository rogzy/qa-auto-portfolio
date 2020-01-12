package utils;

import lombok.NoArgsConstructor;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@NoArgsConstructor
public class AutSteps {

    public <T> Response<T> sendRequest(Call<T> call) {
        Response<T> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
