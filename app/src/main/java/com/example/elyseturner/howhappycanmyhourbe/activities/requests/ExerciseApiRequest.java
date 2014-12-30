package com.example.elyseturner.howhappycanmyhourbe.activities.requests;

import com.example.elyseturner.howhappycanmyhourbe.activities.interfaces.ApiCallBack;

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

}
