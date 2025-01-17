package com.example.yogiyo_project.src.login.models;

import com.google.gson.annotations.SerializedName;

public class LogInResponse {

    public class LogInResult {
        @SerializedName("jwt")
        private String jwt;

        public String getJwt() {
            return jwt;
        }
    }
    @SerializedName("code")  //서버에서 보내준 변수명랑 맞추는 것
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private LogInResult logInResult;

    public LogInResult getLogInResult() {
        return logInResult;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
