package com.task.bundles.di.application;

import com.task.bundles.BundlesApplication;
import com.task.bundles.di.activity.ActivityComponent;
import com.task.bundles.di.activity.ActivityModule;

import dagger.Component;

/**
 This interface is used by dagger to generate the code that defines the connection between the provider of objects
 (i.e. {@link AppModule}), and the object which expresses a dependency.
 */

@ApplicationScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(BundlesApplication bundlesApplication);

    ActivityComponent plus(ActivityModule activityModule);

}