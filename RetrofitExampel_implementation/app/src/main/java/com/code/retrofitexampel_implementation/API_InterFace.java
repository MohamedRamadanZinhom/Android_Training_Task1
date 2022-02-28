package com.code.retrofitexampel_implementation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API_InterFace {
    @GET("posts/{id}")
    public Call<Post> getPost(@Path("id") String id);

    @POST("posts")
    public Call<Post> SendPost(@Body Post post);

}
