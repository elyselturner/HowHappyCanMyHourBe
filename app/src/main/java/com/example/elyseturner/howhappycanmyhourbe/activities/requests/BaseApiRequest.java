package com.example.elyseturner.howhappycanmyhourbe.activities.requests;

import android.os.AsyncTask;
import android.util.Log;

import com.example.elyseturner.howhappycanmyhourbe.activities.interfaces.ApiCallBack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by elyseturner on 12/10/14.
 */
public abstract class BaseApiRequest extends AsyncTask<Void, Void, String> {
    private final String LOG_TAG = "getJsonInfo";
    private ApiCallBack apiCallBack;
    public abstract String getUrl();

    public BaseApiRequest(ApiCallBack apiCallBack){
        this.apiCallBack = apiCallBack;
    }



    @Override
    protected String doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

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
            String apiaryString = buffer.toString();
            Log.d(LOG_TAG, "ApiaryString is " + apiaryString);
            return apiaryString;
        }


        catch (MalformedURLException e) {
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
        return null;
    }

    @Override
    protected void onPostExecute(String resultsString) {
       if(resultsString==null){
           apiCallBack.onFailure();
       }else{
           apiCallBack.onSuccess(resultsString);
       }
    }
}
