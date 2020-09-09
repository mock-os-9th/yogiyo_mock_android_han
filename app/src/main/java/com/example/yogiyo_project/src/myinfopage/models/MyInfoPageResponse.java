package com.example.yogiyo_project.src.myinfopage.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyInfoPageResponse {
    public class MyInfoResult{
        public int userIdx;  //유저번호
        public String userEmail;
        public String password;
        public String nickName;
        public String phoneNum;
    }
    @SerializedName("result")
   public ArrayList<MyInfoResult> myInfoResult;
}
