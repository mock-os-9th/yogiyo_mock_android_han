package com.example.yogiyo_project.src.selectedStore.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EachCategoryMenuResponse {
    public class EachCategoryMenuResult{
        public int menuIdx;
        public String menuName;
        public String contents;
        public int price;
        public String photoUrl;
    }
    @SerializedName("result")
    public ArrayList<EachCategoryMenuResult> eachCategoryMenuResult;
}
