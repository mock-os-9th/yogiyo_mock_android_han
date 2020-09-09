package com.example.yogiyo_project.src.myinfopage.inferfaces;

public interface MyInfoPageActivityView {
    void validateFailure(String message);

    void MyInfoSuccess(String email, String password, String phoneNum, String nickName);
}
