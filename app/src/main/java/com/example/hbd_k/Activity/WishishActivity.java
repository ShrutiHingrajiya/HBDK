package com.example.hbd_k.Activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.etsy.android.grid.StaggeredGridView;
import com.example.hbd_k.Adapter.Adapter_Wishes;
import com.example.hbd_k.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WishishActivity extends AppCompatActivity {

    @BindView(R.id.expandedImage)
    ImageView expandedImage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.grid_view)
    StaggeredGridView gridView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishish);
        ButterKnife.bind(this);


        Adapter_Wishes adapter_wishes = new Adapter_Wishes(this);



      //  gridView.setAdapter(adapter_wishes);

    }
}
