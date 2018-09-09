package com.example.aathira.shoppingcart.retrofit;

import com.example.aathira.shoppingcart.Phone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("get-items")
    Call<List<Phone>> getPhone();

}
