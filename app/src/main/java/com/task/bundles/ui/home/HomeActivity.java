package com.task.bundles.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.amr.core.activity.BaseActivity;
import com.task.bundles.BundlesApplication;
import com.task.bundles.data.models.bundle.BundleModel;
import com.task.bundles.di.activity.ActivityModule;
import com.task.bundles.ui.adapter_home.GroupAdapter;
import com.task.bundles.R;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeScreen {

    @BindView(R.id.rv_bundles)
    RecyclerView rvBundles;

    @Inject
    GroupAdapter adapter;

    @Inject
    HomePresenter homePresenter;

    @Override
    protected void onCreateActivity() {
        ButterKnife.bind(this);
        BundlesApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void updateUi(HashMap<String, ArrayList<BundleModel>> bundleModelsMap) {
        adapter.updateList(bundleModelsMap);
        rvBundles.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false));
        rvBundles.setAdapter(adapter);
    }

    @Override
    public void updateRecyclerPosition(int position) {
        rvBundles.scrollToPosition(position);
    }
}
