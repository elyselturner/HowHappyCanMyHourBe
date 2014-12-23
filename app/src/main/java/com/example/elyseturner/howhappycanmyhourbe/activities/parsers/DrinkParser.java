package com.example.elyseturner.howhappycanmyhourbe.activities.parsers;

import com.example.elyseturner.howhappycanmyhourbe.activities.models.DrinkModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by elyseturner on 12/15/14.
 */
public class DrinkParser  {
    public ArrayList<DrinkModel> drinkModelArrayList = new ArrayList<DrinkModel>();

    private static final String DRINK_NAME = "name";
    private static final String CALORIES_WORTH = "calories";


    public ArrayList<DrinkModel> parsePostingFromJsonString(String apiaryString)  {

        JSONArray drinkJsonArray = null;
        try {
            drinkJsonArray = new JSONArray(apiaryString);
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList<DrinkModel>();
        }

        for(int i = 0; i< drinkJsonArray.length(); i++){
            DrinkModel drinkModel = new DrinkModel();

            try {
                drinkModel.setCalories(drinkJsonArray.getDouble(CALORIES_WORTH));
            } catch (JSONException e) {
                e.printStackTrace();
                return new ArrayList<DrinkModel>();
            }
            try {
                drinkModel.setName(drinkJsonArray.getString(DRINK_NAME));
            } catch (JSONException e) {
                e.printStackTrace();
                return new ArrayList<DrinkModel>();
            }

            drinkModelArrayList.add(drinkModel);

        }

        return drinkModelArrayList;
    }
}
