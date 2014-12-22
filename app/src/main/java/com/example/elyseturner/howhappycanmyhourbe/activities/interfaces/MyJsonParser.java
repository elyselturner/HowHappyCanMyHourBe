package com.example.elyseturner.howhappycanmyhourbe.activities.interfaces;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by elyseturner on 12/18/14.
 */

public interface MyJsonParser<T> {
    public ArrayList<T> parsePostingFromJsonString(String apiaryString) throws JSONException;
}