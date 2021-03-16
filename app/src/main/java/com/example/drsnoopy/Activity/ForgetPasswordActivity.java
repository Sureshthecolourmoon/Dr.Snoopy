package com.example.drsnoopy.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.drsnoopy.R;

public class ForgetPasswordActivity extends AppCompatActivity {
    Button button_password;
    ImageView change_backarrow_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        change_backarrow_id = findViewById(R.id.change_backarrow_id);
        change_backarrow_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });


      /*  button_password = findViewById(R.id.button_password);
        button_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this, SelectActivity.class);
                startActivity(intent);
                Toast.makeText(ForgetPasswordActivity.this, "SuccessFully Changed", Toast.LENGTH_SHORT).show();
            }
        });
 */   }
}