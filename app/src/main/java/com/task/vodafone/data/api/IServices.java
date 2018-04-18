package com.task.vodafone.data.api;

import com.task.vodafone.data.models.bundle.BundlesResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface IServices {

    @GET("/getIllegibleMI")
    Call<BundlesResponse> getBundlesRequest();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://demo0396087.mockable.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
