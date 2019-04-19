package com.loadindicators.adrianlesniak.loadindicators;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Adrian on 22-Nov-14.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private final List<LoaderModel> loaderModels;

    public ScreenSlidePagerAdapter(FragmentManager fm, List<LoaderModel> loaderModels) {
        super(fm);
        this.loaderModels = loaderModels;
    }

    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance(loaderModels.get(position));
    }

    @Override
    public int getCount() {
        return loaderModels.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return loaderModels.get(position).getName().toUpperCase();
    }
}
