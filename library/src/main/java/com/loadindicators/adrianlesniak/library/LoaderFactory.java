package com.loadindicators.adrianlesniak.library;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;

/**
 * Created by Adrian on 22-Nov-14.
 */
public class LoaderFactory {

    private static final int DEFAULT_DELAY = 50;

    private static Context sContext;
    private static Resources sResources;

    private Bitmap mBitmap;

    public LoaderFactory(Context context) {
        sContext = context;
        sResources = context.getResources();
    }

    public AnimationDrawable getLoader(LoaderType loader) {

        mBitmap = getBitmapFromDrawable(loader);

        return new LoaderDrawable(sContext, getTileArray(loader), DEFAULT_DELAY);
    }

    public AnimationDrawable getLoader(LoaderType loader, String color) {

        mBitmap = changeLoaderColor(getBitmapFromDrawable(loader), color);

        return new LoaderDrawable(sContext, getTileArray(loader), DEFAULT_DELAY);
    }

    public AnimationDrawable getLoader(LoaderType loader, int delay) {

        mBitmap = getBitmapFromDrawable(loader);

        return new LoaderDrawable(sContext, getTileArray(loader), delay);
    }

    public AnimationDrawable getLoader(LoaderType loader, String color, int delay) {

        mBitmap = changeLoaderColor(getBitmapFromDrawable(loader), color);

        return new LoaderDrawable(sContext, getTileArray(loader), delay);
    }

    private Bitmap[] getTileArray(LoaderType loaderType) {

        final int tileCount = loaderType.getFramesAmount();
        Bitmap [] tileArray = new Bitmap [tileCount];
        final int tildWidth = mBitmap.getWidth() / tileCount;

        int offset = 0;

        for(int i=0; i<tileCount; i++) {
            tileArray[i] = Bitmap.createBitmap(mBitmap, offset, 0, tildWidth, mBitmap.getHeight());
            offset+=tildWidth;
        }

        return tileArray;
    }

    private Bitmap changeLoaderColor(Bitmap bitmap, String hexColor) {

        Bitmap newBitmap = bitmap.copy(bitmap.getConfig(), true);

        int [] allPixels = new int[newBitmap.getHeight() * newBitmap.getWidth()];
        newBitmap.getPixels(allPixels, 0, newBitmap.getWidth(), 0, 0, newBitmap.getWidth(), newBitmap.getHeight());

        for(int pixel = 0; pixel < allPixels.length; pixel++) {

            try {
                if(allPixels[pixel] == Color.BLACK) allPixels[pixel] = Color.parseColor(hexColor);
            } catch (IllegalArgumentException iae){
                iae.printStackTrace();
            }
        }

        newBitmap.setPixels(allPixels, 0, newBitmap.getWidth(), 0, 0, newBitmap.getWidth(), newBitmap.getHeight());

        return newBitmap;
    }

    private Bitmap getBitmapFromDrawable(LoaderType type) {
        final int resourceId = sResources.getIdentifier(type.getSpriteName(), "drawable", sContext.getPackageName());
        return BitmapFactory.decodeResource(sResources, resourceId);
    }
}
