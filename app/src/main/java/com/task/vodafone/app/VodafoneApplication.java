package com.task.vodafone.app;

import android.app.Application;
import android.content.Context;

import com.task.vodafone.di.application.AppComponent;
import com.task.vodafone.di.application.AppModule;
import com.task.vodafone.di.application.DaggerAppComponent;

public class VodafoneApplication extends Application {

    private final AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    public static AppComponent getComponent(Context context) {
        return getApp(context).appComponent;
    }

    private static VodafoneApplication getApp(Context context) {
        return (VodafoneApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent.inject(this);
    }
}
