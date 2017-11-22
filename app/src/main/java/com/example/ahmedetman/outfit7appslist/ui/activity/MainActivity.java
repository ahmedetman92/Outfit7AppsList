package com.example.ahmedetman.outfit7appslist.ui.activity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ahmedetman.outfit7appslist.contract.ApplicationsListContract;
import com.example.ahmedetman.outfit7appslist.R;
import com.example.ahmedetman.outfit7appslist.presenter.AppsListPresenterImpl;
import com.example.ahmedetman.outfit7appslist.ui.adapter.ApplicationsListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ApplicationsListContract.ApplicationListView {


    public static final String APP_INFO_DATA = "APP_INFO_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppsListPresenterImpl appsListPresenter = new AppsListPresenterImpl(this);
        appsListPresenter.loadAppsList();
    }

    @Override
    public void showAppsList(final ArrayList<ApplicationInfo> appsList) {
        RecyclerView recyclerView = findViewById(R.id.rv_apps_list);
        if (appsList.isEmpty()) {
            findViewById(R.id.tv_no_data_found).setVisibility(View.VISIBLE);
        } else {
            ApplicationsListAdapter applicationsListAdapter = new ApplicationsListAdapter(appsList);
            applicationsListAdapter.setOnAppClickListener(new ApplicationsListAdapter.OnAppClickListener() {
                @Override
                public void onAppClicked(ApplicationInfo applicationInfo) {
                    Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                    if (applicationInfo != null) {
                        Bundle b = new Bundle();
                        b.putParcelable(APP_INFO_DATA, applicationInfo);
                        i.putExtras(b);
                    }
                    startActivity(i);
                }
            });
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
            recyclerView.setAdapter(applicationsListAdapter);
        }
    }
}
