package com.example.yogiyo_project.src.login.models;

import com.google.gson.annotations.SerializedName;

public class MyInfoResponse {
    public class MyResult{
         public int userIdx;
         public String nickName;
         public String isMaster;
         public int couponCnt;
         public int reviewCnt;
         public int leftPoint;
         public String levelName;
    }
    @SerializedName("result")
    public MyResult myresult;
}
