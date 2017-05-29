package com.example.android.musicappversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ManageList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_list);

        // Create an ArrayList of Artist objects
        ArrayList<Artist> GenreArtists = new ArrayList<>();

        // get param from ClassicMusic
        Intent recupIntent = getIntent();
        String vGenreName = recupIntent.getStringExtra("genreMusic");
        Log.d("ManageList", "genreMusic" + vGenreName);

        // check the name os the artist to display the corresponding album
        if (vGenreName.equals("Classic")){

            GenreArtists.add(new Artist("Beethoven", R.drawable.ic_play_arrow_black_48dp));
            GenreArtists.add(new Artist("Berlioz",  R.drawable.ic_play_arrow_black_48dp));

        }else if (vGenreName.equals("Jazz")){

            GenreArtists.add(new Artist("Louis Armstrong", R.drawable.ic_play_arrow_black_48dp));
            GenreArtists.add(new Artist("Benny Goodman",  R.drawable.ic_play_arrow_black_48dp));
        }


        // Create an {@link ArtistAdapter}, whose data source is a list of
        // {@link Artist}s. The adapter knows how to create list item views for each item
        // in the list.
        ListAdapter artistAdapter = new ListAdapter(this, GenreArtists);

        // Get a reference to the ListView which is in ----- activity_classic_music.xml -----, and attach the adapter to the listView.
        // ListView listView = (ListView) findViewById(R.id.listview_artist);
        ListView listView = (ListView) findViewById(R.id.listview_music);



    }
}
