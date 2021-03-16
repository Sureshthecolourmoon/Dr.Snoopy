package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drsnoopy.R;

public class AppointmentSuccessActivity extends AppCompatActivity {
    TextView text_select_apontment;
    ImageView change_backarrow_id_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_success);

        change_backarrow_id_success = findViewById(R.id.change_backarrow_id_success);
        change_backarrow_id_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        text_select_apontment = findViewById(R.id.text_select_apontment);
        text_select_apontment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppointmentSuccessActivity.this, SelectActivity.class);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                startActivity(intent);
            }
        });

    }
}