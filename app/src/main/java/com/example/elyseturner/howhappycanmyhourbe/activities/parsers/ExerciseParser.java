package com.example.elyseturner.howhappycanmyhourbe.activities.parsers;

import com.example.elyseturner.howhappycanmyhourbe.activities.models.ExerciseModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by elyseturner on 12/15/14.
 */
public class ExerciseParser {

        public ArrayList<ExerciseModel> exerciseModelArrayList = new ArrayList<ExerciseModel>();

        private static final String EXERCISE_NAME = "name";
        private static final String CALORIES_WORTH = "calories";


        public ArrayList<ExerciseModel> parsePostingFromJsonString(String apiaryString)  {

            JSONArray exerciseJsonArray = null;


            try {
                exerciseJsonArray = new JSONArray(apiaryString);
            } catch (JSONException e) {
                e.printStackTrace();
                return new ArrayList<ExerciseModel>();
            }

            for(int i = 0; i< exerciseJsonArray.length(); i++){
                JSONObject exerciseJSONObject = null;
                try {
                    exerciseJSONObject = exerciseJsonArray.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                ExerciseModel exerciseModel = new ExerciseModel();


                try {
                    int calories = exerciseJSONObject.getInt(CALORIES_WORTH);
                    exerciseModel.setCalories(calories);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new ArrayList<ExerciseModel>();
                }
                try {
                    String exerciseName = exerciseJSONObject.getString(EXERCISE_NAME);
                    exerciseModel.setName(exerciseName);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new ArrayList<ExerciseModel>();
                }

                exerciseModelArrayList.add(exerciseModel);

            }

            return exerciseModelArrayList;
        }
    }
