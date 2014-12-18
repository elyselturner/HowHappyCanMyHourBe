package com.example.elyseturner.howhappycanmyhourbe.activities.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.elyseturner.howhappycanmyhourbe.R;
import com.example.elyseturner.howhappycanmyhourbe.activities.interfaces.ApiCallBack;
import com.example.elyseturner.howhappycanmyhourbe.activities.requests.ExerciseApiRequest;

/**
 * Created by elyseturner on 12/9/14.
 */
public class ExerciseTimeDrinkFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    private Spinner spinnerExercise;
    private Spinner spinnerTime;
    private Spinner spinnerDrink;
    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
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

    public void  addExerciseToSpinner(View rootView){

        new ExerciseApiRequest(new ApiCallBack() {
            @Override
            public void onSuccess(String resultsString) {

            }

            @Override
            public void onFailure() {

            }
        }).execute();

        Spinner spinnerExercise = (Spinner) rootView.findViewById(R.id.exercise_choice);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.exercise_choices, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerExercise.setAdapter(adapter);

        spinnerExercise.setOnItemSelectedListener(this);
    }

    public void  addTimeToSpinner(View rootView){

        Spinner spinnerTime = (Spinner) rootView.findViewById(R.id.time_choice);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.time_choices, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerTime.setAdapter(adapter);

        spinnerTime.setOnItemSelectedListener(this);
    }

    public void  addDrinkToSpinner(View rootView){

        Spinner spinnerDrink = (Spinner) rootView.findViewById(R.id.drink_choice);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.drink_choices, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerDrink.setAdapter(adapter);

        spinnerDrink.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

//        switch (parent.getId()) {
//            case R.id.exercise_choice:
//                Fragment ExerciseApiRequest = new Fragment();
//                FragmentTransaction  transaction = getFragmentManager().beginTransaction();
//
//                // Replace whatever is in the fragment_container view with this fragment,
//                // and add the transaction to the back stack
//                transaction.replace(R.id.exercise_choice, ExerciseApiRequest);
//                transaction.addToBackStack(null);
//
//                // Commit the transaction
//                transaction.commit();
//
//            case R.id.spinnerTime:
//
//            case spinnerDrink:
//
//        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}



