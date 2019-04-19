package com.loadindicators.adrianlesniak.loadindicators;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;

public class LoaderModel implements Parcelable {

    public static final Creator<LoaderModel> CREATOR = new Creator<LoaderModel>() {
        @Override
        public LoaderModel createFromParcel(Parcel in) {
            return new LoaderModel(in);
        }

        @Override
        public LoaderModel[] newArray(int size) {
            return new LoaderModel[size];
        }
    };
    private String name;
    @DrawableRes
    private int loaderSrc;
    private int frameCount;

    public LoaderModel(String name, int loaderSrc, int frameCount) {
        this.name = name;
        this.loaderSrc = loaderSrc;
        this.frameCount = frameCount;
    }

    protected LoaderModel(Parcel in) {
        name = in.readString();
        loaderSrc = in.readInt();
        frameCount = in.readInt();
    }

    public String getName() {
        return name;
    }

    public int getLoaderSrc() {
        return loaderSrc;
    }

    public int getFrameCount() {
        return frameCount;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(loaderSrc);
        dest.writeInt(frameCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
