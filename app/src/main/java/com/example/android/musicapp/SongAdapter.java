package com.example.android.musicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * SongAdapter is an ArrayAdapter to provide the layout for ListView, which contains
 * a list of {@link Song} objects.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the {@link Song} object located at current position
        Song currentSong = getItem(position);

        // Checks if the view is being reused, otherwise inflate
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }

        // Find Song TextView and sets the text to current Song object
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);
        songTextView.setText(currentSong.getSong());

        // Find Album TextView and sets the text to current Album object
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_text_view);
        albumTextView.setText(currentSong.getAlbum());

        // Find Artist TextView and sets the text to current Artist object
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        artistTextView.setText(currentSong.getArtist());

        // Return the whole list_item layout
        return listItemView;
    }
}
