package jc.spotifyclient.di;

import javax.inject.Singleton;

import dagger.Component;
import jc.spotifyclient.App;
import jc.spotifyclient.screens.HomeScreenActivity;

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ActivityComponent {

    void inject(App application);

    void inject(HomeScreenActivity activity);

}
