package com.example.ahmedetman.outfit7appslist.ui.adapter;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmedetman.outfit7appslist.OutfitApplication;
import com.example.ahmedetman.outfit7appslist.R;

import java.util.ArrayList;

/**
 * Created by Ahmed Etman on 11/20/2017.
 */

public class ApplicationsListAdapter extends  RecyclerView.Adapter<ApplicationsListAdapter.CustomViewHolder>
{
    OnAppClickListener mOnAppClickListener;

    public void setOnAppClickListener(OnAppClickListener onAppClickListener) {
        this.mOnAppClickListener = onAppClickListener;
    }


    private ArrayList<ApplicationInfo> mApplicationInfo;
    public ApplicationsListAdapter(ArrayList<ApplicationInfo> applicationInfo)
    {
        this.mApplicationInfo = applicationInfo;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new CustomViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position)
    {
        PackageManager pm = OutfitApplication.getInstance().getPackageManager();
        final ApplicationInfo item =  mApplicationInfo.get(position);
        String label = (String)pm.getApplicationLabel(item);
        Drawable icon = pm.getApplicationIcon(item);

        holder.appName.setText(label);
        holder.appIcon.setImageDrawable(icon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if( mOnAppClickListener != null){
                   mOnAppClickListener.onAppClicked(item);
               }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mApplicationInfo.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder
    {
        TextView appName;
        ImageView appIcon;

        public CustomViewHolder(View view)
        {
            super(view);
            this.appName = view.findViewById(R.id.tv_app_name);
            this.appIcon = view.findViewById(R.id.iv_app_icon);
        }
    }

   public interface OnAppClickListener{
        void onAppClicked(ApplicationInfo applicationInfo);
    }


}

