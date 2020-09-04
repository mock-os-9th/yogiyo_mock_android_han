package com.example.yogiyo_project.src.addressoption.interfaces;

import com.example.yogiyo_project.src.login.models.LogInResponse;

public interface AddressMainActivityView {
    void validateSuccess(String text);

    void validateFailure(String message);

    void adressSuccess(String message);
}
