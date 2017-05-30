package com.example.android.musicappversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_list);

        // Create an ArrayList of Artist objects
        ArrayList<Artist> genreArtists = new ArrayList<>();

        // get param from MainActivity
        Intent recupIntent = getIntent();
        String vGenreName = recupIntent.getStringExtra("genreMusic");
        Log.d("ArtistList", "getGenreMusic " + vGenreName);

        // check the name os the artist to display the corresponding album
        if (vGenreName.equals("Classic")){

            genreArtists.add(new Artist("Beethoven", R.drawable.ic_play_arrow_black_48dp));
            genreArtists.add(new Artist("Berlioz",  R.drawable.ic_play_arrow_black_48dp));

        }else if (vGenreName.equals("Jazz")){

            genreArtists.add(new Artist("Benny Goodman", R.drawable.ic_play_arrow_black_48dp));
            genreArtists.add(new Artist("Louis Armstrong",  R.drawable.ic_play_arrow_black_48dp));
        }


        // Create an {@link ArtistAdapter}, whose data source is a list of
        // {@link Artist}s. The adapter knows how to create list item views for each item
        // in the list.
        ArtistListAdapter artistListAdapter = new ArtistListAdapter(this, genreArtists);

        // Get a reference to the ListView which is in ----- activity_artist_list.xml -----, and attach the adapter to the listView.
        // ListView listView = (ListView) findViewById(R.id.listview_artist);
        ListView listView = (ListView) findViewById(R.id.listview_artist);

        // attach a clicklistener to artist names and send an intent to the next activity --> SongList
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String inName = ((TextView) view.findViewById(R.id.artist_name)).getText().toString();

                Intent artistIntent = new Intent(ArtistList.this, SongList.class);
                artistIntent.putExtra("IntentArtistName", inName);

                // launch SongList activity once an Artist's name has been clicked
                startActivity(artistIntent);

                }
        });


        listView.setAdapter(artistListAdapter);

    }
}
