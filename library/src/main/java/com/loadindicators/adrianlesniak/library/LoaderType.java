package com.loadindicators.adrianlesniak.library;

import android.content.Loader;

/**
 * Created by Adrian on 22-Nov-14.
 */
public enum LoaderType {

    SNAKE_3D ("snake_3d_8"),
    FLIP_FLOP ("flip_flop_32"),
    INTERSECT ("intersect_20"),
    MINI_BALLS ("mini_balls_12"),
    PACMAN ("pacman_10"),
    PULSE ("pulse_8"),
    RADAR ("radar_16"),
    RING_RACE ("ring_race_18"),
    RUNNING_SNAKE ("running_snake_24"),
    SEARCHING ("searching_18"),
    SKYPE ("skype_29"),
    SPIN_AND_FADE ("spin_fade_18"),
    SPINNING_GEAR ("spinning_gear_10"),
    TIME_MACHINE ("time_machine_8"),
    WINDOWS_8 ("windows_8_loader_75"),
    MAP_MARKER ("map_marker_15");

    private String spriteName;
    private int frames;

    LoaderType(String nameIn) {
        spriteName = nameIn;

        int lastDashIndex = spriteName.lastIndexOf("_");
        String sub =spriteName.substring(lastDashIndex+1, spriteName.length());
        frames = Integer.parseInt(sub);
    }

    public String getSpriteName() {
        return spriteName;
    }

    public int getFramesAmount() {
        return frames;
    }

    public static int getCount() {
        return LoaderType.values().length;
    }

    public static LoaderType getLoaderByName(String name) {

        LoaderType loader = null;

        for(int i=0; i<values().length; i++) {

            if(name.equals(values()[i].toString().toLowerCase().replaceAll("_", " "))) {
                loader = values()[i];
                break;
            }
        }

        return loader;
    }
}
