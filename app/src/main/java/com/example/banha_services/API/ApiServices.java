package com.example.banha_services.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices{
 @GET(value = "categories")
    public Call<List<categoryitem>>getCategory();
}
