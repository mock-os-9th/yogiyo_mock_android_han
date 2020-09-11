package com.example.yogiyo_project.src.selectedmenu.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CartInquireResponse {
    public class CartInquireResult{
         public int cartIdx;
         public String storeName;
         @SerializedName("menuName")
         public String selectedMenuName;
         public int price;
         public int count;
         public int cartMenuIdx;
         public int menuOptionIdx;
         public String menuOption;
    }
    @SerializedName("result")
    public ArrayList<CartInquireResult> cartInquireResult;
}
