package com.amr.core.permission;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static com.amr.core.permission.PermissionType.PERMISSION_TYPE_LOCATION;
import static com.amr.core.permission.PermissionType.PERMISSION_TYPE_WRITE_EXTERNAL_STORAGE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef({PERMISSION_TYPE_LOCATION, PERMISSION_TYPE_WRITE_EXTERNAL_STORAGE})
public @interface PermissionType {

    int PERMISSION_TYPE_LOCATION = 0;
    int PERMISSION_TYPE_WRITE_EXTERNAL_STORAGE = 1;
}
