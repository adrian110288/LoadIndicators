package com.loadindicators.adrianlesniak.loadindicators;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by Adrian on 23-Nov-14.
 */
public class App extends Application {

    private static final String PROPERTY_ID = "UA-47453015-3";

    synchronized Tracker getTracker() {

        GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
        Tracker t = analytics.newTracker(PROPERTY_ID);

        return t;
    }
}
