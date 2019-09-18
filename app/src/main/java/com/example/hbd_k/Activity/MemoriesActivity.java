package com.example.hbd_k.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hbd_k.Adapter.Adapter_Memories;
import com.example.hbd_k.R;

public class MemoriesActivity extends AppCompatActivity {

    RecyclerView recyclerMemories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories);


        recyclerMemories = findViewById(R.id.recyclerMemories);

        Adapter_Memories adt = new Adapter_Memories(MemoriesActivity.this);
        recyclerMemories.setFocusable(false);
        recyclerMemories.setNestedScrollingEnabled(false);
        @SuppressLint("WrongConstant") RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MemoriesActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerMemories.setLayoutManager(mLayoutManager);
        recyclerMemories.setAdapter(adt);

    }
}
