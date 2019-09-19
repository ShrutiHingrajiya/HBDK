package com.example.hbd_k.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hbd_k.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;

public class Adapter_Wishes extends RecyclerView.Adapter<Adapter_Wishes.WishisHolder> {

    Context context;

    ArrayList<String> arrayList=new ArrayList<>();


    public Adapter_Wishes(Context context) {
        this.context = context;
        arrayList.add("hiiii");
        arrayList.add("hiiii");
        arrayList.add("hiiii");
    }

    @Override
    public WishisHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_memories, parent, false);
        return new WishisHolder(view);
    }

    @Override
    public void onBindViewHolder(final WishisHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class WishisHolder extends RecyclerView.ViewHolder {



        public WishisHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
