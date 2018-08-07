package com.example.criminalintent.model.network;

import com.example.criminalintent.model.Crime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CrimeApi {

    @GET("/master/project_criminal_intent/app/src/main/res/raw/crimes.json")
    Call<List<Crime>> getCrimes();

}
