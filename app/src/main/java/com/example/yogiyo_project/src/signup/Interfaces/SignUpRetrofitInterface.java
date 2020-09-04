package com.example.yogiyo_project.src.signup.Interfaces;

import com.example.yogiyo_project.src.signup.models.SignUpBody;
import com.example.yogiyo_project.src.signup.models.SignUpResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface SignUpRetrofitInterface {

    @POST("/user")
    Call<SignUpResponse> signUpTest(@Body SignUpBody params);
}
