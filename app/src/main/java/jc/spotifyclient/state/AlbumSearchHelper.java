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
        int count = 0;
        for (GetAlbumsResponse.Item item : response.albums().items()) {
            AlbumSearchState.Album album = ImmutableAlbum.builder()
                    .artist("testArtist"+count)
                    .title("testTitle"+count)
                    .build();
            albums.add(album);
            count++;
        }
        return albums;
    }
}
