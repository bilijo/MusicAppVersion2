package com.example.android.musicappversion2;

/**
 * Created by dam on 30.05.2017.
 */


    /*
    * Create a Song object.    *
    * @param vSongName is the name of the Song track
    * @param image is drawable reference ID that may illustrate the song
    * */
public class Song {
    private String mSongName;
    private int mSongImageRessource;

// constructor
    public Song(String vSongName, int vImageRessource){
        mSongName = vSongName;
        mSongImageRessource = vImageRessource;
    }

    public String getSongName(){
        return mSongName;
    }

    public int getSongImageRessource() {
        return mSongImageRessource;
    }
}
