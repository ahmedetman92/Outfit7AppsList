package com.example.ahmedetman.outfit7appslist.contract;

import android.content.pm.ApplicationInfo;

import java.util.ArrayList;

/**
 * Created by Ahmed Etman on 11/20/2017.
 */

public interface ApplicationsListContract {

    interface ApplicationListPresenter {
        /**
         * loading the outfit7 applications list from the data provider
         */
        void loadAppsList();
    }

    interface ApplicationListView {
        /**
         * displaying list of outfit apps on the UI
         *
         * @param appsList: list of apps to display
         */
        void showAppsList(ArrayList<ApplicationInfo> appsList);
    }
}
