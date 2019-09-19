package com.example.hbd_k.Adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hbd_k.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.hbd_k.Activity.MemoriesActivity.container;
import static com.example.hbd_k.Activity.MemoriesActivity.expanded_image;
import static com.example.hbd_k.Activity.MemoriesActivity.recyclerMemories;

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

    private Animator currentAnimator;

    // The system "short" animation time duration, in milliseconds. This
    // duration is ideal for subtle animations or animations that occur
    // very frequently.
    private int shortAnimationDuration;

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
                /*Intent i = new Intent(context, LevelCompleteActivity.class);
                context.startActivity(i);*/

                zoomImageFromThumb(holder.imgRight, imagesRight[position]);
            }
        });

        holder.imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(context, LevelCompleteActivity.class);
                context.startActivity(i);*/

                zoomImageFromThumb(holder.imgLeft, imagesLeft[position]);
            }
        });

        shortAnimationDuration = context.getResources().getInteger(
                android.R.integer.config_shortAnimTime);

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

    private void zoomImageFromThumb(final View thumbView, int imageResId) {
        // If there's an animation in progress, cancel it
        // immediately and proceed with this one.
        if (currentAnimator != null) {
            currentAnimator.cancel();
        }

        // Load the high-resolution "zoomed-in" image.
       /* final ImageView expandedImageView = (ImageView) findViewById(
                R.id.expanded_image);*/
        expanded_image.setImageResource(imageResId);

        // Calculate the starting and ending bounds for the zoomed-in image.
        // This step involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();


        thumbView.getGlobalVisibleRect(startBounds);
        container.getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {

            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {

            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        thumbView.setAlpha(0f);
        expanded_image.setVisibility(View.VISIBLE);
        recyclerMemories.setAlpha(0.8f);

        expanded_image.setPivotX(0f);
        expanded_image.setPivotY(0f);

        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(expanded_image, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expanded_image, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expanded_image, View.SCALE_X,
                        startScale, 1f))
                .with(ObjectAnimator.ofFloat(expanded_image,
                        View.SCALE_Y, startScale, 1f));
        set.setDuration(shortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                currentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                currentAnimator = null;
            }
        });
        set.start();
        currentAnimator = set;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;
        expanded_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentAnimator != null) {
                    currentAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator
                        .ofFloat(expanded_image, View.X, startBounds.left))
                        .with(ObjectAnimator
                                .ofFloat(expanded_image,
                                        View.Y, startBounds.top))
                        .with(ObjectAnimator
                                .ofFloat(expanded_image,
                                        View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator
                                .ofFloat(expanded_image,
                                        View.SCALE_Y, startScaleFinal));
                set.setDuration(shortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        thumbView.setAlpha(1f);
                        expanded_image.setVisibility(View.GONE);
                        recyclerMemories.setAlpha(1f);
                        currentAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        thumbView.setAlpha(1f);
                        expanded_image.setVisibility(View.GONE);
                        recyclerMemories.setAlpha(1f);
                        currentAnimator = null;
                    }
                });
                set.start();
                currentAnimator = set;
            }
        });
    }


}
