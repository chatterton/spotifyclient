package jc.spotifyclient.di;

import javax.inject.Singleton;

import dagger.Component;
import jc.spotifyclient.screens.home.HomeScreenActivity;

@Singleton
@Component(modules = { ApplicationModule.class, NetworkModule.class })
public interface ActivityComponent {

    void inject(HomeScreenActivity screen);

}
