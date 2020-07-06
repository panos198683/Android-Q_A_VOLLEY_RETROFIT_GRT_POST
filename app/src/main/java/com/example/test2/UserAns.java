package com.example.test2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAns {
    @POST("userA")
   Call<UserA> createAns(@Body UserA userA);
}
