package com.loadindicators.adrianlesniak.loadindicators;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager mPager = findViewById(R.id.pager);
        CustomPagerTabStrip mPagerTabStrip = findViewById(R.id.pager_title_strip);
        mPagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.primary));
        PagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(
                getSupportFragmentManager(),
                getLoaderModels());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());
    }

    private List<LoaderModel> getLoaderModels() {

        List<LoaderModel> models = new ArrayList<>();
        models.add(new LoaderModel("Windows", R.drawable.windows_8_loader_75, 75));
        models.add(new LoaderModel("Flip flop", R.drawable.flip_flop_32, 32));
        models.add(new LoaderModel("Intersect", R.drawable.intersect_20, 20));
        models.add(new LoaderModel("Map marker", R.drawable.map_marker_15, 15));
        models.add(new LoaderModel("Mini balls", R.drawable.mini_balls_12, 12));
        models.add(new LoaderModel("Pacman", R.drawable.pacman_10, 10));
        models.add(new LoaderModel("Pulse", R.drawable.pulse_8, 8));
        models.add(new LoaderModel("Radar", R.drawable.radar_16, 16));
        models.add(new LoaderModel("Ring Race", R.drawable.ring_race_18, 18));
        models.add(new LoaderModel("Running snake", R.drawable.running_snake_24, 24));
        models.add(new LoaderModel("Searching", R.drawable.searching_18, 18));
        models.add(new LoaderModel("Skype", R.drawable.skype_29, 29));
        models.add(new LoaderModel("Snake", R.drawable.snake_3d_8, 8));

        return models;
    }
}
