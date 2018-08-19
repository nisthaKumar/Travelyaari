package com.example.niskumar.travelyaari;

import retrofit2.Call;

import retrofit2.http.GET;

/**
 * Created by niskumar on 15-08-2018.
 */

public interface Api {

    String BASE_URL = "https://api.myjson.com/bins/";
    @GET("7afms")
    Call<ResponseDTO> getRoutes();

}
