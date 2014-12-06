package com.example.elyseturner.howhappycanmyhourbe.activities.fragments;

/**
 * Created by elyseturner on 12/4/14.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elyseturner.howhappycanmyhourbe.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExerciseChoicesFragment extends Fragment {

    public ExerciseChoicesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise_choice, container, false);
        return rootView;
    }

}