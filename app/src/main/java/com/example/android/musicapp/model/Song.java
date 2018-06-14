package com.example.android.musicapp.model;

/**
 * Custom class for songs.
 */
public class Song {

    private String mSong;

    private String mAlbum;

    private String mArtist;

    public Song(String song, String album, String artist) {
        mSong = song;
        mAlbum = album;
        mArtist = artist;
    }

    public String getSong() {
        return mSong;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public String getArtist() {
        return mArtist;
    }
}
