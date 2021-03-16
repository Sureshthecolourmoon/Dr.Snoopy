package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drsnoopy.R;

public class SuccessRegistrationActivity extends AppCompatActivity {
    Button petsuccess_button_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_registration);
        petsuccess_button_success = findViewById(R.id.petsuccess_button_success);
        petsuccess_button_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccessRegistrationActivity.this, LoginActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                startActivity(intent);
            }
        });
    }
}