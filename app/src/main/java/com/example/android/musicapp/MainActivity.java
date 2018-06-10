package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This app is a simple music player that displays a list of songs. The user can click on a ListView item
 * and a new activity will open, displaying the currently playing song.
 *
 * Sources:
 *
 * Icons: https://material.io/tools/icons/?style=baseline
 * Reference for passing data to NowPlayingActivity: http://stacktips.com/tutorials/android/pass-a-data-from-one-activity-to-another-in-android
 */

public class MainActivity extends AppCompatActivity {

    // Creates keys for ListView item data
    public static final String KEY_SONG = "KEY_SONG";
    public static final String KEY_ARTIST = "KEY_ARTIST";
    public static final String KEY_ALBUM = "KEY_ALBUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Creates a list of songs, albums, and artists
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Starman", "The Rise and Fall of Ziggy Stardust and the Spiders from Mars", "David Bowie"));
        songs.add(new Song("I Saw Her Standing There", "Please Please Me", "The Beatles"));
        songs.add(new Song("Don't Stop Believin'", "Escape", "Journey"));
        songs.add(new Song("Too Much Heaven", "Spirits Have Flown", "Bee Gees"));
        songs.add(new Song("Take On Me", "Hunting High and Low", "a-ha"));
        songs.add(new Song("Life On Mars?", "Hunky Dory", "David Bowie"));
        songs.add(new Song("More Than a Feeling", "Boston", "Boston"));
        songs.add(new Song("While My Guitar Gently Weeps", "The Beatles (White Album)", "The Beatles"));
        songs.add(new Song("Barracuda", "Little Queen", "Heart"));
        songs.add(new Song("Hit Me With Your Best Shot", "Crimes of Passion", "Pat Benetar"));
        songs.add(new Song("Tom Sawyer", "Moving Pictures", "Rush"));

        final SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        // When listView item is clicked, item data is sent to new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song item = (Song) adapter.getItem(position);
                Intent nowPlaying = new Intent(getApplicationContext(), NowPlayingActivity.class);
                nowPlaying.putExtra(KEY_SONG, item.getSong());
                nowPlaying.putExtra(KEY_ALBUM, item.getAlbum());
                nowPlaying.putExtra(KEY_ARTIST, item.getArtist());
                startActivity(nowPlaying);
            }
        });
    }
}