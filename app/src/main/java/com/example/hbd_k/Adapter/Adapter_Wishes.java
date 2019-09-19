package com.example.hbd_k.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hbd_k.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_Wishes extends RecyclerView.Adapter<Adapter_Wishes.WishisHolder> {

    Context context;

    ArrayList<String> arrayList = new ArrayList<>();
    int[] name;
    int[] wish;
    int[] images;

    public Adapter_Wishes(Context context, int[] name, int[] wish, int[] images) {
        this.context = context;
        this.name = name;
        this.wish = wish;
        this.images = images;
    }

    @Override
    public WishisHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_wish_list, parent, false);
        return new WishisHolder(view);
    }

    @Override
    public void onBindViewHolder(final WishisHolder holder, final int position) {

        holder.txtEmpName.setText(name[position]);
        holder.txtEmpWish.setText(wish[position]);
        holder.imgEmp.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public static class WishisHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgEmp)
        CircleImageView imgEmp;
        @BindView(R.id.txtEmpName)
        TextView txtEmpName;
        @BindView(R.id.txtEmpWish)
        TextView txtEmpWish;


        public WishisHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
