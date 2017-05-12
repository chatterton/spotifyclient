package jc.spotifyclient.state;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jc.spotifyclient.network.models.GetAlbumsResponse;

public class AlbumSearchHelper {

    @Inject
    public AlbumSearchHelper() { }

    public List<AlbumSearchState.Album> albumListFromResponse(GetAlbumsResponse response) {
        ArrayList<AlbumSearchState.Album> albums = new ArrayList<>();
        for (GetAlbumsResponse.Album album : response.albums().items()) {
            AlbumSearchState.Album a = ImmutableAlbum.builder()
                    .artist(album.artists().get(0).name())
                    .title(album.name())
                    .build();
            albums.add(a);
        }
        return albums;
    }
}
