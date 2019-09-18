package com.example.hbd_k.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

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


    int color_list[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treasure_hunt);
        ButterKnife.bind(this);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                Log.e("Changed", "******");
                Log.e("DataSnapshot", dataSnapshot.child("id").getValue() + "__");
                int updatedIndex = Integer.parseInt(dataSnapshot.child("id").getValue().toString());
                AdapterHuntList adapter = new AdapterHuntList(getApplicationContext(), updatedIndex);
                viewPagerHunt.setAdapter(adapter);
                viewPagerHunt.setCurrentItem(updatedIndex - 1);
                wormDotsIndicator.setViewPager(viewPagerHunt);
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.e("Cancled", "******");
            }
        });
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

        AdapterHuntList adapter = new AdapterHuntList(getApplicationContext(), 1);
        viewPagerHunt.setAdapter(adapter);
        viewPagerHunt.setCurrentItem(0);
        wormDotsIndicator.setViewPager(viewPagerHunt);
        linearBgColor.setBackgroundResource(color_list[0]);

        viewPagerHunt.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
                Log.e("Possition", String.valueOf("p")+"__");
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int position) {
                // Check if this is the page you want.
                Log.e("Possition1", String.valueOf(position)+"__");
                linearBgColor.setBackgroundResource(color_list[position]);

            }
        });
    }
}
