package com.example.android.musicappversion2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.musicappversion2.R.id.textView;

public class SongList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        //change background color of the song list according to the music genre
        int categoryColor = 0;

        // Create an ArrayList of song object
        ArrayList<Song> songFromArtist = new ArrayList<>();

        // get intent from ArtisList
        Intent recupIntent = getIntent();
        String vArtistName = recupIntent.getStringExtra("IntentArtistName");
        Log.d("SongList", "IntentArtistName" + vArtistName);

        // check the name os the artist to display the corresponding song
        switch (vArtistName) {
            case "Beethoven":
                categoryColor = R.color.classicGenre;
                songFromArtist.add(new Song("Symphonie nº 09", R.drawable.ic_audiotrack_black_48dp));
                songFromArtist.add(new Song("Sonate pour piano nº 14 ", R.drawable.ic_audiotrack_black_48dp));

                break;
            case "Berlioz":
                categoryColor = R.color.classicGenre;
                songFromArtist.add(new Song("Symphonie fantastique", R.drawable.ic_audiotrack_black_48dp));
                songFromArtist.add(new Song("La Damnation de Faust", R.drawable.ic_audiotrack_black_48dp));

                break;
            case "Louis Armstrong":
                categoryColor = R.color.jazzGenre;
                songFromArtist.add(new Song("Hello, Dolly!", R.drawable.ic_audiotrack_black_48dp));
                songFromArtist.add(new Song("Blueberry Hill", R.drawable.ic_audiotrack_black_48dp));

                break;
            case "Benny Goodman":
                categoryColor = R.color.jazzGenre;
                songFromArtist.add(new Song("Sing Sing Sing", R.drawable.ic_audiotrack_black_48dp));
                songFromArtist.add(new Song("why don't you do right", R.drawable.ic_audiotrack_black_48dp));

                break;
            case "Jason Mraz":
                categoryColor = R.color.popGenre;
                songFromArtist.add(new Song("I Won't Give Up", R.drawable.ic_audiotrack_black_48dp));
                songFromArtist.add(new Song("Lucky", R.drawable.ic_audiotrack_black_48dp));

                break;
            case "Alain Souchon":
                categoryColor = R.color.popGenre;
                songFromArtist.add(new Song("J'ai dix ans", R.drawable.ic_audiotrack_black_48dp));
                songFromArtist.add(new Song("Jamais content", R.drawable.ic_audiotrack_black_48dp));

                break;
        }

        // param categoryColor pass the color of the category the song belongs to
        SongListAdapter songListAdapter = new SongListAdapter(this, songFromArtist, categoryColor);

        // Get a reference to the ListView which is in ----- activity_song_list.xml -----,
        // and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_song);

        // attach a clicklistener to song names and send an intent to the next activity --> PlaySong
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String inName = ((TextView) view.findViewById(R.id.song_name)).getText().toString();

                Intent songIntent = new Intent(SongList.this, PlaySong.class);
                songIntent.putExtra("IntentSongName", inName);

                ColorDrawable genreColor = (ColorDrawable) view.findViewById(R.id.song_name).getBackground();

                int colorCode = genreColor.getColor();

                songIntent.putExtra("IntentBkgColor", colorCode);

                // launch SongList activity once an Artist's name has been clicked
                startActivity(songIntent);

            }
        });

        listView.setAdapter(songListAdapter);

    }
}
