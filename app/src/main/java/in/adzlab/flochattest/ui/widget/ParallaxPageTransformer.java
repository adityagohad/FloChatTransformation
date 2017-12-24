package in.adzlab.flochattest.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import in.adzlab.flochattest.R;

/**
 * Created by adityagohad on 23/12/17.
 */

public class ParallaxPageTransformer implements ViewPager.PageTransformer {
    int pageWidth, pageHeight;

    public void transformPage(View view, float position) {
        pageWidth = view.getWidth();
        pageHeight = view.getHeight();

        switch (view.getId()) {
            case R.id.last:
                finalTransformation(view, position);
                break;
            case R.id.rotation:
                rotationTransformation(view, position);
                break;
            case R.id.parallax:
                parallaxTransformations(view, position);
                break;
        }
    }

    private void parallaxTransformations(View view, float position) {
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1) { // [-1,1]
            ImageView blueBall = (ImageView) view.findViewById(R.id.parallax_blue_ball);
            ImageView redBall = (ImageView) view.findViewById(R.id.parallax_red_ball);
            ImageView hiddenBall = (ImageView) view.findViewById(R.id.parallax_hidden_ball);
            LinearLayout block = (LinearLayout) view.findViewById(R.id.parallax_block);
            blueBall.setTranslationX((float) (pageWidth * position * 1.5));
            redBall.setTranslationX((float) (pageWidth * position * 0.7));
            block.setTranslationX((float) (pageWidth * position * 1.2));
            hiddenBall.setTranslationX((float) (-1 * pageWidth * position * 0.2));


        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }
    }

    private void rotationTransformation(View view, float position) {
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1) { // [-1,1]
            LinearLayout sun = (LinearLayout) view.findViewById(R.id.rotation_sun);
            LinearLayout moon = (LinearLayout) view.findViewById(R.id.rotation_moon);
            sun.setRotation(position*180);
            moon.setRotation(position*180);


        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }
    }

    private void finalTransformation(View view, float position) {
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1) { // [-1,1]
            ImageView rotation_0 = (ImageView) view.findViewById(R.id.rotation_0);
            ImageView rotation_2 = (ImageView) view.findViewById(R.id.rotation_2);
            ImageView rotation_4 = (ImageView) view.findViewById(R.id.rotation_4);
            ImageView rotation_6 = (ImageView) view.findViewById(R.id.rotation_6);
            ImageView rotation_8 = (ImageView) view.findViewById(R.id.rotation_8);
            ImageView rotation_10 = (ImageView) view.findViewById(R.id.rotation_10);

            rotation_10.setTranslationX((float) 1.6 * position * pageWidth);
            rotation_8.setTranslationX((float) 0.6 * position * pageWidth);
            rotation_6.setTranslationX((float) 1.2 * position * pageWidth);
            //rotation_4.setTranslationX((float) 0.5 * position * pageWidth);
            rotation_2.setTranslationX((float) 0.8 * position * pageWidth);
            //rotation_0.setTranslationX((float) 1.2 * position * pageWidth);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }
    }
}
