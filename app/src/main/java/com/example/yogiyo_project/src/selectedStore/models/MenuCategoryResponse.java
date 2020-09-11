package com.example.yogiyo_project.src.selectedStore.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MenuCategoryResponse {
    public class MenuCategoryResult{
        public int menuCategoryIdx;  //카테고리 번호
        public String categoryName;  //카테고리 이름
        public String isAlcohol;
    }
    @SerializedName("result")
    public ArrayList<MenuCategoryResult> menuCategoryResult;
}
