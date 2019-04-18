package com.loadindicators.adrianlesniak.library;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

public class AnimatedLoaderDrawable extends AnimationDrawable {

    private boolean loopInReverse;

    private Bitmap[] spriteArray;

    private boolean reversing = false;

    AnimatedLoaderDrawable(Resources resources,
                           Slicer slicer,
                           @DrawableRes int loaderSrc,
                           int frameDuration,
                           boolean loopInReverse) {

        Bitmap spriteBitmap = getBitmapFromDrawable(loaderSrc, resources);
        spriteArray = slicer.slice(spriteBitmap);

        for (Bitmap bitmap : spriteArray) {
            this.addFrame(new BitmapDrawable(resources, bitmap), frameDuration);
        }

        this.loopInReverse = loopInReverse;
    }

    @Override
    public boolean selectDrawable(int idx) {

        if (!loopInReverse) {
            return super.selectDrawable(idx);
        } else {

            if (reversing) {

                int newIdx = spriteArray.length - idx - 1;
                if (newIdx == 0) {
                    reversing = false;
                }
                return super.selectDrawable(newIdx);

            } else {

                if (idx == spriteArray.length - 1) {
                    reversing = true;
                }

                return super.selectDrawable(idx);
            }
        }
    }

    @NonNull
    private Bitmap getBitmapFromDrawable(@DrawableRes int drawableResId, Resources resources) {

        Bitmap bitmap = BitmapFactory.decodeResource(resources, drawableResId);

        if (bitmap == null) {
            throw new IllegalArgumentException("Could not decode drawable from given resource id. Ensure drawable resources is passed.");
        }

        return bitmap;
    }
}
