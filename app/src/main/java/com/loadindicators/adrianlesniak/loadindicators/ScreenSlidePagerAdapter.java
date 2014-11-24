package com.loadindicators.adrianlesniak.loadindicators;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.loadindicators.adrianlesniak.library.LoaderType;

/**
 * Created by Adrian on 22-Nov-14.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static int NUM_PAGES;
    private LoaderType[] loaders;

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
        NUM_PAGES = LoaderType.getCount();
        loaders = LoaderType.values();
    }

    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance(loaders[position]);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return loaders[position].toString().toUpperCase().replaceAll("_", " ");
    }
}
