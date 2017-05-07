package jc.spotifyclient.network;

import io.reactivex.Observable;
import jc.spotifyclient.network.models.GetAlbumsResponse;
import retrofit2.http.GET;

public interface SpotifyServices {

    @GET("/v1/search?q=ten&type=album")
    Observable<GetAlbumsResponse> getAlbums();

}
