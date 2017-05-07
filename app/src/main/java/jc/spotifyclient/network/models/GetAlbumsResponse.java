package jc.spotifyclient.network.models;

import java.util.List;

public class GetAlbumsResponse {

    Album albums;

    public static class Album {
        String href;
        List<Item> items;
    }

    public static class Item {

    }

    public int getAlbumCount() {
        if (null != albums && null != albums.items) {
            return albums.items.size();
        }
        return -1;
    }

}
