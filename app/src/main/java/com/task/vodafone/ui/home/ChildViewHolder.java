package com.task.vodafone.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.task.vodafone.R;
import com.task.vodafone.data.models.bundle.BundleModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChildViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_description)
    TextView tvDescription;

    public ChildViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(BundleModel bundleModel) {
        tvTitle.setText(bundleModel.getTitle());
        tvPrice.setText(bundleModel.getPrice());
        tvType.setText(bundleModel.getType());
        tvDescription.setText(bundleModel.getDescription());
    }
}
