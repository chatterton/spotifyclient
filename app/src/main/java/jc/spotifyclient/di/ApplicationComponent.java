package jc.spotifyclient.di;

import javax.inject.Singleton;

import dagger.Component;
import jc.spotifyclient.App;
import jc.spotifyclient.screens.home.HomeScreen;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

    void inject(App application);

}
