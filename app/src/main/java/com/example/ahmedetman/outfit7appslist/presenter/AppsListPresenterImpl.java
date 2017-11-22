package com.example.ahmedetman.outfit7appslist.presenter;

import com.example.ahmedetman.outfit7appslist.contract.ApplicationsListContract;
import com.example.ahmedetman.outfit7appslist.model.InstalledAppsDataProvider;

/**
 * Created by Ahmed Etman on 11/20/2017.
 */

public class AppsListPresenterImpl implements ApplicationsListContract.ApplicationListPresenter {


    private ApplicationsListContract.ApplicationListView applicationListView;

    public AppsListPresenterImpl(ApplicationsListContract.ApplicationListView applicationListView) {
        this.applicationListView = applicationListView;
    }

    @Override
    public void loadAppsList() {
        applicationListView.showAppsList(InstalledAppsDataProvider.getInstance().getAllOutfitApps());
    }
}
