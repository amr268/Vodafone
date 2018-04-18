package com.amr.core.di;

import com.amr.core.activity.BaseActivity;

import dagger.Component;

@CoreComponentScope
@Component(modules = {CoreActivityModule.class})
public interface CoreActivityComponent {

    void inject(BaseActivity baseActivity);
}
