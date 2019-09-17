package com.example.hbd_k.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hbd_k.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Memories extends RecyclerView.Adapter<Adapter_Memories.FeesViewHolder> {

    Context context;
    List<String> arrayList = new ArrayList<>();
    int[] imagesRight = {R.drawable.m1, R.drawable.m3,
            R.drawable.m5,
            R.drawable.m7, R.drawable.m9,
            R.drawable.m11};

    int[] imagesLeft = {
            R.drawable.m2, R.drawable.m4, R.drawable.m6, R.drawable.m8, R.drawable.m10, R.drawable.m12
    };

  //  String[] textRight ={R.string}

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

        holder.imgRight.setImageResource(imagesRight[position]);
        holder.imgLeft.setImageResource(imagesLeft[position]);

    }

    @Override
    public int getItemCount() {
        return imagesLeft.length;
    }

    public class FeesViewHolder extends RecyclerView.ViewHolder {

        ImageView imgRight, imgLeft;

        public FeesViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLeft = itemView.findViewById(R.id.imgLeft);
            imgRight = itemView.findViewById(R.id.imgRight);
        }
    }


}
