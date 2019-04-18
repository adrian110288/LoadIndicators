package com.loadindicators.adrianlesniak.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class LoaderIndicator extends AppCompatImageView {

    private static final int LOADER_SRC_MISSING = -1;

    private static final int DEFAULT_FRAME_DURATION = 50;
    private static final boolean DEFAULT_AUTO_START = true;
    private static final boolean DEFAULT_CAN_LOOP = true;
    private static final boolean DEFAULT_LOOP_IN_REVERSE = false;

    @DrawableRes
    private int loaderSrc;

    private int frameDuration;

    private int frameCount;

    private boolean autoStart;

    private boolean canLoop;

    private boolean loopInReverse;

    private AnimationDrawable animationDrawable;

    public LoaderIndicator(Context context) {
        this(context, null);
    }

    public LoaderIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LoaderIndicator, 0, 0);

            int frameCount = ta.getInteger(R.styleable.LoaderIndicator_loader_frameCount, 0);
            if (frameCount < 1) {
                throw new IllegalArgumentException("Loader frame count most be 1 or greater.");
            } else {
                this.frameCount = frameCount;
            }

            if (ta.hasValue(R.styleable.LoaderIndicator_loader_src) &&
                    !ta.hasValue(R.styleable.LoaderIndicator_loader_frameCount)) {
                throw new IllegalArgumentException("Loader frame count must be specified!");
            }

            loaderSrc = ta.getResourceId(R.styleable.LoaderIndicator_loader_src, LOADER_SRC_MISSING);
            frameDuration = ta.getInteger(R.styleable.LoaderIndicator_loader_frameDuration, DEFAULT_FRAME_DURATION);
            autoStart = ta.getBoolean(R.styleable.LoaderIndicator_loader_autoStart, DEFAULT_AUTO_START);
            canLoop = ta.getBoolean(R.styleable.LoaderIndicator_loader_canLoop, DEFAULT_CAN_LOOP);
            loopInReverse = ta.getBoolean(R.styleable.LoaderIndicator_loader_loopInReverse, DEFAULT_LOOP_IN_REVERSE);

            ta.recycle();

        }

        init();
    }

    private void init() {

        if (loaderSrc != LOADER_SRC_MISSING) {
            animationDrawable = getSpriteAnimation(
                    loaderSrc,
                    frameCount,
                    frameDuration,
                    loopInReverse
            );

            animationDrawable.setOneShot(!canLoop);

            setAnimation(animationDrawable);

            if (autoStart) {
                this.startAnimate();
            }
        }
    }

    public void startAnimate() {

        if (animationDrawable != null && !animationDrawable.isRunning()) {
            animationDrawable.start();
        }
    }

    public void stopAnimate() {
        if (animationDrawable != null && animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
    }

    private void setAnimation(AnimationDrawable animation) {

        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(animation);
        } else {
            setBackgroundDrawable(animation);
        }
    }

    private AnimationDrawable getSpriteAnimation(@DrawableRes int drawableResId,
                                                 int frameCount,
                                                 int frameDuration,
                                                 boolean loopInReverse) {

        Slicer slicer = new SpriteSlicer(frameCount);

        return new AnimatedLoaderDrawable(
                getResources(),
                slicer,
                drawableResId,
                frameDuration,
                loopInReverse
        );
    }
}
