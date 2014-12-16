package com.example.elyseturner.howhappycanmyhourbe.activities.requests;

import android.os.AsyncTask;
import android.util.Log;

import com.example.elyseturner.howhappycanmyhourbe.activities.models.DrinkModel;
import com.example.elyseturner.howhappycanmyhourbe.activities.parsers.DrinkParser;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by elyseturner on 12/10/14.
 */
public abstract class DrinkApiRequest extends AsyncTask<Void, Void, ArrayList<DrinkModel>> {
    private final String NAME = "name";
    private final String CALORIES_WORTH = "calories";
    private final String LOG_TAG = "getJsonInfo";
    String apiaryString = "there was an error";

    public abstract String getUrl();

    @Override
    protected ArrayList<DrinkModel> doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        final String URL_BASE = "http://private-fdf43-exercise.apiary-mock.com/Exercise";

        try {
            String urlString = getUrl();
            URL urlToUSE = new URL(urlString);

            //this is opening the URL connection and connecting
            urlConnection = (HttpURLConnection) urlToUSE.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //this reads the input stream into a string
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            //if nothing is coming through don't try to read it and return null
            if (inputStream == null) {
                return null;
            }
            //we are passing the new input stream reader the input stream and giving the reader and stream to the new buffered reader
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            //while there are lines of code coming in, add the line to the string
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            apiaryString = buffer.toString();
            Log.d(LOG_TAG, "ApiaryString is " + apiaryString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            Log.d(LOG_TAG, "Ok it's making it to the last line...");
            ArrayList <DrinkModel> theInfoYouWanted = new DrinkParser().parsePostingFromJsonString(apiaryString);
            return theInfoYouWanted;
        } catch (JSONException e) {
            return null;
        }
    }
}
