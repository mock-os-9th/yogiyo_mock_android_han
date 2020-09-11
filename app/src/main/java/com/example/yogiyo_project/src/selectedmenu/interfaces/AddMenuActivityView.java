package com.example.yogiyo_project.src.selectedmenu.interfaces;

public interface AddMenuActivityView {
    void validateFailure(String message);

    void AddMenuSuccess(String message);

    void CartInquireSuccess(String message);

    void MenuDetailSuccess(String menuName, String contents, int price );
}
