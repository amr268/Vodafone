package com.task.bundles.data;

import com.task.bundles.data.api.WebServicesStore;
import com.task.bundles.data.models.bundle.BundleMapper;
import com.task.bundles.data.models.bundle.BundleModel;
import com.task.bundles.di.activity.ActivityScope;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@ActivityScope
public class BundleRepo {

    private final CompositeDisposable disposable;
    private final WebServicesStore webServicesStore;
    private final BundleMapper bundleMapper;

    @Inject
    public BundleRepo(CompositeDisposable disposable, WebServicesStore webServicesStore, BundleMapper bundleMapper) {
        this.disposable = disposable;
        this.webServicesStore = webServicesStore;
        this.bundleMapper = bundleMapper;
    }

    public void fetchBundles(ResultListener<HashMap<String, ArrayList<BundleModel>>> resultListener) {
        disposable.add(
                webServicesStore.fetchBundles()
                        .map(bundleMapper::toBundleModels)
                        .map(bundleMapper::toBundleModelsMap)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(resultListener::onSuccess, resultListener::onError));
    }

    public void onDestroy() {
        disposable.clear();
    }

}
