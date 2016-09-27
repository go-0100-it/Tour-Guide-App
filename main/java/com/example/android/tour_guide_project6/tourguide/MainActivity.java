package com.example.android.tour_guide_project6.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout buttonLayout;
    ScrollView scroll;
    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         /*
        creating variable for intro textview
         */
        TextView introText = (TextView)findViewById(R.id.intro_text);

        /*
        creating variables for buttons
         */
        Button amusementWaterParksButton = (Button)findViewById(R.id.amusement_water_parks_button);
        Button festivalsEventsButton = (Button)findViewById(R.id.festivals_events_button);
        Button gardensParksButton = (Button)findViewById(R.id.gardens_parks_button);
        Button landmarksHistoricalSitesButton = (Button)findViewById(R.id.land_marks_historical_sites_button);
        Button artScienceMuseums = (Button)findViewById(R.id.arts_science_museums);

        /*
        creating variables for layouts
         */
        buttonLayout = (LinearLayout)findViewById(R.id.button_layout);
        scroll = (ScrollView)findViewById(R.id.scroll);
        frame = (FrameLayout)findViewById(R.id.frame);

        /*
        setting all onClick listeners
         */
        introText.setOnClickListener(this);
        amusementWaterParksButton.setOnClickListener(this);
        festivalsEventsButton.setOnClickListener(this) ;
        gardensParksButton.setOnClickListener(this) ;
        landmarksHistoricalSitesButton.setOnClickListener(this) ;
        artScienceMuseums.setOnClickListener(this) ;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intro_text:
                if(buttonLayout.getVisibility()== View.GONE ){
                    buttonLayout.setVisibility(View.VISIBLE);
                    frame.setVisibility(View.VISIBLE);
                    scroll.post(new Runnable() {
                        @Override
                        public void run() {

                            scroll.smoothScrollTo(0, scroll.getBottom());
                        }
                    });
                }else{
                    buttonLayout.setVisibility(View.GONE);
                    frame.setVisibility(View.GONE);
                }
                break;
            case R.id.amusement_water_parks_button:
                startActivity(new Intent(MainActivity.this, AmusementWaterParksActivity.class));
                break;
            case R.id.festivals_events_button:
                startActivity(new Intent(MainActivity.this, FestivalEventsActivity.class));
                break;
            case R.id.gardens_parks_button:
                startActivity(new Intent(MainActivity.this, GardensParksActivity.class));
                break;
            case R.id.land_marks_historical_sites_button:
                startActivity(new Intent(MainActivity.this, LandmarksHistoricalSitesActivity.class));
                break;
            case R.id.arts_science_museums:
                startActivity(new Intent(MainActivity.this, ArtScienceMuseumsActivity.class));
                break;
        }
    }
}
