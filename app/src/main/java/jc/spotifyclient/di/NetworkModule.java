package jc.spotifyclient.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jc.spotifyclient.network.SpotifyServices;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    public static final String BASE_URL = "https://api.spotify.com";

    @Singleton
    @Provides
    SpotifyServices provideVehicleServices() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build();
        return retrofit.create(SpotifyServices.class);
    }

}
