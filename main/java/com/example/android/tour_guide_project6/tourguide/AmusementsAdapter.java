package com.example.android.tour_guide_project6.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by WatersD on 7/18/2016.
 */
public class AmusementsAdapter extends ArrayAdapter<AmusementsObject> {

    private static final String LOG_TAG = AmusementsAdapter.class.getSimpleName();

    public AmusementsAdapter(Context context, List<AmusementsObject> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);

            /*
            Using a view holder class so that it is only necessary to use find view by id when view is inflated.
             */
            viewHolder = new ViewHolder();

            viewHolder.imageA = (ImageView) listItemView.findViewById(R.id.image_view_a);
            viewHolder.imageB = (ImageView) listItemView.findViewById(R.id.image_view_b);
            viewHolder.titleText = (TextView) listItemView.findViewById(R.id.title_text_view);
            viewHolder.descriptionText = (TextView) listItemView.findViewById(R.id.description_text_view);

            /*
            setting a tag to the view for future reference instead of using find view by id each time.
             */
            listItemView.setTag(viewHolder);
        }else{
            /*
            here the tag is used to reference the view if it has already been inflated and a tag set to the holder.
             */
            viewHolder = (ViewHolder) listItemView.getTag();
        }

        AmusementsObject currentAmusementObject = getItem(position);

        if(currentAmusementObject != null) {
            viewHolder.imageA.setImageResource(currentAmusementObject.getAmusementObjectImageA());
            viewHolder.imageB.setImageResource(currentAmusementObject.getAmusementObjectImageB());
            viewHolder.titleText.setText(currentAmusementObject.getAmusementObjectTitle());
            viewHolder.descriptionText.setText(currentAmusementObject.getAmusementObjectDesscription());
        }
        return listItemView;
    }
    static class ViewHolder {
        ImageView imageA;
        ImageView imageB;
        TextView titleText;
        TextView descriptionText;
    }
}
