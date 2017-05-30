package com.example.android.musicappversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*********************************************************************
        // Find the View that shows the Classic Music category
        TextView classicButtonMenu = (TextView) findViewById(R.id.classic_button_view);


        // Set a click listener on that Classic View
        classicButtonMenu.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the Classic Music ButtonView is clicked on.
            @Override
            public void onClick (View view){
                Intent genreIntent = new Intent(MainActivity.this, ArtistList.class);
                String inName = ((TextView) view.findViewById(R.id.classic_button_view)).getText().toString();
                genreIntent.putExtra("genreMusic", inName);
                Log.d("MyActivity", "sendGenreIntent: " + inName);
                startActivity(genreIntent);
            }
        });

        //*********************************************************************
        // Find the View that shows the Jazz Music category
        TextView jazzButtonMenu = (TextView) findViewById(R.id.jazz_button_view);

        // Set a click listener on that Jazz View
        jazzButtonMenu.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the Classic Music ButtonView is clicked on.
            @Override
            public void onClick (View view){
                Intent genreIntent = new Intent(MainActivity.this, ArtistList.class);
                String inName = ((TextView) view.findViewById(R.id.jazz_button_view)).getText().toString();
                genreIntent.putExtra("genreMusic", inName);
                Log.d("MyActivity", "genreIntent: " + inName);

                startActivity(genreIntent);
            }
        });


    }

}
