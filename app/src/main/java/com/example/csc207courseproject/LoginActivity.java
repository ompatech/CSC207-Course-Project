package com.example.csc207courseproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.csc207courseproject.databinding.ActivityLoginBinding;
import com.example.csc207courseproject.interface_adapter.login.LoginController;

import java.beans.PropertyChangeEvent;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private static LoginController loginController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final MainBuilder mainBuilder = new MainBuilder();
        mainBuilder.addLoginUseCase();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginController.execute(LoginActivity.this);
            }
        });
    }

    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "loginsuccess": Toast.makeText(this, "Login successful!",
                    Toast.LENGTH_SHORT).show(); break;
            case "loginfail": Toast.makeText(this, "Login failed. Try again.",
                    Toast.LENGTH_SHORT).show(); break;
        }
    }


    public static void setLoginController(LoginController loginController) {
        LoginActivity.loginController = loginController;
    }
}
