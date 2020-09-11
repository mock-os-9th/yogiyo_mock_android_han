package com.example.yogiyo_project.src.selectedmenu.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MenuDetailResponse {
    public class MenuDetailResult{

        public int menuIdx;
        public String contents;
        public String photoUrl;
        @SerializedName("menuName")
        public String selectedMenuName;
        public int price;
    }
    @SerializedName("result")
    public ArrayList<ArrayList<MenuDetailResult>> menuDetailResult;
}
