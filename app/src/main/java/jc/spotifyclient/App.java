package jc.spotifyclient;

import android.app.Application;

import jc.spotifyclient.di.ApplicationComponent;
import jc.spotifyclient.di.ApplicationModule;
import jc.spotifyclient.di.DaggerApplicationComponent;

public class App extends Application {

    private ApplicationModule applicationModule;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationModule = new ApplicationModule(this);

        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder().build();
        applicationComponent.inject(this);

    }

}
