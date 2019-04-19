package com.loadindicators.adrianlesniak.loadindicators;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

public class TypefaceCache {

    private static Map<String, Typeface> cache =
            new HashMap<>();

    public static Typeface getTypeface(AssetManager mgr, String path) {

        if (cache.containsKey(path)) {
            return cache.get(path);
        }

        Typeface typeface = Typeface.createFromAsset(mgr, path);
        cache.put(path, typeface);

        return typeface;
    }
}
