package jc.spotifyclient.network.models;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.List;

@Gson.TypeAdapters
@Value.Immutable
public abstract class GetAlbumsResponse {

    public abstract Albums albums();

    @Value.Immutable
    public abstract static class Albums {
        public abstract String href();
        public abstract List<Item> items();
    }

    @Value.Immutable
    public abstract static class Item {

    }

}
