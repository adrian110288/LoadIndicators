package com.loadindicators.adrianlesniak.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by Adrian on 23-Nov-14.
 */
public class LoaderView extends ImageView {

    private Context mContext;
    private LoaderType mLoaderType;
    private int mFrameDelay = 50;

    public LoaderView(Context context) {
        super(context);
        mContext = context;
    }

    public LoaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LoaderView, 0, 0);

        if (ta.hasValue(R.styleable.LoaderView_loaderType)) {
            mLoaderType = LoaderType.getLoaderByName(ta.getString(R.styleable.LoaderView_loaderType));
        }

        if (ta.hasValue(R.styleable.LoaderView_loaderFrameDelay)) {
            mFrameDelay = ta.getInt(R.styleable.LoaderView_loaderFrameDelay, 50);
        }

        ta.recycle();
        initWithLoader();
    }

    public LoaderView(Context context, LoaderType type){
        this(context);
        mLoaderType = type;
        initWithLoader();
    }

    private void initWithLoader() {

        if(mLoaderType != null) {
            setAnimation(new LoaderFactory(mContext).getLoader(mLoaderType, mFrameDelay));
        }
    }

    public void setLoader(LoaderType type) {
        mLoaderType = type;
        initWithLoader();
    }

    public void setDelay(int delay) {
        mFrameDelay = delay;
        initWithLoader();
    }

    public void setLoaderWithDelay(LoaderType type, int delay) {
        mLoaderType = type;
        mFrameDelay = delay;
        initWithLoader();
    }

    private void setAnimation(AnimationDrawable animation) {

        if(Build.VERSION.SDK_INT >= 16) {
            setBackground(animation);
        } else {
            setBackgroundDrawable(animation);
        }

        animation.start();
    }
}
