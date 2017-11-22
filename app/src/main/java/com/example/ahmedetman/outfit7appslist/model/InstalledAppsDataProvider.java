package com.example.ahmedetman.outfit7appslist.model;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.example.ahmedetman.outfit7appslist.OutfitApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Etman on 11/20/2017.
 */

public class InstalledAppsDataProvider {


    private static String OUTFIT7_APPS_KEYWORD = "com.outfit7";
    private static InstalledAppsDataProvider instance = null;

    public static InstalledAppsDataProvider getInstance() {
        if (instance == null) {
            instance = new InstalledAppsDataProvider();
        }
        return instance;
    }

    /**
     * getting all installed applications on the device
     *
     * @return
     */
    public ArrayList<ApplicationInfo> getAllOutfitApps() {
        PackageManager pm = OutfitApplication.getInstance().getPackageManager();
        List<ApplicationInfo> apps = pm.getInstalledApplications(0);

        return filterApplications(apps, OUTFIT7_APPS_KEYWORD);
    }

    /**
     * filtering list of applications by specific keyword
     *
     * @param apps
     * @return
     */
    private ArrayList<ApplicationInfo> filterApplications(List<ApplicationInfo> apps, String searchTerm) {
        ArrayList<ApplicationInfo> installedApps = new ArrayList<>();
        for (ApplicationInfo app : apps) {
            //checks for flags; if flagged, check if updated system app
            if ((app.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
                continue;
                //it's a system app, not interested
            } else if ((app.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                continue;
            } else {
                //adding the applications that only contains search term
                if (app.packageName.contains(searchTerm)) {
                    installedApps.add(app);
                }
            }
        }
        return installedApps;
    }
}
