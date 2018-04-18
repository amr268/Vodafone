package com.amr.core.di;

import android.content.Context;

import com.amr.core.activity.BaseActivity;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;

@Module
public class CoreActivityModule {

    private final BaseActivity baseActivity;

    public CoreActivityModule(BaseActivity baseActivity) {
        this.baseActivity = new WeakReference<>(baseActivity).get();
    }

    @Provides
    @CoreComponentScope
    BaseActivity providesBaseActivity() {
        return baseActivity;
    }

    @Provides
    @CoreComponentScope
    Context provideBaseActivityContext() {
        return baseActivity;
    }
}
