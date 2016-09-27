package com.example.android.tour_guide_project6.tourguide;

import android.net.Uri;

/**
 * Created by WatersD on 7/15/2016.
 */
public class AmusementsObject {

    //First image view in layout, if possible will be company logo.
    int amusementObjectImageA;

    //Second image in layout, displays amusement activity.
    int amusementObjectImageB;

    //Name or Title of the amusement.
    String amusementObjectTitle;

    //Description of the amusement, ie. activity, times, places...
    String amusementObjectDesscription;

    //Web address of the amusement for gaining further details.
    Uri amusementObjectWebsite;

    /**
     * Constructs a new AmusementsObject with initial values for all variables
     */
   public AmusementsObject(int imageId_A, int imageId_B,String amusementActivityName,
                           String amusementActivityDescription, Uri amusementActivityWebsite){

       amusementObjectImageA = 0;
       amusementObjectImageB = 0;
       amusementObjectTitle = "";
       amusementObjectDesscription = "";
       amusementObjectWebsite = null;

       amusementObjectImageA = imageId_A;
       amusementObjectImageB = imageId_B;
       amusementObjectTitle = amusementActivityName;
       amusementObjectDesscription = amusementActivityDescription;
       amusementObjectWebsite = amusementActivityWebsite;
   }
    /**
     * Sets the logo image of the Amusement Object
     *
     * @param imageId is the name of the image file in the drawable folder
     */
    public void setAmusementObjectImageA(int imageId){
        amusementObjectImageA = imageId;
    }

    /**
     * Sets the activity image of the Amusement Object
     *
     * @param imageId is the name of the image file in the drawable folder
     */
    public void setAmusementObjectImageB(int imageId){
        amusementObjectImageB = imageId;
    }

    /**
     * Sets the title text of the Amusement Object
     *
     * @param title is the string resource of the inputted title.
     */
    public void setAmusementObjectTitle(String title){
        amusementObjectTitle = title;
    }

    /**
     * Sets the description text of the Amusement Object
     *
     * @param description is the string resource of the inputted description.
     */
    public void setAmusementObjectDescription(String description){
        amusementObjectDesscription = description;
    }

    /**
     * Sets the web address of the Amusement Object's website
     *
     * @param website is the string resource of the inputted web address.
     */
    public void setAmusementObjectWebsite(String website){
        amusementObjectWebsite = Uri.parse(website);
    }

    /**
     *
     * @return returns an int value for ImageA's resource id.
     */
    public int getAmusementObjectImageA(){

        return this.amusementObjectImageA;
    }

    /**
     *
     * @return returns an int value for ImageB's resource id.
     */
    public int getAmusementObjectImageB(){

        return this.amusementObjectImageB;
    }

    /**
     *
     * @return returns the Amusement Object title as a String value.
     */
    public String getAmusementObjectTitle(){

        return this.amusementObjectTitle;
    }

    /**
     *
     * @return returns the Amusement Object description as a String value.
     */
    public String getAmusementObjectDesscription(){

        return this.amusementObjectDesscription;
    }

    /**
     *
     * @return returns the Amusement Object's website Uri.
     */
    public Uri getAmusementObjectWebsite(){

        return this.amusementObjectWebsite;
    }
}
