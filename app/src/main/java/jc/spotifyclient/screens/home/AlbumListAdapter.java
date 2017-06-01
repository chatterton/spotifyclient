package jc.spotifyclient.screens.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jc.spotifyclient.R;

public class AlbumListAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.album_item_coverimage) ImageView coverImage;
        @BindView(R.id.album_item_artist) TextView artist;
        @BindView(R.id.album_item_title) TextView title;

        public AlbumViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
