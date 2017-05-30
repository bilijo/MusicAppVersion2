package com.example.android.musicappversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PlaySong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        // get intent from ArtisList
        Intent recupIntent = getIntent();
        String vSongName = recupIntent.getStringExtra("IntentSongName");
        Log.d("SongList", "IntentSongName " + vSongName);

        TextView trackname = (TextView) findViewById(R.id.play_track);

        trackname.setText(vSongName);
    }
}
