package com.example.hbd_k.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hbd_k.R;

import butterknife.ButterKnife;

public class WishishActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishish);
        ButterKnife.bind(this);

    }
}
