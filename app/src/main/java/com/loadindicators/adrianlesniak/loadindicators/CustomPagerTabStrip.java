package com.loadindicators.adrianlesniak.loadindicators;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerTabStrip;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Adrian on 22-Nov-14.
 */
public class CustomPagerTabStrip extends PagerTabStrip {
    public CustomPagerTabStrip(Context context) {
        super(context);
        init();
    }

    public CustomPagerTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        changeTypeface();
    }

    private void changeTypeface() {

        for (int i = 0; i < getChildCount(); ++i) {
            View nextChild = getChildAt(i);
            if (nextChild instanceof TextView) {
                TextView textViewToConvert = (TextView) nextChild;
                textViewToConvert.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/chunkfive.ttf"));
            }
        }

    }
}
