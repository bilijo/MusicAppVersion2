package com.example.android.musicappversion2;

/**
 * Created by dam on 29.05.2017.
 */

public class Artist {

    // Name of the Artist(e.g. Mozart, Berlioz, Chopin)
    private String mArtistName;

    // Drawable resource ID ie pictures, icone
    private int mImageResourceId;

    /*
    * Create a new Artist object.    *
    * @param vName is the name of the Artist(e.g. Bach)
    * @param image is drawable reference ID that corresponds to the Artist
    * */
    public Artist(String vName,  int imageResourceId)
    {
        mArtistName = vName;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the Artist
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


}