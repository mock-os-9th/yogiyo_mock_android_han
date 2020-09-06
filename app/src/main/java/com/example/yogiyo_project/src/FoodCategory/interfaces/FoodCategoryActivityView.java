package com.example.yogiyo_project.src.FoodCategory.interfaces;

public interface FoodCategoryActivityView {
    void validateSuccess(String text);

    void validateFailure(String message);

    void getStoreListSuccess(String message);
}
