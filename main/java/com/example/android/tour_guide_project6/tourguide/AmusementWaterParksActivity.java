package com.example.android.tour_guide_project6.tourguide;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AmusementWaterParksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amusement_water_parks);

        /*
        creating instance of the Amusement Object Class
         */
        final ArrayList<AmusementsObject> amusementObjectArrayList = new ArrayList<AmusementsObject>();

        /*
        declaring and initializing the TypedArray and String[] variables for the arrays
         */
        TypedArray amusementWaterParkImageAList = getResources().obtainTypedArray(R.array.amusement_water_parks_images_a);
        TypedArray amusemetnWaterParkImageBList = getResources().obtainTypedArray(R.array.amusement_water_parks_images_b);

        String[] amusementWaterParkTitleList = getResources().getStringArray(R.array.amusement_water_parks_list);
        String[] amusementWaterParkDescriptionList = getResources().getStringArray(R.array.amusement_water_parks_details_list);
        String[] amusementWaterParkWebsiteList = getResources().getStringArray(R.array.amusement_water_parks_website_list);

        /*
        looping through the arrays to create an Amusement object array.
         */
        for(int a = 0;a < amusementWaterParkTitleList.length;a++){
            amusementObjectArrayList.add(new AmusementsObject(amusementWaterParkImageAList.getResourceId(a, -1), amusemetnWaterParkImageBList.getResourceId(a, -1),
                    amusementWaterParkTitleList[a], amusementWaterParkDescriptionList[a], Uri.parse(amusementWaterParkWebsiteList[a])));
        }

        /*
        recycling the TypedArrays to be a good citizen... ;)
         */
        amusementWaterParkImageAList.recycle();
        amusemetnWaterParkImageBList.recycle();

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
