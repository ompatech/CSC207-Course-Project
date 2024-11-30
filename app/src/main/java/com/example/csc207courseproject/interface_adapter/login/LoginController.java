package com.example.csc207courseproject.interface_adapter.login;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.example.csc207courseproject.use_case.login.LoginInputBoundary;

/**
 * Controller for the Login Use Case.
 */
public class LoginController {

    private final LoginInputBoundary loginInteractor;

    public LoginController(LoginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    public void execute(AppCompatActivity activity) {
        loginInteractor.execute(activity);
    }

}