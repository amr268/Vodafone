package com.amr.core.activity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.amr.core.R;
import com.amr.core.di.CoreActivityModule;
import com.amr.core.di.DaggerCoreActivityComponent;
import com.amr.core.permission.PermissionUtil;
import com.amr.core.util.ResourcesUtil;
import com.amr.core.util.UiUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity implements LifecycleOwner, BaseScreen {

    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    protected RxPermissions rxPermissions;

    @Inject
    UiUtil uiUtil;
    @Inject
    ResourcesUtil resourcesUtil;
    @Inject
    PermissionUtil permissionUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        DaggerCoreActivityComponent.builder().coreActivityModule(new CoreActivityModule(this));
        rxPermissions = new RxPermissions(this);
        onCreateActivity();
        lifecycleRegistry.markState(Lifecycle.State.CREATED);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void onStart() {
        super.onStart();
        lifecycleRegistry.markState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleRegistry.markState(Lifecycle.State.RESUMED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showDefaultMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessMessage(String message) {
        uiUtil.getSuccessToast(message)
                .show();
    }

    @Override
    public void showAnnouncementMessage(String message) {
        uiUtil.getAnnouncementToast(message)
                .show();
    }

    @Override
    public void showWarningMessage(String message) {
        uiUtil.getWarningToast(message)
                .show();
    }

    @Override
    public void showErrorMessage(String message) {
        uiUtil.getErrorToast(message)
                .show();
    }

    @Override
    public void showLoadingAnimation() {
        uiUtil.getProgressDialog(getString(R.string.please_wait))
                .show();
    }

    @Override
    public void hideLoadingAnimation() {
        uiUtil.getProgressDialog()
                .dismiss();
    }

    @Override
    public ResourcesUtil getResourcesUtil() {
        return resourcesUtil;
    }

    @Override
    public PermissionUtil getPermissionUtil() {
        return permissionUtil;
    }

    @Override
    public UiUtil getUiUtil() {
        return uiUtil;
    }

    protected abstract void onCreateActivity();

    @LayoutRes
    protected abstract int getLayout();


}
