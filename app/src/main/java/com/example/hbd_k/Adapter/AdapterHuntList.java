package com.example.hbd_k.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.example.hbd_k.R;

public class AdapterHuntList extends PagerAdapter {
    public Context context;

    int length;
    private String[] totallength;


    private int[] clueslist = new int[]{
            R.string.tample_hint,
            R.string.stickey_note_hint,
            R.string.moniter_hint,
            R.string.projector_hint,
            R.string.coofie_hint,
            R.string.broadband_hint,
            R.string.register_hint,
            R.string.frize_hint,
            R.string.Chair_hint,
    };

    private int[] color_list = new int[9];


    LayoutInflater mLayoutInflater;
    TextView textHint;
    LinearLayout liText, liImage;

    public AdapterHuntList(Context context, String[] dummylist) {
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        totallength = dummylist;

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
    }

    @Override
    public int getCount() {
        return totallength.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.raw_view_pager_productdetails, container, false);


        TextView textHint = (TextView) itemView.findViewById(R.id.text_hint);
        ImageView imgquote = (ImageView) itemView.findViewById(R.id.image_quote);
        ImageView image_clue = (ImageView) itemView.findViewById(R.id.image_clue);

        LinearLayout liText = (LinearLayout) itemView.findViewById(R.id.liText);
        LinearLayout liImage = (LinearLayout) itemView.findViewById(R.id.liImage);



        imgquote.setColorFilter(ContextCompat.getColor(context, color_list[position]), android.graphics.PorterDuff.Mode.SRC_IN);
        container.addView(itemView);

        if (position == 0) {
            liImage.setVisibility(View.VISIBLE);
            liText.setVisibility(View.GONE);
            image_clue.setImageResource(R.drawable.clue_t);

        } else if (position == clueslist.length - 1) {
            liImage.setVisibility(View.VISIBLE);
            liText.setVisibility(View.GONE);
            image_clue.setImageResource(R.drawable.clue_last);

        } else {
            liImage.setVisibility(View.GONE);
            liText.setVisibility(View.VISIBLE);
            textHint.setText(context.getResources().getString(clueslist[position]));

        }

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}