package jc.spotifyclient.di;

import javax.inject.Singleton;

import dagger.Component;
import jc.spotifyclient.App;
import jc.spotifyclient.screens.home.HomeScreen;
import jc.spotifyclient.screens.home.HomeScreenActivity;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ActivityComponent {

    void inject(HomeScreenActivity screen);

}
