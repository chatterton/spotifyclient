package jc.spotifyclient.state;

import org.immutables.value.Value;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import jc.spotifyclient.framework.Scheduler;
import jc.spotifyclient.network.SpotifyServices;
import jc.spotifyclient.network.models.GetAlbumsResponse;

@Singleton
public class AlbumSearchState {

    final SpotifyServices spotify;
    final Scheduler scheduler;
    final AlbumSearchHelper albumSearchHelper;
    final PublishSubject<Album> albumSubject = PublishSubject.create();

    String query;

    @Inject
    public AlbumSearchState(SpotifyServices services, Scheduler scheduler, AlbumSearchHelper helper) {
        this.spotify = services;
        this.scheduler = scheduler;
        this.albumSearchHelper = helper;
    }

    @Value.Immutable
    public interface Album {
        String getTitle();
        String getArtist();
    }

    public void search(String q) {
        this.query = q;
        spotify.getAlbums()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.computation())
                .flatMap(new Function<GetAlbumsResponse, Observable<Album>>() {
                    @Override
                    public Observable<Album> apply(@NonNull GetAlbumsResponse getAlbumsResponse) throws Exception {
                        return Observable.fromIterable(albumSearchHelper.albumListFromResponse(getAlbumsResponse));
                    }
                })
                .subscribe(albumSubject);
    }

    public void loadMore() {

    }

    public Observable<Album> getAlbumUiObservable() {
        return albumSubject.hide()
                .subscribeOn(scheduler.computation())
                .observeOn(scheduler.ui());
    }

}
