package com.example.elyseturner.howhappycanmyhourbe.activities.requests;

import com.example.elyseturner.howhappycanmyhourbe.activities.interfaces.ApiCallBack;

/**
 * Created by elyseturner on 12/10/14.
 */
public class DrinkApiRequest extends BaseApiRequest {

    public DrinkApiRequest(ApiCallBack apiCallBack) {
        super(apiCallBack);
    }

    @Override
    public String getUrl() {

        return "http://private-fdf43-exercise.apiary-mock.com/Exercise";
    }


//    protected void onPostExecute(String resultString) {
//        try {
//            ArrayList<DrinkModel> theInfoYouWanted = new DrinkParser().parsePostingFromJsonString(resultString);
//
//
//        } catch (JSONException e) {
//        }
//    }
}
