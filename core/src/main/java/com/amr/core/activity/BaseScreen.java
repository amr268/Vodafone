package com.amr.core.activity;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;

import com.amr.core.permission.PermissionUtil;
import com.amr.core.util.ResourcesUtil;
import com.amr.core.util.UiUtil;

public interface BaseScreen {

    void showDefaultMessage(String message);

    void showSuccessMessage(String message);

    void showAnnouncementMessage(String message);

    void showWarningMessage(String message);

    void showErrorMessage(String message);

    void showLoadingAnimation();

    void hideLoadingAnimation();

    ResourcesUtil getResourcesUtil();

    PermissionUtil getPermissionUtil();

    UiUtil getUiUtil();

    Intent getIntent();

    Lifecycle getLifecycle();
}
