package com.loadindicators.adrianlesniak.loadindicators;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Adrian on 22-Nov-14.
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static int NUM_PAGES;

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
        NUM_PAGES = 1;
    }

    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "// TODO";
    }
}
