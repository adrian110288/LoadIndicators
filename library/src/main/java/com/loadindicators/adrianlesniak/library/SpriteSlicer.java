package com.loadindicators.adrianlesniak.library;

import android.graphics.Bitmap;

public class SpriteSlicer implements Slicer {

    private int frameCount;

    SpriteSlicer(int frameCount) {
        this.frameCount = frameCount;
    }

    @Override
    public Bitmap[] slice(Bitmap sprite) {

        Bitmap[] tileArray = new Bitmap[frameCount];
        final int tildWidth = sprite.getWidth() / frameCount;

        int offset = 0;

        for (int i = 0; i < frameCount; i++) {
            tileArray[i] = Bitmap.createBitmap(sprite, offset, 0, tildWidth, sprite.getHeight());
            offset += tildWidth;
        }

        return tileArray;
    }
}
