package com.task.vodafone.di.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.task.vodafone.ui.home.HomeScreen;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 This class is responsible for providing the requested objects to {@link ActivityScope} annotated classes
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    Activity provideActivity() {
        return activity;
    }

    @ActivityScope
    @Provides
    @ForActivity
    Context provideActivityContext() {
        return activity;
    }

    @ActivityScope
    @Provides
    FragmentManager provideFragmentManager() {
        return ((AppCompatActivity) activity).getSupportFragmentManager();
    }

    @ActivityScope
    @Provides
    HomeScreen provideHomeScreen() {
        return (HomeScreen) activity;
    }

    @ActivityScope
    @Provides
    CompositeDisposable providesCompositeDisposable() {
        return new CompositeDisposable();
    }
}