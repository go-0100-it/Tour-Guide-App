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

public class FestivalEventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival__events_);

        /*
        creating instance of the Amusement Object Class
         */
        final ArrayList<AmusementsObject> amusementObjectArrayList = new ArrayList<AmusementsObject>();

        /*
        declaring and initializing the TypedArray and String[] variables for the arrays
         */
        TypedArray festivalsEventsImageAList = getResources().obtainTypedArray(R.array.festivals_events_images_a);
        TypedArray festivalsEventsImageBList = getResources().obtainTypedArray(R.array.festivals_events_images_b);

        String[] festivalsEventsTitleList = getResources().getStringArray(R.array.festivals_events_list);
        String[] festivalsEventsDetailsList = getResources().getStringArray(R.array.festivals_events_details_list);
        String[] festivalsEventsWebsiteList = getResources().getStringArray(R.array.festivals_events_website_list);

        /*
        looping through the arrays to create an Amusement object array.
         */
        for(int a = 0;a < festivalsEventsTitleList.length;a++){
            amusementObjectArrayList.add(new AmusementsObject(festivalsEventsImageAList.getResourceId(a, -1), festivalsEventsImageBList.getResourceId(a, -1),
                    festivalsEventsTitleList[a], festivalsEventsDetailsList[a], Uri.parse(festivalsEventsWebsiteList[a])));
        }

        /*
        recycling the TypedArrays to be a good citizen... ;)
         */
        festivalsEventsImageAList.recycle();
        festivalsEventsImageBList.recycle();

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
