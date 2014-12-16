package com.example.elyseturner.howhappycanmyhourbe.activities.parsers;

import com.example.elyseturner.howhappycanmyhourbe.activities.interfaces.MyJsonParser;
import com.example.elyseturner.howhappycanmyhourbe.activities.models.DrinkModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by elyseturner on 12/15/14.
 */
public class DrinkParser implements MyJsonParser<DrinkModel> {
    public ArrayList<DrinkModel> drinkModelArrayList = new ArrayList<DrinkModel>();

    private static final String DRINK_NAME = "name";
    private static final String CALORIES_WORTH = "calories";


    public ArrayList<DrinkModel> parsePostingFromJsonString(String apiaryString)throws JSONException {

        JSONObject drinkJsonObject = new JSONObject(apiaryString);

        for(int i = 0; i< drinkJsonObject.length(); i++){
            DrinkModel drinkModel = new DrinkModel();

            drinkModel.setCalories(drinkJsonObject.getDouble(CALORIES_WORTH));
            drinkModel.setName(drinkJsonObject.getString(DRINK_NAME));

            drinkModelArrayList.add(drinkModel);

        }

        return drinkModelArrayList;
    }
}
