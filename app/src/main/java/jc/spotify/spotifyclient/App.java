package jc.spotify.spotifyclient;

import android.app.Application;

import jc.spotify.spotifyclient.di.ApplicationComponent;
import jc.spotify.spotifyclient.di.ApplicationModule;
import jc.spotify.spotifyclient.di.DaggerApplicationComponent;

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
