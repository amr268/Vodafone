package com.task.vodafone.ui.adapter_home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.task.vodafone.R;
import com.task.vodafone.data.models.bundle.BundleModel;
import com.task.vodafone.di.activity.ActivityScope;

import java.util.ArrayList;

import javax.inject.Inject;

@ActivityScope
public class ChildAdapter extends RecyclerView.Adapter<ChildViewHolder> {

    public ArrayList<BundleModel> bundleModels = new ArrayList<>();

    @Inject
    public ChildAdapter() {
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child, parent, false);
        return new ChildViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        holder.onBind(bundleModels.get(position));
    }

    @Override
    public int getItemCount() {
        return bundleModels.size();
    }

    public void updateList(ArrayList<BundleModel> bundleModels) {
        this.bundleModels.clear();
        this.bundleModels = bundleModels;
        notifyDataSetChanged();
    }
}
