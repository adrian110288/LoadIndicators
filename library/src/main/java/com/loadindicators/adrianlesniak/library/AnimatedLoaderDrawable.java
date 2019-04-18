package com.loadindicators.adrianlesniak.library;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

public class AnimatedLoaderDrawable extends AnimationDrawable {

    AnimatedLoaderDrawable(@DrawableRes int loaderSrc,
                           int frameDuration,
                           Slicer slicer,
                           Resources resources) {

        Bitmap spriteBitmap = getBitmapFromDrawable(loaderSrc, resources);
        Bitmap[] spriteArray = slicer.slice(spriteBitmap);

        for (Bitmap bitmap : spriteArray) {
            this.addFrame(new BitmapDrawable(resources, bitmap), frameDuration);
        }
    }

//    @Override
//    public boolean selectDrawable(int idx) {
//        boolean ret = super.selectDrawable(idx);
//
//        if ((idx != 0) && (idx == getNumberOfFrames() - 1)) {
//            if (!finished) {
//                finished = true;
//                if (animationFinishListener != null) animationFinishListener.onAnimationFinished();
//            }
//        }
//
//        return ret;
//    }

    @NonNull
    private Bitmap getBitmapFromDrawable(@DrawableRes int drawableResId, Resources resources) {

        Bitmap bitmap = BitmapFactory.decodeResource(resources, drawableResId);

        if (bitmap == null) {
            throw new IllegalArgumentException("Could not decode drawable from given resource id. Ensure drawable resources is passed.");
        }

        return bitmap;
    }
}
