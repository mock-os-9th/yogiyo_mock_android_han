package com.example.yogiyo_project.src.orderchart.interfaces;

import com.example.yogiyo_project.src.orderchart.models.OrderChartResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;

public interface OrderChartRetrofitInterfaces {
    @DELETE("user/cart")
    Call<OrderChartResponse>deleteOrderChart();
}
