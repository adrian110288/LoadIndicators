package com.loadindicators.adrianlesniak.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by Adrian on 22-Nov-14.
 */
public class LoaderDrawable extends AnimationDrawable {

    public LoaderDrawable(Context context, Bitmap[] tileArray, int delay) {

        for(int tile = 0; tile<tileArray.length; tile++) {
            addFrame(new BitmapDrawable(context.getResources(), tileArray[tile]), delay);
        }

        setOneShot(false);
    }


}
