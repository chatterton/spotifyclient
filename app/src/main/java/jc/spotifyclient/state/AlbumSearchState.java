package jc.spotifyclient.state;

import org.immutables.value.Value;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import jc.spotifyclient.framework.Scheduler;
import jc.spotifyclient.network.SpotifyServices;
import jc.spotifyclient.network.models.ImmutableGetAlbumsResponse;

@Singleton
public class AlbumSearchState {

    final SpotifyServices spotify;
    final Scheduler scheduler;

    PublishSubject<Album> albumSubject = PublishSubject.create();

    String query;

    @Inject
    public AlbumSearchState(SpotifyServices services, Scheduler scheduler) {
        this.spotify = services;
        this.scheduler = scheduler;
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
                .subscribe(new Consumer<ImmutableGetAlbumsResponse>() {
                    @Override
                    public void accept(@NonNull ImmutableGetAlbumsResponse immutableGetAlbumsResponse) throws Exception {
                        int count = 0;
                        for (ImmutableGetAlbumsResponse.Item item : immutableGetAlbumsResponse.albums().items()) {
                            Album album = ImmutableAlbum.builder()
                                    .artist("testArtist"+count)
                                    .title("testTitle"+count)
                                    .build();
                            albumSubject.onNext(album);
                            count++;
                        }
                    }
                });
    }

    public void loadMore() {

    }

    public Observable<Album> getAlbumUiObservable() {
        return albumSubject.hide()
                .subscribeOn(scheduler.computation())
                .observeOn(scheduler.ui());
    }

}
