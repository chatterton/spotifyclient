package jc.spotify.spotifyclient.di;

import javax.inject.Singleton;

import dagger.Component;
import jc.spotify.spotifyclient.App;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

    void inject(App application);

}
