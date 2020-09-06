package com.example.yogiyo_project.src.FoodCategory.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FoodCategory1Response {
    public class ResultAll{
        public String KindOfStore;  //플러스가게 / 레드위크 가게/ 일반 요기요 등록 가게
        public int storeIdx; // 가게 카테고리 인덱스
        public String storeImg;  //가게 이미지 url
        public String storeName; //가게 이름
        public String deliveryTime; //배달시간
        public String cesco;  //세스코 여부 N or Y
        public int reviews;  //리뷰 개수
        public int masterComments; //사장님 댓글 개수
        public int star;   //별점
        public String isNew; // 신규 여부   "NEW"
        public String isBest;  // "Y" 우수 여부
        public int discount;   //할인율
        @SerializedName("redweek")
        public int redweek_discount;  //레드위크 할인
        @SerializedName("menu")
        public String signaturemenu;
        public String isOpen; //"Y" 오픈 여부
    }
    @SerializedName("result")
    public ArrayList<ResultAll> resultAll;

}
