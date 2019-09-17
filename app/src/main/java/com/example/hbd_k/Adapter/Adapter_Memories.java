package com.example.hbd_k.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hbd_k.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Memories extends RecyclerView.Adapter<Adapter_Memories.FeesViewHolder> {

    Context context;
    List<String> arrayList = new ArrayList<>();
    int[] images = {R.drawable.splash1, R.drawable.splash2, R.drawable.card1,
            R.drawable.card2, R.drawable.card3};

    public Adapter_Memories(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FeesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.raw_memories, parent, false);
        return new FeesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeesViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class FeesViewHolder extends RecyclerView.ViewHolder {
        public FeesViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }


}
