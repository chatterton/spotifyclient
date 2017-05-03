package jc.spotify.spotifyclient.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jc.spotify.spotifyclient.App;

@Module
public class ApplicationModule {

    private final App application;

    public ApplicationModule(App a) {
        this.application = a;
    }

    @Provides
    @Singleton
    App provideApplication() {
        return application;
    }

}