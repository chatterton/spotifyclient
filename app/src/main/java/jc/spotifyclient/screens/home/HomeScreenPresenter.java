package jc.spotifyclient.screens.home;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import jc.spotifyclient.framework.BasePresenter;
import jc.spotifyclient.state.AlbumSearchState;

@Singleton
public class HomeScreenPresenter extends BasePresenter<HomeScreen> {

    private int bindCount = 0;

    private AlbumSearchState albumSearchState;

    @Inject
    public HomeScreenPresenter(AlbumSearchState searchState) {
        albumSearchState = searchState;
    }

    @Override
    public void bindView(HomeScreen view) {
        super.bindView(view);
        bindCount++;
        view.updateHelloText("Presenter bound: "+bindCount);
    }

    public void searchForText(String text) {
        albumSearchState.getAlbumUiObservable()
                .subscribe(new Consumer<AlbumSearchState.Album>() {
                    @Override
                    public void accept(@NonNull AlbumSearchState.Album album) throws Exception {
                        Log.i("JC", "got album: "+album.getArtist() + " -- "+album.getTitle());
                    }
                });
        albumSearchState.search(text);
    }

}
