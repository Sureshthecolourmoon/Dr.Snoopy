package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drsnoopy.R;

public class PetPopupActivity extends AppCompatActivity {
    Button petregister_button_success_popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_popup);

    }
}