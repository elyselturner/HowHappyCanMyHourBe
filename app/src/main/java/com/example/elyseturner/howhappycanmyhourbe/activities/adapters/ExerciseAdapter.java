package com.example.elyseturner.howhappycanmyhourbe.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.elyseturner.howhappycanmyhourbe.R;
import com.example.elyseturner.howhappycanmyhourbe.activities.models.ExerciseModel;

import java.util.ArrayList;

/**
 * Created by elyseturner on 12/29/14.
 */
public class ExerciseAdapter extends ArrayAdapter<ExerciseModel>{
    private ArrayList<ExerciseModel> theInfoYouWanted;

    public ExerciseAdapter (Context context, int resource,ArrayList<ExerciseModel> theInfoYouWanted) {
        super(context, resource, theInfoYouWanted);

        this.theInfoYouWanted = theInfoYouWanted;
    }


    @Override public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
        return getCustomView(position, cnvtView, prnt); }

    @Override public View getView(int pos, View cnvtView, ViewGroup prnt) {
        return getCustomView(pos, cnvtView, prnt); }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View customRow = inflater.inflate(R.layout.custom_spinner_exercise_row, parent, false);

        TextView fragment_exercise_time_drink = (TextView) customRow.findViewById(R.id.text_workout);
        fragment_exercise_time_drink.setText(theInfoYouWanted.get(position).getName());

        TextView exerciseCalsTextView = (TextView) customRow.findViewById(R.id.text_exercise_cals);
        exerciseCalsTextView.setText((theInfoYouWanted.get(position).getCalories()) + " calories burned per minute");
        return customRow; }

}

