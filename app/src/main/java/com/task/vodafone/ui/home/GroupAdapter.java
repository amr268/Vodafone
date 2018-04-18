package com.task.vodafone.ui.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.task.vodafone.R;
import com.task.vodafone.data.models.bundle.BundleModel;
import com.task.vodafone.di.activity.ActivityScope;
import com.task.vodafone.di.activity.ForActivity;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

@ActivityScope
public class GroupAdapter extends RecyclerView.Adapter<GroupViewHolder> {


    private HashMap<String, ArrayList<BundleModel>> bundlesMap = new HashMap<>();
    private Context context;

    @Inject
    public GroupAdapter(@ForActivity Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        return new GroupViewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        switch (position) {
            case 0:
                String MONTHLY = "Monthly";
                holder.onBind(MONTHLY, bundlesMap.get(MONTHLY));
                break;
            case 1:
                String WEEKLY = "Weekly";
                holder.onBind(WEEKLY, bundlesMap.get(WEEKLY));
                break;
            case 2:
                String DAILY = "Daily";
                holder.onBind(DAILY, bundlesMap.get(DAILY));
                break;
            case 3:
                String HOURLy = "Hourly";
                holder.onBind(HOURLy, bundlesMap.get(HOURLy));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return bundlesMap.size();
    }

    public void updateList(HashMap<String, ArrayList<BundleModel>> bundlesMap) {
        this.bundlesMap.clear();
        this.bundlesMap = bundlesMap;
        notifyDataSetChanged();
    }
}
