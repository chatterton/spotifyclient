package jc.spotify.spotifyclient.di;

import javax.inject.Singleton;

import dagger.Component;
import jc.spotify.spotifyclient.App;
import jc.spotify.spotifyclient.screens.HomeScreenActivity;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ActivityComponent {

    void inject(App application);

    void inject(HomeScreenActivity activity);

}
