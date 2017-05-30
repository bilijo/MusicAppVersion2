package com.example.android.musicappversion2;

/**
 * Created by dam on 30.05.2017.
 */

public class Song {
    private String mSongName;
    private int mSongImageRessource;

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
