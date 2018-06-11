package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.musicapp.MainActivity.KEY_ALBUM;
import static com.example.android.musicapp.MainActivity.KEY_ARTIST;
import static com.example.android.musicapp.MainActivity.KEY_SONG;

/**
 * The Now Playing activity displays data from the clicked ListView item, along with a default ImageView
 * in place of album art. Play, fast forward, and rewind buttons are provided, as well as a volume seekBar.
 *
 * Sources:
 *
 * Icons: https://material.io/tools/icons/?style=baseline
 * Vinyl record image: Taken by Jack Hamilton on https://unsplash.com/photos/CMnNiQBkwBI
 */

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        String playingSong = "";
        String playingArtist = "";
        String playingAlbum = "";

        // Gets intent and ListView item data from MainActivity
        Intent intent = getIntent();
        if (null != intent) {
            playingSong = intent.getStringExtra(KEY_SONG);
            playingArtist = intent.getStringExtra(KEY_ARTIST);
            playingAlbum = intent.getStringExtra(KEY_ALBUM);
        }

        // Sets data to appropriate TextViews
        TextView playingSongText = (TextView) findViewById(R.id.playing_song);
        playingSongText.setText(playingSong);

        TextView playingAlbumText = (TextView) findViewById(R.id.playing_album);
        playingAlbumText.setText(playingAlbum);

        TextView playingArtistText = (TextView) findViewById(R.id.playing_artist);
        playingArtistText.setText(playingArtist);

        final ImageView playButton = (ImageView) findViewById(R.id.play_button);

        // Sets tag to switch ImageView between play and pause buttons when clicked.
        // Reference: https://stackoverflow.com/questions/32420565/android-changing-imageview-between-two-images-on-button-click-and-reclick
        playButton.setTag(1);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playButton.getTag().equals(1)) {
                    playButton.setImageResource(R.drawable.baseline_pause_black_48);
                    playButton.setTag(2);
                } else {
                    playButton.setImageResource(R.drawable.baseline_play_arrow_black_48);
                    playButton.setTag(1);
                }

            }
        });
        // End reference
    }

    // Adds up navigation to action bar for returning to MainActivity
    // Reference: https://developer.android.com/training/implementing-navigation/ancestral
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // End reference
}