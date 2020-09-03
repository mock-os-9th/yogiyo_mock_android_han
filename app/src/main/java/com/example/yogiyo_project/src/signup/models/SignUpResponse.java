package com.example.yogiyo_project.src.signup.models;

import com.google.gson.annotations.SerializedName;

public class SignUpResponse {
    @SerializedName("code")  //서버에서 보내준 변수명이랑 맞추는 것
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
