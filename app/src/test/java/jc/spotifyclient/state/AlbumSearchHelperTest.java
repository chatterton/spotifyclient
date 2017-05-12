package jc.spotifyclient.state;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import jc.spotifyclient.network.models.*;
import jc.spotifyclient.network.models.ImmutableAlbum;

public class AlbumSearchHelperTest {

    AlbumSearchHelper unitUnderTest;

    @Before
    public void before() {
        unitUnderTest = new AlbumSearchHelper();
    }

    @Test
    public void testResponseDataMarshalled() {
        GetAlbumsResponse.Artist artist1 = ImmutableArtist.builder()
                .name("artist1")
                .build();
        GetAlbumsResponse.Album album1 = ImmutableAlbum.builder()
                .addArtists(artist1)
                .name("album1")
                .build();
        GetAlbumsResponse.Artist artist2 = ImmutableArtist.builder()
                .name("artistX")
                .build();
        GetAlbumsResponse.Artist artist3 = ImmutableArtist.builder()
                .name("artist3")
                .build();
        GetAlbumsResponse.Album album2 = ImmutableAlbum.builder()
                .addArtists(artist2, artist3)
                .name("album2")
                .build();
        GetAlbumsResponse.Albums albums = ImmutableAlbums.builder()
                .addItems(album1, album2)
                .href("foo")
                .build();
        GetAlbumsResponse check = ImmutableGetAlbumsResponse.builder()
                .albums(albums)
                .build();
        List<AlbumSearchState.Album> result = unitUnderTest.albumListFromResponse(check);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("artist1", result.get(0).getArtist());
        Assert.assertEquals("album1", result.get(0).getTitle());
        Assert.assertEquals("artistX", result.get(1).getArtist());
        Assert.assertEquals("album2", result.get(1).getTitle());
    }

}
