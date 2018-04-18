package com.task.vodafone.di.application;

import com.task.vodafone.app.VodafoneApplication;
import com.task.vodafone.di.activity.ActivityComponent;
import com.task.vodafone.di.activity.ActivityModule;

import dagger.Component;

/**
 This interface is used by dagger to generate the code that defines the connection between the provider of objects
 (i.e. {@link AppModule}), and the object which expresses a dependency.
 */

@ApplicationScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(VodafoneApplication vodafoneApplication);

    ActivityComponent plus(ActivityModule activityModule);

}