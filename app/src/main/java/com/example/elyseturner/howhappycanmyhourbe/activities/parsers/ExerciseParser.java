package com.example.elyseturner.howhappycanmyhourbe.activities.parsers;

import com.example.elyseturner.howhappycanmyhourbe.activities.models.ExerciseModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by elyseturner on 12/15/14.
 */
public class ExerciseParser {

    public ArrayList<ExerciseModel> exerciseModelArrayList = new ArrayList<ExerciseModel>();

    private static final String EXERCISE_NAME = "name";
    private static final String CALORIES_BURNED = "calories";


    public ArrayList<ExerciseModel> parsePostingFromJsonString(String apiaryString)throws JSONException {

        JSONObject exerciseJsonObject = new JSONObject(apiaryString);

        for(int i = 0; i< exerciseJsonObject.length(); i++){
            ExerciseModel exerciseModel = new ExerciseModel();

            exerciseModel.setCalories(exerciseJsonObject.getDouble(CALORIES_BURNED));
            exerciseModel.setName(exerciseJsonObject.getString(EXERCISE_NAME));

            exerciseModelArrayList.add(exerciseModel);

        }

        return exerciseModelArrayList;
    }
}
