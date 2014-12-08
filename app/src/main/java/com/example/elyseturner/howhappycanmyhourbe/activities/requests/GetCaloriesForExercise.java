package com.example.elyseturner.howhappycanmyhourbe.activities.requests;

import android.os.AsyncTask;
import android.util.Log;

import com.example.elyseturner.howhappycanmyhourbe.activities.models.FoodModel;
import com.example.elyseturner.howhappycanmyhourbe.activities.utils.FatSecretUtils;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 * Created by elyseturner on 12/8/14.
 */
public class GetCaloriesForExercise extends AsyncTask<String, Void, ArrayList <FoodModel>>{
    private final String URL_BASE = "http://platform.fatsecret.com/rest/server.api?method=foods.search&format=json&search_expression=";
    private String USER_INPUT = "";
    public String fatSecretString;

//    final TextView responseText = (TextView) findViewById(R.id.responseText);
//    responseText.setText("Searching foods for bananas...");

    //MAKE THIS A NEW CLASS AND REPLACE WITH AN ASYNC TASK

    //this makes a new gson object ...builder pattern avoids having a constutor
//    final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Override
    protected ArrayList<FoodModel> doInBackground(String... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader = null;
        USER_INPUT = params[0];

        try {
            String signedFoodSearchUrl = FatSecretUtils.sign("http://platform.fatsecret.com/rest/server.api?method=foods.search&format=json&search_expression=" + USER_INPUT);

            Log.d(TAG, "Signed foods.search URL = " + signedFoodSearchUrl);


            HttpURLConnection foodSearchConnection = (HttpURLConnection) new URL(signedFoodSearchUrl).openConnection();
            reader = new BufferedReader(new InputStreamReader(foodSearchConnection.getInputStream()));
            final String json = reader.readLine();


        return null;
    }



                //this is updating the text with response
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JsonObject response = gson.fromJson(json, JsonObject.class);
                        responseText.setText(gson.toJson(response));
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (OAuthExpectationFailedException e) {
                e.printStackTrace();
            } catch (OAuthCommunicationException e) {
                e.printStackTrace();
            } catch (OAuthMessageSignerException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
