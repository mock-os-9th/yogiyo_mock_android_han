package com.example.yogiyo_project.src.selectedStore.Interfaces;

import com.example.yogiyo_project.src.selectedStore.models.SelectStoreResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SelectStoreRetrofitInterface {
    @GET("store/{storeIdx}")
    Call<SelectStoreResponse> getSelectStore(@Path("storeIdx") int storeNum);
}
