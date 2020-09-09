package com.example.yogiyo_project.src.selectedStore.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SelectStoreResponse {
    public class SelectStoreResult{
        public String storeName;  //가게 이름
        public int storeIdx;  //가게 번호
        public String isDiscount; //할인 종류 및 여부
        public String deliveryTime; //배달 시간
        public String minimumCharge; //최소 주문 비용
        public double totalScore; //평점
        public int wishCnt; //찜수
        public int menuCnt; //메뉴 수
        public int reviewCnt; //리뷰수
        public String isWished; //내가 찜했는지
        public String deliveryCharge; //배달비
    }
    @SerializedName("result")
    public ArrayList<SelectStoreResult> selectedStoreInfo;
}
