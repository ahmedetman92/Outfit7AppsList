package com.example.ahmedetman.outfit7appslist.ui.activity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ahmedetman.outfit7appslist.OutfitApplication;
import com.example.ahmedetman.outfit7appslist.R;

import static com.example.ahmedetman.outfit7appslist.ui.activity.MainActivity.APP_INFO_DATA;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            ApplicationInfo applicationInfo = b.getParcelable(APP_INFO_DATA);
            initViews(applicationInfo);
        }
    }

    /**
     * initialization the views with the application information
     *
     * @param applicationInfo
     */
    private void initViews(final ApplicationInfo applicationInfo) {

        String vName = null;
        int vNumber = 0;
        try {
            PackageInfo pInfo = OutfitApplication.getInstance().getPackageManager().getPackageInfo(
                    applicationInfo.packageName, 0);
            vName = pInfo.versionName;
            vNumber = pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        TextView packageName = findViewById(R.id.tv_package_name);
        TextView versionCode = findViewById(R.id.tv_version_code);
        TextView versionName = findViewById(R.id.tv_version_name);
        Button openApp = findViewById(R.id.btn_open_app);
        openApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(applicationInfo.packageName);
                startActivity(launchIntent);
            }
        });

        packageName.setText(applicationInfo.packageName);
        versionName.setText(vName);
        versionCode.setText(String.valueOf(vNumber));
    }
}
