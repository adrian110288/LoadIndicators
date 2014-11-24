package com.loadindicators.adrianlesniak.loadindicators;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.Date;

public class MainActivity extends FragmentActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private CustomPagerTabStrip mPagerTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerTabStrip = (CustomPagerTabStrip) findViewById(R.id.pager_title_strip);
        mPagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.primary));
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());

        sendAppOpen();
    }

    private void sendAppOpen() {

        Tracker t = ((App) getApplication()).getTracker();
        t.send(new HitBuilders.EventBuilder().
                setCategory("APP OPENED").
                setLabel(new Date().toString()).
                build());
    }
}
