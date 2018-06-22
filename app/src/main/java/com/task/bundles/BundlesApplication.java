package com.task.bundles;

import android.app.Application;
import android.content.Context;

import com.task.bundles.di.application.AppComponent;
import com.task.bundles.di.application.AppModule;
import com.task.bundles.di.application.DaggerAppComponent;

public class BundlesApplication extends Application {

    private final AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    public static AppComponent getComponent(Context context) {
        return getApp(context).appComponent;
    }

    private static BundlesApplication getApp(Context context) {
        return (BundlesApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent.inject(this);
    }
}
