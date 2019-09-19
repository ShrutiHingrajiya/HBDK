package com.example.hbd_k.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.hbd_k.Adapter.AdapterHuntList;
import com.example.hbd_k.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TreasureHuntActivity extends AppCompatActivity {

    @BindView(R.id.worm_dots_indicator)
    WormDotsIndicator wormDotsIndicator;
    @BindView(R.id.view_pager_hunt)
    ViewPager viewPagerHunt;
    @BindView(R.id.linear_bg_color)
    LinearLayout linearBgColor;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Treasure");

    boolean first = true;
    int color_list[];
    AdapterHuntList adapter;


    int latest_clue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treasure_hunt);
        ButterKnife.bind(this);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.e("FROM DB__", "FromDB__");
                int updatedIndex = Integer.parseInt(dataSnapshot.child("id").getValue().toString());
                latest_clue=updatedIndex;

                changeLevel(updatedIndex);

            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.e("Cancled", "******");
            }
        });


        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                Log.e("Changed", "******");
                Log.e("DataSnapshot", dataSnapshot.child("id").getValue() + "__");
                int updatedIndex = Integer.parseInt(dataSnapshot.child("id").getValue().toString());
                AdapterHuntList adapter = new AdapterHuntList(getApplicationContext(), updatedIndex);
                viewPagerHunt.setAdapter(adapter);

                wormDotsIndicator.setViewPager(viewPagerHunt);
                viewPagerHunt.setCurrentItem(updatedIndex-1);
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.e("Cancled", "******");
            }
        });*/


        color_list = new int[9];
        color_list[0] = R.color.slider_color_1;
        color_list[1] = R.color.slider_color_2;
        color_list[2] = R.color.slider_color_3;
        color_list[3] = R.color.slider_color_1;
        color_list[4] = R.color.slider_color_2;
        color_list[5] = R.color.slider_color_3;
        color_list[6] = R.color.slider_color_1;
        color_list[7] = R.color.slider_color_2;
        color_list[8] = R.color.slider_color_3;


        String[] dummylist = new String[1];
        adapter = new AdapterHuntList(getApplicationContext(), dummylist);
        viewPagerHunt.setAdapter(adapter);

        wormDotsIndicator.setViewPager(viewPagerHunt);
        viewPagerHunt.setCurrentItem(0);
        linearBgColor.setBackgroundResource(color_list[0]);

        viewPagerHunt.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int position) {
                linearBgColor.setBackgroundResource(color_list[position]);

            }
        });
    }


    public void changeLevel(int level) {

        if (first) {
            first = false;
            return;
        } else {


            callLevelCompleteDialog(level);
          //  Log.e("Changed", "******");
        }

        String[] dummylist = new String[level];

      //  Log.e("DummyListSize", String.valueOf(dummylist.length) + "___");
        adapter = new AdapterHuntList(getApplicationContext(), dummylist);
        wormDotsIndicator.setViewPager(viewPagerHunt);
        viewPagerHunt.setAdapter(adapter);
       // Log.e("level", "******" + level);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPagerHunt.setCurrentItem(level - 1, true);
            }
        }, 500);
        //   viewPagerHunt.setCurrentItem(level-1);
    }

    public void callLevelCompleteDialog(int levelcount) {


        Dialog dialog = new Dialog(this, R.style.mytheme);
        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimationOutUpInUp;
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_level_complete);

        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setGravity(Gravity.TOP);

        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);


        TextView txtNextLevel = dialog.findViewById(R.id.txtNextLevel);
        TextView textlevelNo = dialog.findViewById(R.id.txtLevelNo);
        TextView txtLevelOutOf = dialog.findViewById(R.id.txtLevelOutOf);
        ProgressBar progressBar = dialog.findViewById(R.id.progressBar);

        txtLevelOutOf.setText(levelcount + "/9");
        progressBar.setProgress(levelcount);
        textlevelNo.setText("Level " + levelcount + " ");
        txtNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }
}
