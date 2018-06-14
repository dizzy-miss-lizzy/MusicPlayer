package com.example.android.musicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.musicapp.model.Song;

import java.util.ArrayList;

/**
 * SongAdapter is an ArrayAdapter to provide the layout for ListView, which contains
 * a list of {@link Song} objects.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    // Class to hold ArrayList Views.
    // Reference: https://dzone.com/articles/optimizing-your-listview
    static class ViewHolder {
        private TextView songTextView;
        private TextView albumTextView;
        private TextView artistTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the {@link Song} object located at current position
        Song currentSong = getItem(position);

        ViewHolder holder;

        // Checks if the view is being reused, otherwise inflate
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
            holder = new ViewHolder();
            // Finds Song, Album, and Artist TextViews
            holder.songTextView = (TextView) convertView.findViewById(R.id.song_text_view);
            holder.albumTextView = (TextView) convertView.findViewById(R.id.album_text_view);
            holder.artistTextView = (TextView) convertView.findViewById(R.id.artist_text_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Sets the text to current Song object
        holder.songTextView.setText(currentSong.getSong());

        // Sets the text to current Album object
        holder.albumTextView.setText(currentSong.getAlbum());

        // Sets the text to current Artist object
        holder.artistTextView.setText(currentSong.getArtist());
        // End reference

        // Return the whole list_item layout
        return convertView;
    }
}
