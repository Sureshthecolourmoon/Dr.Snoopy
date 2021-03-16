package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drsnoopy.R;

public class SuccessRegisterActivity extends AppCompatActivity {
    Button petregister_button_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);
        petregister_button_success = findViewById(R.id.petregister_button_success);
        petregister_button_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuccessRegisterActivity.this, PetRegistrationActivity.class);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                startActivity(intent);
            }
        });
    }
}