package com.example.hbd_k.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hbd_k.Adapter.Adapter_Memories;
import com.example.hbd_k.R;

public class MemoriesActivity extends AppCompatActivity {

    public static RecyclerView recyclerMemories;
    public static ImageView expanded_image;
    public static FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories);


        recyclerMemories = findViewById(R.id.recyclerMemories);
        expanded_image = findViewById(R.id.expanded_image);
        container = findViewById(R.id.container);

        Adapter_Memories adt = new Adapter_Memories(MemoriesActivity.this);
        recyclerMemories.setFocusable(false);
        recyclerMemories.setNestedScrollingEnabled(false);
        @SuppressLint("WrongConstant") RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MemoriesActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerMemories.setLayoutManager(mLayoutManager);
        recyclerMemories.setAdapter(adt);

    }

    @Override
    public void onBackPressed() {
        this.finish();
    }
}
