package jc.spotifyclient;

import android.app.Application;

import jc.spotifyclient.di.ActivityComponent;
import jc.spotifyclient.di.ApplicationComponent;
import jc.spotifyclient.di.DaggerActivityComponent;
import jc.spotifyclient.di.DaggerApplicationComponent;

public class App extends Application {

    private ActivityComponent activityComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder().build();
        applicationComponent.inject(this);

        activityComponent = DaggerActivityComponent.builder().build();

    }


    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }


}
