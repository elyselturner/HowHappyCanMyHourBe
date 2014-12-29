package com.example.elyseturner.howhappycanmyhourbe.activities.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.elyseturner.howhappycanmyhourbe.activities.models.ExerciseModel;

import java.util.List;

/**
 * Created by elyseturner on 12/29/14.
 */
public class ExerciseAdapter extends ArrayAdapter<ExerciseModel>{
    private List <ExerciseModel> theInfoYouWanted;

    public ExerciseAdapter(Context context, int resource, List<ExerciseModel> objects) {
        super(context, resource, objects);
    }

    
}
