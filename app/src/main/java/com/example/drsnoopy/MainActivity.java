package com.example.drsnoopy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

   AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                overridePendingTransition(R.anim.enter,R.anim.exit);
                startActivity(intent);
                finish();
            }
        }, 2000);


        ImageView imageView = (ImageView) findViewById(R.id.animlogo);
        imageView.setBackgroundResource(R.drawable.animation);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animationDrawable.start();
    }
}

