package com.example.android.tour_guide_project6.tourguide;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtScienceMuseumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_science_museums);

         /*
        creating instance of the Amusement Object Class
         */
        final ArrayList<AmusementsObject> amusementObjectArrayList = new ArrayList<AmusementsObject>();

        /*
        declaring and initializing the TypedArray and String[] variables for the arrays
         */
        TypedArray artScienceMuseumsImageAList = getResources().obtainTypedArray(R.array.arts_science_museums_images_a);
        TypedArray artScienceMuseumsImageBList = getResources().obtainTypedArray(R.array.arts_science_museums_images_b);

        String[] artScienceMuseumsTitleList = getResources().getStringArray(R.array.arts_science_museums_list);
        String[] artScienceMuseumsDescriptionList = getResources().getStringArray(R.array.arts_science_museums_details_list);
        String[] artScienceMuseumsWebsiteList = getResources().getStringArray(R.array.arts_science_museums_website_list);

        /*
        looping through the arrays to create an Amusement object array.
         */
        for(int a = 0;a < artScienceMuseumsTitleList.length;a++){
            amusementObjectArrayList.add(new AmusementsObject(artScienceMuseumsImageAList.getResourceId(a, -1), artScienceMuseumsImageBList.getResourceId(a, -1),
                    artScienceMuseumsTitleList[a], artScienceMuseumsDescriptionList[a], Uri.parse(artScienceMuseumsWebsiteList[a])));
        }

        /*
        recycling the TypedArrays to be a good citizen... ;)
         */
        artScienceMuseumsImageAList.recycle();
        artScienceMuseumsImageBList.recycle();

        final AmusementsAdapter amusementsAdapter = new AmusementsAdapter(this, amusementObjectArrayList);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(amusementsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            /*
            opening a browser for the Uri of the amusement selected by the user in the list
             */
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Intent.ACTION_VIEW, amusementObjectArrayList.get(position).amusementObjectWebsite));
            }
        });
    }
}
