package com.example.elyseturner.howhappycanmyhourbe.activities.requests;

import com.example.elyseturner.howhappycanmyhourbe.activities.interfaces.ApiCallBack;
import com.example.elyseturner.howhappycanmyhourbe.activities.models.ExerciseModel;
import com.example.elyseturner.howhappycanmyhourbe.activities.parsers.ExerciseParser;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by elyseturner on 12/10/14.
 */
public class ExerciseApiRequest extends BaseApiRequest {

    public ExerciseApiRequest(ApiCallBack apiCallBack) {
        super(apiCallBack);
    }

    @Override
    public String getUrl() {
        return "http://private-ea722-drinks.apiary-mock.com/drinks";
    }

    @Override
    protected void onPostExecute(String resultsString) {
        try {
            ArrayList <ExerciseModel> theInfoYouWanted = new ExerciseParser().parsePostingFromJsonString(resultsString);

        } catch (JSONException e) {

        }
    }


}
