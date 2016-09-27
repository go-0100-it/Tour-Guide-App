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

public class GardensParksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardens_parks);

        /*
        creating instance of the Amusement Object Class
         */
        final ArrayList<AmusementsObject> amusementObjectArrayList = new ArrayList<AmusementsObject>();

        /*
        declaring and initializing the TypedArray and String[] variables for the arrays
         */
        TypedArray gardensParksImageAList = getResources().obtainTypedArray(R.array.gardens_parks_images_a);
        TypedArray gardensParksImageBList = getResources().obtainTypedArray(R.array.gardens_parks_images_b);

        String[] gardensParksTitleList = getResources().getStringArray(R.array.gardens_parks_list);
        String[] gardensParksDetailsList = getResources().getStringArray(R.array.gardens_parks_details_list);
        String[] gardensParksWebsiteList = getResources().getStringArray(R.array.gardens_parks_website_list);

        /*
        looping through the arrays to create an Amusement object array.
         */
        for(int a = 0;a < gardensParksTitleList.length;a++){
            amusementObjectArrayList.add(new AmusementsObject(gardensParksImageAList.getResourceId(a, -1), gardensParksImageBList.getResourceId(a, -1),
                    gardensParksTitleList[a], gardensParksDetailsList[a], Uri.parse(gardensParksWebsiteList[a])));
        }

        /*
        recycling the TypedArrays to be a good citizen... ;)
         */
        gardensParksImageAList.recycle();
        gardensParksImageBList.recycle();

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
