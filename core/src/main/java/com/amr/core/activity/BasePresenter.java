package com.amr.core.activity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Intent;

import com.amr.core.permission.PermissionUtil;
import com.amr.core.util.ResourcesUtil;

import javax.inject.Inject;

public class BasePresenter implements LifecycleObserver {

    private final BaseScreen baseScreen;

    @Inject
    protected BasePresenter(BaseScreen baseScreen) {
        this.baseScreen = baseScreen;
        baseScreen.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy() {
    }

    protected Intent getIntent() {
        return baseScreen.getIntent();
    }

    protected Lifecycle getLifeCycle() {
        return baseScreen.getLifecycle();
    }

    protected ResourcesUtil getResourcesUtil() {
        return baseScreen.getResourcesUtil();
    }

    protected PermissionUtil getPermissionUtil() {
        return baseScreen.getPermissionUtil();
    }
}
