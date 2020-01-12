package retrofit;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Tech {

    public static <T> T createClient(String baseUrl, Class<T> zClass) {
        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return client.create(zClass);
    }

}
