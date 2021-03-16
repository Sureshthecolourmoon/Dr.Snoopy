package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drsnoopy.R;

public class LoginActivity extends AppCompatActivity {
    TextView register, forgetpassword;
    Button button;
    ImageView change_backarrow_id_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.login_activity);
        forgetpassword = findViewById(R.id.forgetpassword);
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PhoneVerificationActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                startActivity(intent);
            }
        });

        change_backarrow_id_login = findViewById(R.id.change_backarrow_id_login);
        change_backarrow_id_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                startActivity(intent);
            }
        });

    }
}