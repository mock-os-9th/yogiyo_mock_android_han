package com.example.yogiyo_project.src.ordercomplete.interfaces;

import com.example.yogiyo_project.src.ordercomplete.models.OrderCompleteBody;
import com.example.yogiyo_project.src.ordercomplete.models.OrderCompleteResponse;
import com.example.yogiyo_project.src.ordercomplete.models.OrderListResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OrderCompleteRetrofitInterfaces {
    @POST("user/cart/order")
    Call<OrderCompleteResponse>postOrderComplete(@Body OrderCompleteBody params);

    @GET("user/orderList")
    Call<OrderListResponse>getOrerList();
}
