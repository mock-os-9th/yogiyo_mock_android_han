package com.example.yogiyo_project.src.FoodCategory.models;

import com.google.gson.annotations.SerializedName;

public class FoodCategory1Body {
    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    public FoodCategory1Body(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
