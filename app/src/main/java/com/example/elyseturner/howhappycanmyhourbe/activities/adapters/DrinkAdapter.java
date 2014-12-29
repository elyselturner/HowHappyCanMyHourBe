package com.example.elyseturner.howhappycanmyhourbe.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.elyseturner.howhappycanmyhourbe.R;
import com.example.elyseturner.howhappycanmyhourbe.activities.models.DrinkModel;

import java.util.List;

/**
 * Created by elyseturner on 12/29/14.
 */
public class DrinkAdapter extends ArrayAdapter<DrinkModel> {
    private List<DrinkModel> theInfoYouWanted;

    public DrinkAdapter(Context context, int resource,List<DrinkModel> theInfoYouWanted) {
        super(context, resource, theInfoYouWanted);

        this.theInfoYouWanted = theInfoYouWanted;
    }


    @Override public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
        return getCustomView(position, cnvtView, prnt); }

    @Override public View getView(int pos, View cnvtView, ViewGroup prnt) {
        return getCustomView(pos, cnvtView, prnt); }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View customRow = inflater.inflate(R.layout.custom_spinner_drink_row, parent, false);

        TextView fragment_exercise_time_drink = (TextView) customRow.findViewById(R.id.text_workout);
        fragment_exercise_time_drink.setText(theInfoYouWanted.get(position).getName());


        return customRow; }


}



