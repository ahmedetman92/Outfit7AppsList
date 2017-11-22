package com.example.ahmedetman.outfit7appslist;

import android.app.Application;

import java.lang.ref.WeakReference;

/**
 * Created by Ahmed Etman on 11/20/2017.
 */

public class OutfitApplication extends Application {

    private static WeakReference<OutfitApplication> outfitApplicationWeakReference;

    public static OutfitApplication getInstance() {
       return outfitApplicationWeakReference.get();
    }

    @Override
    public void onCreate() {
        outfitApplicationWeakReference = new WeakReference<OutfitApplication>(this);
        super.onCreate();
    }
}
