package com.example.criminalintent.model.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {

    private final CrimeApi crimeApi;

    public NetworkHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/makks129/course_android")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        crimeApi = retrofit.create(CrimeApi.class);
    }

    public CrimeApi getCrimeApi() {
        return crimeApi;
    }

}
