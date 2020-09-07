package com.example.yogiyo_project.src.FoodCategory.interfaces;

import com.example.yogiyo_project.src.FoodCategory.models.FoodCategory1Body;
import com.example.yogiyo_project.src.FoodCategory.models.FoodCategory1Response;
import com.example.yogiyo_project.src.login.models.LogInBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodCategoryRetrofitInterface {
    @GET("stores")
    Call<FoodCategory1Response>getAllStoreList(@Query("latitude")double latitude,
                                               @Query("longitude")double longitude);
}
