package com.example.yogiyo_project.src.login.interfaces;

import com.example.yogiyo_project.src.login.models.LogInBody;
import com.example.yogiyo_project.src.login.models.LogInResponse;
import com.example.yogiyo_project.src.login.models.MyInfoResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LogInRetrofitInterface {
    @POST("/logIn")
    Call<LogInResponse> logInTest(@Body LogInBody params);

    @GET("user")
    Call<MyInfoResponse>getmyinfo();
}
