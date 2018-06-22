package com.task.bundles.di.application;

import android.app.Application;
import android.content.Context;

import com.amr.core.permission.PermissionUtil;
import com.amr.core.util.PhoneUtil;
import com.amr.core.util.PreferencesUtil;
import com.amr.core.util.ResourcesUtil;
import com.amr.core.util.TextUtil;
import com.amr.core.util.UiUtil;

import dagger.Module;
import dagger.Provides;

/**
 This class is responsible for providing the requested objects to {@link ApplicationScope} annotated classes
 */

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {this.application = application;}

    @ApplicationScope
    @Provides
    Application providesApplication() {
        return application;
    }

    @ApplicationScope
    @Provides
    @ForApplication
    Context providesApplicationContext() {
        return application;
    }

    @ApplicationScope
    @Provides
    PreferencesUtil providesPreferencesUtil() {
        return new PreferencesUtil(application);
    }

    @ApplicationScope
    @Provides
    TextUtil providesTextUtil() {
        return new TextUtil(application);
    }

    @ApplicationScope
    @Provides
    ResourcesUtil providesResourcesUtil() {
        return new ResourcesUtil(application);
    }

    @ApplicationScope
    @Provides
    PermissionUtil providePermissionUtil() {
        return new PermissionUtil(application);
    }

    @ApplicationScope
    @Provides
    UiUtil provideUiUtil() {
        return new UiUtil(application);
    }

    @ApplicationScope
    @Provides
    PhoneUtil providePhone() {
        return new PhoneUtil(application);
    }

}