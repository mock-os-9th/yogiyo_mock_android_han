package com.example.yogiyo_project.src.ordercomplete.models;

import com.google.gson.annotations.SerializedName;

public class OrderCompleteBody {
    @SerializedName("payMethod")
    private String payMethod;   //ex> "Y"


    public OrderCompleteBody(String payMethod) {
        this.payMethod = payMethod;

    }
}
