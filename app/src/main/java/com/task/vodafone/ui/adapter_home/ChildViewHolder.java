package com.task.vodafone.ui.adapter_home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.task.vodafone.R;
import com.task.vodafone.custom_view.BundleView;
import com.task.vodafone.data.models.bundle.BundleModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChildViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.bundle_view)
    BundleView bundleView;

    public ChildViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(BundleModel bundleModel) {
        bundleView.setTitle(bundleModel.getTitle());
        bundleView.setPrice(bundleModel.getPrice()+" "+bundleModel.getCurrency());
        bundleView.setType(bundleModel.getType());
        bundleView.setDescription(bundleModel.getDescription());
    }
}
