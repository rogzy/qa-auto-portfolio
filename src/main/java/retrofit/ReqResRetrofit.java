package retrofit;

import requestes.CreateUserReq;
import requestes.UpdateUserReq;
import responses.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface ReqResRetrofit {
    @GET("users")
    Call<UsersRes> getUsers(@Query("page") Integer page);

    @GET("users/{id}")
    Call<UserObjRes> getUser(@Path("id") Integer id);

    @POST("users")
    Call<CreateUserRes> createUser(@Body CreateUserReq request);

    @PUT("users/{id}")
    Call<UpdateUserRes> updateUser(@Path("id") Integer id, @Body UpdateUserReq request);

    @DELETE("users/{id}")
    Call<DeleteUserRes> deleteUser(@Path("id") Integer id);
}
