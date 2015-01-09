package com.example.elyseturner.howhappycanmyhourbe.activities.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elyseturner.howhappycanmyhourbe.R;

/**
 * Created by elyseturner on 1/8/15.
 */
public class ResultsFragment extends Fragment{

    private static final String DRINKS_EARNED_KEY = "drinksEarned";
    private static final String DRINK_NAME_KEY = "drinkName";
    private double drinksEarned;
    private String drinkName;

    private void ResultsFragment (){
    }

    public static ResultsFragment newInstance(String drinkName, double drinksEarned){
        ResultsFragment resultsFragment = new ResultsFragment();

        Bundle bundle = new Bundle();

        bundle.putDouble(DRINKS_EARNED_KEY, drinksEarned);
        bundle.putString(DRINK_NAME_KEY, drinkName);

        resultsFragment.setArguments(bundle);

        return resultsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drinksEarned = getArguments().getDouble(DRINKS_EARNED_KEY);
        drinkName = getArguments().getString(DRINK_NAME_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_results, container, false);


        TextView  numberDrinks = (TextView) rootView.findViewById(R.id.number_drinks);
        numberDrinks.setText(String.valueOf(drinksEarned));

        TextView winningDrink = (TextView) rootView.findViewById(R.id.drink_type_text);
        winningDrink.setText(drinkName);

        Context context = getActivity();
        CharSequence text = "If you are over 21, please drink responsibly";
        int duration = Toast.LENGTH_SHORT;

        Toast.makeText(context, text, duration).show();

        return rootView;
    }
}
