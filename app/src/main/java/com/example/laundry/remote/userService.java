package com.example.laundry.remote;


import com.example.laundry.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface userService {
    @GET("user")
    Call<List<User>> getUser();

    @GET("user/username/{username}")
    Call<User> getUserInfo(@Path("username")String username);

    @Headers({"Accept: application/json"})
    @POST("user/register")
    Call<User> register(@Body User user);

}

