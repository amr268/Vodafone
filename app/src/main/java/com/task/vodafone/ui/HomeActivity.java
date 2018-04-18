package com.task.vodafone.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.task.vodafone.R;
import com.task.vodafone.app.VodafoneApplication;
import com.task.vodafone.data.HomeRepo;
import com.task.vodafone.data.ResultListener;
import com.task.vodafone.data.models.bundle.BundleModel;
import com.task.vodafone.di.activity.ActivityModule;
import com.task.vodafone.ui.home.GroupAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.rv_bundles)
    RecyclerView rvBundles;

    @Inject
    GroupAdapter adapter;

    @Inject
    HomeRepo homeRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        VodafoneApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);

        homeRepo.fetchBundles(new ResultListener<HashMap<String, ArrayList<BundleModel>>>() {
            @Override
            public void onSuccess(HashMap<String, ArrayList<BundleModel>> data) {
                Log.d("success", "done");
                adapter.updateList(data);
                rvBundles.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false));
                rvBundles.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable t) {
                Log.e("error", "done");
            }
        });

    }
}
