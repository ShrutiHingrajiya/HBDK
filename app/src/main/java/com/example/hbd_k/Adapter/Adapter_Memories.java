package com.example.hbd_k.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hbd_k.Activity.LevelCompleteActivity;
import com.example.hbd_k.Activity.MemoriesActivity;
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

    int[] imagesLeft = {R.drawable.m2, R.drawable.m4, R.drawable.m6, R.drawable.m8, R.drawable.m10, R.drawable.m12};

    int[] textLeft = {R.string.text2, R.string.text4, R.string.text6, R.string.text8, R.string.text10, R.string.text12};
    int[] textRight = {R.string.text1, R.string.text3, R.string.text5, R.string.text7, R.string.text9, R.string.text11};

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

        holder.txtLeft.setText(textLeft[position]);
        holder.txtRight.setText(textRight[position]);

        holder.imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, LevelCompleteActivity.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imagesLeft.length;
    }

    public class FeesViewHolder extends RecyclerView.ViewHolder {

        ImageView imgRight, imgLeft;
        TextView txtLeft, txtRight;

        public FeesViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLeft = itemView.findViewById(R.id.imgLeft);
            imgRight = itemView.findViewById(R.id.imgRight);

            txtLeft = itemView.findViewById(R.id.txtLeft);
            txtRight = itemView.findViewById(R.id.txtRight);
        }
    }
}
