package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drsnoopy.R;

public class Success_petregistrationpopup_Activity extends AppCompatActivity {
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_petregistrationpopup_);
        ok = findViewById(R.id.successok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Success_petregistrationpopup_Activity.this, PetregistedOtpActivity.class);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                startActivity(intent);
            }
        });
    }
}