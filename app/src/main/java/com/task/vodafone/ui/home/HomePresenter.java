package com.task.vodafone.ui.home;

import android.util.Log;

import com.amr.core.activity.BasePresenter;
import com.task.vodafone.data.BundleRepo;
import com.task.vodafone.data.ResultListener;
import com.task.vodafone.data.models.bundle.BundleModel;
import com.task.vodafone.di.activity.ActivityScope;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

@ActivityScope
public class HomePresenter extends BasePresenter {

    private final HomeScreen homeScreen;
    private final BundleRepo bundleRepo;

    @Inject
    protected HomePresenter(HomeScreen homeScreen, BundleRepo bundleRepo) {
        super(homeScreen);
        this.homeScreen = homeScreen;
        this.bundleRepo = bundleRepo;
    }

    @Override
    protected void onResume() {
        super.onResume();
        getBundles();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bundleRepo.onDestroy();
    }

    private void getBundles() {
        bundleRepo.fetchBundles(new ResultListener<HashMap<String, ArrayList<BundleModel>>>() {
            @Override
            public void onSuccess(HashMap<String, ArrayList<BundleModel>> data) {
                Log.d("success", "done");
                homeScreen.updateUi(data);

            }

            @Override
            public void onError(Throwable t) {
                Log.e("error", "done");
                homeScreen.showErrorMessage(t.getMessage());
            }
        });
    }
}
