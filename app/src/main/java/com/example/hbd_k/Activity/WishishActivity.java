package com.example.hbd_k.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hbd_k.Adapter.Adapter_Wishes;
import com.example.hbd_k.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WishishActivity extends AppCompatActivity {


    @BindView(R.id.recyclerwish_1)
    RecyclerView recyclerwish1;
    @BindView(R.id.recyclerwish_2)
    RecyclerView recyclerwish2;
    int[] nameLeft ={R.string.wish1,R.string.wish3,R.string.wish5,R.string.wish7,R.string.wish9,R.string.wish11,R.string.wish13,R.string.wish15,R.string.wish17,R.string.wish19,R.string.wish21,R.string.wish23,R.string.wish25,R.string.wish27};
    int[] nameRight ={R.string.wish2,R.string.wish4,R.string.wish6,R.string.wish8,R.string.wish10,R.string.wish12,R.string.wish14,R.string.wish16,R.string.wish18,R.string.wish20,R.string.wish22,R.string.wish24,R.string.wish26};

    int[] wishLeft ={R.string.wishD1,R.string.wishD3,R.string.wishD5,R.string.wishD7,R.string.wishD9,R.string.wishD11,R.string.wishD13,R.string.wishD15,R.string.wishD17,R.string.wishD19,R.string.wishD21,R.string.wishD23,R.string.wishD25,R.string.wishD27};
    int[] wishRight ={R.string.wishD2,R.string.wishD4,R.string.wishD6,R.string.wishD8,R.string.wishD10,R.string.wishD12,R.string.wishD14,R.string.wishD16,R.string.wishD18,R.string.wishD20,R.string.wishD22,R.string.wishD24,R.string.wishD26};

    int[] imagesLeft={R.drawable.anjali,R.drawable.hemins,R.drawable.rajal,R.drawable.abhilav,R.drawable.shruti,R.drawable.nidhi,R.drawable.kena,R.drawable.ashish,R.drawable.komal,R.drawable.parshva,R.drawable.satyam,R.drawable.tanuja,R.drawable.kanubhai,R.drawable.mehul};
    int[] imagesRight={R.drawable.pooja,R.drawable.yogesh,R.drawable.shubhada,R.drawable.vaishali,R.drawable.nikita,R.drawable.dhrumil,R.drawable.pratik,R.drawable.jd,R.drawable.himanshu,R.drawable.kishan,R.drawable.shikha,R.drawable.aarshan,R.drawable.prasoon};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishish);
        ButterKnife.bind(this);


        Adapter_Wishes adt = new Adapter_Wishes(WishishActivity.this,nameLeft,wishLeft,imagesLeft);
        recyclerwish1.setFocusable(false);
        recyclerwish1.setNestedScrollingEnabled(false);
        @SuppressLint("WrongConstant") RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(WishishActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerwish1.setLayoutManager(mLayoutManager);
        recyclerwish1.setAdapter(adt);

        Adapter_Wishes adt1 = new Adapter_Wishes(WishishActivity.this,nameRight,wishRight,imagesRight);
        recyclerwish2.setFocusable(false);
        recyclerwish2.setNestedScrollingEnabled(false);
        @SuppressLint("WrongConstant") RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(WishishActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerwish2.setLayoutManager(mLayoutManager1);
        recyclerwish2.setAdapter(adt1);

    }

    @Override
    public void onBackPressed() {
        this.finish();
    }
}
