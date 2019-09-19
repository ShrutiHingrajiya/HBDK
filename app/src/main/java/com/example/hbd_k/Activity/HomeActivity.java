package com.example.hbd_k.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.easyandroidanimations.library.BounceAnimation;
import com.example.hbd_k.R;

public class HomeActivity extends AppCompatActivity {

    ImageView img, img2, img3;
    Handler handler;
    Animation animFadeIn;
    boolean isBottom = true;
    RelativeLayout lnMain;
    LinearLayout ln1, ln2, ln3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home);

        img = findViewById(R.id.image_view_1);
        img2 = findViewById(R.id.image_view_2);
        img3 = findViewById(R.id.image_view_3);
        lnMain = findViewById(R.id.lnMain);

        ln1 = findViewById(R.id.ln1);
        ln2 = findViewById(R.id.ln2);
        ln3 = findViewById(R.id.ln3);


        new BounceAnimation(ln1)
                .setBounceDistance(500)
                .setNumOfBounces(23)
                .setDuration(100000)
                .animate();


        new BounceAnimation(ln2)
                .setBounceDistance(400)
                .setNumOfBounces(23)
                .setDuration(80000)
                .animate();

        new BounceAnimation(ln3)
                .setBounceDistance(600)
                .setNumOfBounces(23)
                .setDuration(120000)
                .animate();

        this.setListeners();

    }

    private void setListeners() {
        ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WishishActivity.class);
                startActivity(i);
            }
        });
        ln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MemoriesActivity.class);
                startActivity(i);
            }
        });
    }

}
