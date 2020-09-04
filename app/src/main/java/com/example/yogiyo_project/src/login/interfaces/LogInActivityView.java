package com.example.yogiyo_project.src.login.interfaces;

import com.example.yogiyo_project.src.login.models.LogInResponse;

public interface LogInActivityView {
    void validateSuccess(String text);

    void validateFailure(String message);

    void logInSuccess(String message, LogInResponse.LogInResult logInResult);
}
