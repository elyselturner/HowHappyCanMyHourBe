package com.example.elyseturner.howhappycanmyhourbe.activities.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.elyseturner.howhappycanmyhourbe.R;
import com.example.elyseturner.howhappycanmyhourbe.activities.adapters.DrinkAdapter;
import com.example.elyseturner.howhappycanmyhourbe.activities.adapters.ExerciseAdapter;
import com.example.elyseturner.howhappycanmyhourbe.activities.interfaces.ApiCallBack;
import com.example.elyseturner.howhappycanmyhourbe.activities.models.DrinkModel;
import com.example.elyseturner.howhappycanmyhourbe.activities.models.ExerciseModel;
import com.example.elyseturner.howhappycanmyhourbe.activities.parsers.DrinkParser;
import com.example.elyseturner.howhappycanmyhourbe.activities.parsers.ExerciseParser;
import com.example.elyseturner.howhappycanmyhourbe.activities.requests.DrinkApiRequest;
import com.example.elyseturner.howhappycanmyhourbe.activities.requests.ExerciseApiRequest;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elyseturner on 12/9/14.
 */
public class ExerciseTimeDrinkFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise_time_drink, container, false);
        return rootView;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addExerciseToSpinner(view);
        addTimeToSpinner(view);
        addDrinkToSpinner(view);


    }

    public void addExerciseToSpinner(View rootView) {

        ArrayList<ExerciseModel> theInfoYouWanted = new ArrayList<ExerciseModel>();

        final ExerciseAdapter adapter = new ExerciseAdapter(getActivity(), R.layout.custom_spinner_exercise_row, theInfoYouWanted);


        new ExerciseApiRequest(new ApiCallBack() {
            @Override
            public void onSuccess(String resultsString) {

                List<ExerciseModel> theInfoYouWanted = new ExerciseParser().parsePostingFromJsonString(resultsString);
                Log.d(ExerciseTimeDrinkFragment.class.getName(), theInfoYouWanted.toString());
                adapter.addAll(theInfoYouWanted);

            }

            @Override
            public void onFailure() {

            }
        }).execute();

        Spinner spinnerExercise = (Spinner) rootView.findViewById(R.id.exercise_choice);


        spinnerExercise.setAdapter(adapter);


        spinnerExercise.setOnItemSelectedListener(this);
    }


    public void addTimeToSpinner(View rootView) {

        Spinner spinnerTime = (Spinner) rootView.findViewById(R.id.time_choice);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.time_choices, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTime.setAdapter(adapter);

        spinnerTime.setOnItemSelectedListener(this);
    }

    public void addDrinkToSpinner(final View rootView) {
        ArrayList<DrinkModel> theInfoYouWanted = new ArrayList<DrinkModel>();

        final DrinkAdapter adapter = new DrinkAdapter(getActivity(), R.layout.custom_spinner_drink_row, theInfoYouWanted);


        new DrinkApiRequest(new ApiCallBack() {
            @Override
            public void onSuccess(String resultsString) {

                List<DrinkModel> theInfoYouWanted = new DrinkParser().parsePostingFromJsonString(resultsString);
                Log.d(ExerciseTimeDrinkFragment.class.getName(), theInfoYouWanted.toString());
                adapter.addAll(theInfoYouWanted);

                FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
                fab.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFailure() {


            }
        }).execute();

        Spinner spinnerDrink = (Spinner) rootView.findViewById(R.id.drink_choice);

        spinnerDrink.setAdapter(adapter);

        spinnerDrink.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, final View view, int position, long id) {
        String itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}



