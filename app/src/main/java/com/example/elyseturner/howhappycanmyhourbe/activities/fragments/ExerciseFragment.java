package com.example.elyseturner.howhappycanmyhourbe.activities.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elyseturner.howhappycanmyhourbe.R;

/**
 * Created by elyseturner on 12/9/14.
 */
public class ExerciseFragment extends Fragment {

    public ExerciseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise, container, false);
        return rootView;
    }
}


