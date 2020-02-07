package ru.rogzy.api.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.rogzy.api.aut.reqres.resource.get_list.GetListResourceResponse;
import ru.rogzy.api.aut.reqres.resource.get_obj.GetSingleResourceResponse;

public interface ResourceRetrofit {

    String RESOURCE = "unknown";
    String WITH_ID = "/{id}";

    @GET(RESOURCE)
    Call<GetListResourceResponse> getListResources();

    @GET(RESOURCE + WITH_ID)
    Call<GetSingleResourceResponse> getSingleResource(@Path("id") Integer id);
}
