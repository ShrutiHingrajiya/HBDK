package com.example.hbd_k.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.hbd_k.R;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imgSplash=findViewById(R.id.imgSplash);

      //  Glide.with(SplashActivity.this).load(R.drawable.splash2).asBitmap().override(1080, 600).into(imgSplash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(i);
                finish();

            }
        }, SPLASH_TIME_OUT);

    }
}
