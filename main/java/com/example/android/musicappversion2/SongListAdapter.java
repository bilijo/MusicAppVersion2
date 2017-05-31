package com.example.android.musicappversion2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dam on 30.05.2017.
 */

public class SongListAdapter extends ArrayAdapter<Song>{
    private int mColorResourceId;

    public SongListAdapter(Activity context, List<Song> item,int colorResourceId ) {
        super(context, 0, item);
        mColorResourceId = colorResourceId;
    }

    public View getView(int position, View convertView,  @NonNull ViewGroup parent){

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_params, parent, false);

        }

        // Get the {@link Artist} object located at this position in the list
        Song currentSongName = getItem(position);

        // Find the TextView in the artist_params.xml layout with the ID version_name
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_name);

        // Get the version name from the current Artist object and
        // set this text on the name TextView
        songTextView.setText(currentSongName.getSongName());

        // Find the ImageView in the artist_params.xmlml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_song_icon);

        // Get the image resource ID from the current Artist object and
        // set the image to iconView
        iconView.setImageResource(currentSongName.getSongImageRessource());

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        songTextView.setBackgroundColor(color);


        // Return the whole list item layout (containing a TextView and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
