package ru.rogzy.api.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ru.rogzy.api.aut.models.user.create.CreateUserRequest;
import ru.rogzy.api.aut.models.user.create.CreateUserResponse;
import ru.rogzy.api.aut.models.user.delete.DeleteUserResponse;
import ru.rogzy.api.aut.models.user.edit.EditUserRequest;
import ru.rogzy.api.aut.models.user.edit.EditUserResponse;
import ru.rogzy.api.aut.models.user.get_list.GetListUsersResponse;
import ru.rogzy.api.aut.models.user.get_obj.GetUserSingleResponse;
import ru.rogzy.api.aut.models.user.update.UpdateUserRequest;
import ru.rogzy.api.aut.models.user.update.UpdateUserResponse;

public interface UsersRetrofit {

    String USERS = "users";
    String WITH_ID = "/{id}";
    String DELAY = "/{delay}";
    String USERS_BY_ID = USERS + WITH_ID;
    String USERS_DELAY = USERS + DELAY;

    @GET(USERS)
    Call<GetListUsersResponse> getUsers(@Query("page") Integer page);

    @GET(USERS_BY_ID)
    Call<GetUserSingleResponse> getUser(@Path("id") Integer id);

    @POST(USERS)
    Call<CreateUserResponse> createUser(@Body CreateUserRequest request);

    @PUT(USERS_BY_ID)
    Call<UpdateUserResponse> updateUser(@Path("id") Integer id, @Body UpdateUserRequest request);

    @PATCH(USERS_BY_ID)
    Call<EditUserResponse> editUser(@Path("id") Integer id, @Body EditUserRequest request);

    @DELETE(USERS_BY_ID)
    Call<DeleteUserResponse> deleteUser(@Path("id") Integer id);

    @GET(USERS_DELAY)
    Call<GetListUsersResponse> getUsersWithDelay(@Query("delay") Integer delay);
}
