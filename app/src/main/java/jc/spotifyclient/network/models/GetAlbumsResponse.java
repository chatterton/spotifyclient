package jc.spotifyclient.network.models;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.List;

@Gson.TypeAdapters
@Value.Immutable
public interface GetAlbumsResponse {

    Albums albums();

    @Value.Immutable
    interface Albums {
        String href();
        List<Album> items();
    }

    @Value.Immutable
    interface Album {
        List<Artist> artists();
        String name();
    }

    @Value.Immutable
    interface Artist {
        String name();
    }

}
