package com.example.hbd_k.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.hbd_k.Adapter.AdapterHuntList;
import com.example.hbd_k.R;
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


    int color_list[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treasure_hunt);
        ButterKnife.bind(this);


        color_list=new int[10];
        color_list[0] = Color.BLACK;
        color_list[1] = Color.BLUE;
        color_list[2] = Color.CYAN;
        color_list[3] = Color.DKGRAY;
        color_list[4] = Color.GRAY;
        color_list[5] = Color.GREEN;
        color_list[6] = Color.LTGRAY;
        color_list[7] = Color.MAGENTA;
        color_list[8] = Color.RED;
        color_list[9] = Color.TRANSPARENT;

        AdapterHuntList adapter = new AdapterHuntList(getApplicationContext());
        viewPagerHunt.setAdapter(adapter);
        viewPagerHunt.setCurrentItem(0);
        wormDotsIndicator.setViewPager(viewPagerHunt);


        viewPagerHunt.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                // Check if this is the page you want.
                linearBgColor.setBackgroundColor(color_list[position]);

            }
        });
    }
}
