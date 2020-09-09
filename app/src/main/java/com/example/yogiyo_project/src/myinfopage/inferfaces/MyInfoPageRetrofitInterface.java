package com.example.yogiyo_project.src.myinfopage.inferfaces;

import com.example.yogiyo_project.src.myinfopage.models.MyInfoPageResponse;
import com.example.yogiyo_project.src.selectedStore.models.SelectStoreResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyInfoPageRetrofitInterface {
    @GET("user/detail")
    Call<MyInfoPageResponse> getMyInfo();
}
