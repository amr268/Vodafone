package com.task.bundles.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.amr.core.activity.BasePresenter;
import com.cantrowitz.rxbroadcast.RxBroadcast;
import com.task.bundles.data.BundleRepo;
import com.task.bundles.data.ResultListener;
import com.task.bundles.data.constant.Constant;
import com.task.bundles.data.models.bundle.BundleModel;
import com.task.bundles.di.activity.ActivityScope;
import com.task.bundles.di.activity.ForActivity;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

@ActivityScope
public class HomePresenter extends BasePresenter {

    private HomeScreen homeScreen;
    private BundleRepo bundleRepo;
    private Context context;
    private Disposable disposable;

    @Inject
    protected HomePresenter(@ForActivity Context context, HomeScreen homeScreen, BundleRepo bundleRepo) {
        super(homeScreen);
        this.homeScreen = homeScreen;
        this.bundleRepo = bundleRepo;
        this.context = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        disposable = getGlobalBroadcastObservable()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        homeScreen.updateRecyclerPosition(integer);
                    }
                });
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
        if (disposable != null)
            disposable.dispose();
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

    @NonNull
    private Observable<Integer> getGlobalBroadcastObservable() {
        return RxBroadcast.fromBroadcast(context, new IntentFilter(Constant.ACTION_CHANGE_POSITION))
                .map(new Function<Intent, Integer>() {
                    @Override
                    public Integer apply(Intent intent) {
                        return intent.getIntExtra(Constant.EXTRA_POSITION, 0);
                    }
                });
    }
}
