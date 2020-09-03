package com.example.yogiyo_project.src.signup.models;

import com.google.gson.annotations.SerializedName;

public class SignUpBody {
    @SerializedName("method")
    private String method;

    @SerializedName("userEmail")
    private String userEmail;

    @SerializedName("password")
    private String password;

    @SerializedName("checkPassword")
    private String checkPassword;

    @SerializedName("nickName")
    private String nickName;

    @SerializedName("phoneNum")
    private String phoneNum;

    public SignUpBody(String method, String userEmail, String password, String checkPassword, String nickName, String phoneNum) {
        this.method = method;
        this.userEmail = userEmail;
        this.password = password;
        this.checkPassword = checkPassword;
        this.nickName = nickName;
        this.phoneNum = phoneNum;

    }
}
