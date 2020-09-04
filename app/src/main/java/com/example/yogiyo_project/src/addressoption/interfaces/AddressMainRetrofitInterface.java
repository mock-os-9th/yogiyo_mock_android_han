package com.example.yogiyo_project.src.addressoption.interfaces;

import com.example.yogiyo_project.src.ApplicationClass;
import com.example.yogiyo_project.src.addressoption.models.AddressResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface AddressMainRetrofitInterface {

    @Headers("Authorization:KakaoAK f8c69dbfdf18a626af6d5ef9678dfd34")
    @GET("v2/local/search/address.json")
    Call<AddressResponse>getAddressData(@Query("query")String myAdress);
}
