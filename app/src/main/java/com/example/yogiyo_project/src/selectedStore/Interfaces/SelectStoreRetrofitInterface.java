package com.example.yogiyo_project.src.selectedStore.Interfaces;

import com.example.yogiyo_project.src.selectedStore.models.BestMenuResponse;
import com.example.yogiyo_project.src.selectedStore.models.EachCategoryMenuResponse;
import com.example.yogiyo_project.src.selectedStore.models.MenuCategoryResponse;
import com.example.yogiyo_project.src.selectedStore.models.SelectStoreResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SelectStoreRetrofitInterface {
    @GET("store/{storeIdx}")
    Call<SelectStoreResponse> getSelectStore(@Path("storeIdx") int storeNum);

    @GET("store/{storeIdx}/bestMenu")
    Call<BestMenuResponse> getBestMenu(@Path("storeIdx")int storeNum);

    @GET("store/{storeIdx}/category")
    Call<MenuCategoryResponse> getMenuCategory(@Path("storeIdx")int storeNum);  // 메뉴 카테고리 조회

    @GET("store/{storeIdx}/category/{categoryIdx}")
    Call<EachCategoryMenuResponse> getEachCategoryMenu(@Path("storeIdx")int storeNum, @Path("categoryIdx")int categoryNum);
}
