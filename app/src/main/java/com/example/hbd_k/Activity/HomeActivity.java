package com.example.hbd_k.Activity;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.easyandroidanimations.library.BounceAnimation;
import com.example.hbd_k.R;

public class HomeActivity extends AppCompatActivity {

    ImageView img, img2, img3;
    Handler handler;
    Animation animFadeIn;
    boolean isBottom = true;
    RelativeLayout lnMain;
    LinearLayout ln1, ln2, ln3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        img = findViewById(R.id.image_view_1);
        img2 = findViewById(R.id.image_view_2);
        img3 = findViewById(R.id.image_view_3);
        lnMain = findViewById(R.id.lnMain);
        ln1 = findViewById(R.id.ln1);
        ln2 = findViewById(R.id.ln2);
        ln3 = findViewById(R.id.ln3);


        new BounceAnimation(ln1)
                .setBounceDistance(500)
                .setNumOfBounces(15)
                .setDuration(50000)
                .animate();

        new BounceAnimation(ln2)
                .setBounceDistance(400)
                .setNumOfBounces(15)
                .setDuration(40000)
                .animate();

        new BounceAnimation(ln3)
                .setBounceDistance(600)
                .setNumOfBounces(15)
                .setDuration(60000)
                .animate();
    }

    public void SlideToAbove() {
        Animation slide = null;
        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -5.0f);

        slide.setDuration(4000);
        slide.setFillAfter(true);
        slide.setFillEnabled(true);
        lnMain.startAnimation(slide);

        slide.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                lnMain.clearAnimation();

                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        lnMain.getWidth(), lnMain.getHeight());
                // lp.setMargins(0, 0, 0, 0);
                lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                lnMain.setLayoutParams(lp);
                SlideToDown();

            }

        });

    }

    public void SlideToDown() {
        Animation slide = null;
        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 5.2f);

        slide.setDuration(4000);
        slide.setFillAfter(true);
        slide.setFillEnabled(true);
        img.startAnimation(slide);

        slide.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                img.clearAnimation();

                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        lnMain.getWidth(), lnMain.getHeight());
                lp.setMargins(0, lnMain.getWidth(), 0, 0);
                lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                lnMain.setLayoutParams(lp);
                SlideToAbove();
            }

        });
    }

    private boolean isPanelShown() {
        return img.getVisibility() == View.VISIBLE;
    }


    private void startBottomToTopAnimation(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.baunce));
    }

    public class PhotoDecodeRunnable implements Runnable {

        @Override
        public void run() {
            /*
             * Code you want to run on the thread goes here
             */

        }

    }

    private static ObjectAnimator createBottomUpAnimation(View view,
                                                          AnimatorListenerAdapter listener, float distance) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", -distance);
//        animator.setDuration(???)
        animator.removeAllListeners();
        if (listener != null) {
            animator.addListener(listener);
        }
        return animator;
    }

    public static ObjectAnimator createTopDownAnimation(View view, AnimatorListenerAdapter
            listener,
                                                        float distance) {
        view.setTranslationY(-distance);
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", 0);
        animator.removeAllListeners();
        if (listener != null) {
            animator.addListener(listener);
        }
        return animator;

    }
}
