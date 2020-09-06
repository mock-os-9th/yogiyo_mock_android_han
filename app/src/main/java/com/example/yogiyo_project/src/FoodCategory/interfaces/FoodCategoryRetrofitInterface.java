package com.example.yogiyo_project.src.FoodCategory.interfaces;

import com.example.yogiyo_project.src.FoodCategory.models.FoodCategory1Body;
import com.example.yogiyo_project.src.FoodCategory.models.FoodCategory1Response;
import com.example.yogiyo_project.src.login.models.LogInBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface FoodCategoryRetrofitInterface {
    @GET("stores")
    Call<FoodCategory1Response> getAllStoreList(@Body FoodCategory1Body params);
}
