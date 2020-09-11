package com.example.yogiyo_project.src.ordercomplete.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OrderListResponse {
    public class OrderListResult{
        @SerializedName("storeName")
        public String orderStoreName;

        public String createdAt;

    }
    @SerializedName("result")
    public ArrayList<OrderListResult> orderListResult;
}
