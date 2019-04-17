package com.loadindicators.adrianlesniak.loadindicators;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager mPager = findViewById(R.id.pager);
        CustomPagerTabStrip mPagerTabStrip = findViewById(R.id.pager_title_strip);
        mPagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.primary));
        PagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());
    }
}
