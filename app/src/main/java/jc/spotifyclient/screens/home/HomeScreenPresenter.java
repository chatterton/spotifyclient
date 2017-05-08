package jc.spotifyclient.screens.home;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jc.spotifyclient.framework.BasePresenter;
import jc.spotifyclient.network.SpotifyServices;
import jc.spotifyclient.network.models.ImmutableGetAlbumsResponse;

@Singleton
public class HomeScreenPresenter extends BasePresenter<HomeScreen> {

    private int bindCount = 0;

    private final SpotifyServices spotify;

    @Inject
    public HomeScreenPresenter(SpotifyServices services) {
        spotify = services;
    }

    @Override
    public void bindView(HomeScreen view) {
        super.bindView(view);
        bindCount++;
        view.updateHelloText("Presenter bound: "+bindCount);
    }

    public void searchForText(String text) {
        spotify.getAlbums()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ImmutableGetAlbumsResponse>() {
                    @Override
                    public void accept(@NonNull ImmutableGetAlbumsResponse getAlbums) throws Exception {
                        Log.i("JC", "GOT THIS MANY ALBUMS: "+getAlbums.albums().items().size());
                    }
                });
    }

}
