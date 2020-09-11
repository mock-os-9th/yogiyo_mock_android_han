package com.example.yogiyo_project.src.selectedmenu.models;

import com.google.gson.annotations.SerializedName;

public class AddMenuBody {
    @SerializedName("count")
    private int count;

    public AddMenuBody(int count) {
        this.count = count;
    }
}
