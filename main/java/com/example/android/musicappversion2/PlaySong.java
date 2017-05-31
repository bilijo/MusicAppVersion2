package com.example.android.musicappversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlaySong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        // get intent from SongList
        Intent recupIntent = getIntent();
        String vSongName = recupIntent.getStringExtra("IntentSongName");

        // Create an instance of the View which would display the name of the Song
        TextView trackname = (TextView) findViewById(R.id.play_track);
        trackname.setText(vSongName);
    }
}
