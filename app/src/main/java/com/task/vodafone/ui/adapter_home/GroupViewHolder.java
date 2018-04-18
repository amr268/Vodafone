package com.task.vodafone.ui.adapter_home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.task.vodafone.R;
import com.task.vodafone.data.models.bundle.BundleModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title_group)
    TextView tvTitle;
    @BindView(R.id.iv_expand)
    ImageView ivExpand;
    @BindView(R.id.rv_bundles_child)
    RecyclerView rvBundles;

    private boolean isExpand;

    private Context context;

    public GroupViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(String title, ArrayList<BundleModel> bundleModels) {
        tvTitle.setText(title);
        ivExpand.setImageResource(R.drawable.ic_expand);
        ChildAdapter adapter = new ChildAdapter();
        adapter.updateList(bundleModels);
        rvBundles.setVisibility(View.GONE);
        rvBundles.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        rvBundles.setAdapter(adapter);
        isExpand = false;
    }

    @OnClick(R.id.iv_expand)
    public void onExpandClick(View view) {
        if (!isExpand) {
            isExpand = true;
            ivExpand.setImageResource(R.drawable.ic_collapse);
            rvBundles.setVisibility(View.VISIBLE);
            rvBundles.scrollToPosition(getAdapterPosition());
        } else {
            isExpand = false;
            ivExpand.setImageResource(R.drawable.ic_expand);
            rvBundles.setVisibility(View.GONE);
        }

    }

}
