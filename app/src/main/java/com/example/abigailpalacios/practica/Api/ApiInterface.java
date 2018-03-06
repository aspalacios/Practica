package com.example.abigailpalacios.practica.Api;

import com.example.abigailpalacios.practica.models.Practica;
import com.example.abigailpalacios.practica.models.TweetModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Abigail Palacios on 20/02/2018.
 */

public interface ApiInterface {
    @GET("/")
    Call<List<Practica>> getPracticas();
    @POST("tweets")
    Call<TweetModel> createTweet(@Body TweetModel tweet);
}
