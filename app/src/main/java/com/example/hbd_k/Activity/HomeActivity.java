package com.example.hbd_k.Activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hbd_k.R;

public class HomeActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        img = findViewById(R.id.image_view_glass1);
     //   ((AnimationDrawable) img.getBackground()).start();

       Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.sequentialanimation);

        img.startAnimation(animFadeIn);

    }
}
