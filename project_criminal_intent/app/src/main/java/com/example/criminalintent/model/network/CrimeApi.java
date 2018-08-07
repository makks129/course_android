package com.example.criminalintent.model.network;

import com.example.criminalintent.model.Crime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CrimeApi {

    @GET("url") // todo URL
    Call<List<Crime>> getCrimes();

}
