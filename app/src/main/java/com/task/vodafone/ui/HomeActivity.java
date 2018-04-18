package com.task.vodafone.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.task.vodafone.R;
import com.task.vodafone.app.VodafoneApplication;
import com.task.vodafone.data.HomeRepo;
import com.task.vodafone.data.ResultListener;
import com.task.vodafone.data.models.bundle.BundleModel;
import com.task.vodafone.di.activity.ActivityModule;

import java.util.ArrayList;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {

    @Inject
    HomeRepo homeRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        VodafoneApplication.getComponent(this)
                .plus(new ActivityModule(this))
                .inject(this);

        homeRepo.fetchBundles(new ResultListener<ArrayList<BundleModel>>() {
            @Override
            public void onSuccess(ArrayList<BundleModel> data) {
                Log.d("success", "done");
            }

            @Override
            public void onError(Throwable t) {
                Log.e("error", "done");
            }
        });

    }
}
