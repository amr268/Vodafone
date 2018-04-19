package com.task.vodafone.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.amr.core.activity.BaseActivity;
import com.task.vodafone.R;
import com.task.vodafone.app.VodafoneApplication;
import com.task.vodafone.data.models.bundle.BundleModel;
import com.task.vodafone.di.activity.ActivityModule;
import com.task.vodafone.ui.adapter_home.GroupAdapter;

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
        VodafoneApplication.getComponent(this)
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
