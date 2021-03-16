package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.drsnoopy.R;

public class Register extends AppCompatActivity {
    Button register_button;
    TextView login;
    ImageView change_backarrow_id_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        change_backarrow_id_register = findViewById(R.id.change_backarrow_id_register);
        change_backarrow_id_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        register_button = findViewById(R.id.register_button);
        login = findViewById(R.id.login);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, RegistrationfinalActivity.class);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, LoginActivity.class);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                startActivity(intent);
            }
        });
    }


}